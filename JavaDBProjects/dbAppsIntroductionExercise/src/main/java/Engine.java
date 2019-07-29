import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

public class Engine implements Runnable {
    private Connection connection;

    public Engine(Connection connection) {
        this.connection = connection;
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        /*
        2.	Get Villains’ Names
         */
//        try {
//            this.getVillainsNames();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        /*
        3.	Get Minion Names
         */
//        try {
//            this.getMinionNames(reader);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /*
        4.	Add Minion
         */
//        try {
//            this.addMinion(reader);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        /*
        5.	Change Town Names Casing
         */
//        try {
//            this.changeTownNameCasing(reader);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        /* 7.	Print All Minion Names */
//        try {
//            this.printAllMinionsNames();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        /* 8.	Increase Minions Age */
//        try {
//            this.increaseMinionsAge(reader);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        /* 9.	Increase Age Stored Procedure */
        try {
            this.increaseAgeStoredProcedure(reader);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*    2.	Get Villains’ Names     */

    private void getVillainsNames() throws SQLException {
        String query = "SELECT v.name, COUNT(mv.villain_id) AS 'count'\n" +
                "FROM villains AS v\n" +
                "JOIN minions_villains mv on v.id = mv.villain_id\n" +
                "GROUP BY mv.villain_id\n" +
                "HAVING count > 15\n" +
                "ORDER BY count DESC";

        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet result = statement.executeQuery();

        while (result.next()) {
            System.out.printf("%s %d%n", result.getString("name"), result.getInt("count"));
        }
    }

    /*    3.	Get Minion Names     */

    private void getMinionNames(BufferedReader reader) throws SQLException, IOException {
        int villainID = Integer.parseInt(reader.readLine());

        this.obtainAndPrintVillainsName(villainID);

        this.obtainAndPrintMinionsForGivenVillain(villainID);


    }
    private void obtainAndPrintVillainsName(int villainID) throws SQLException {
        String villainNameQuery = "SELECT v.name FROM villains AS v WHERE v.id = ?";

        PreparedStatement villainNameStmt = connection.prepareStatement(villainNameQuery);

        villainNameStmt.setInt(1, villainID);

        ResultSet result = villainNameStmt.executeQuery();

        if (!result.next()) {
            System.out.println(String.format("No villain with ID %d exists in the database.", villainID));
        } else {
            System.out.printf("Villain: %s%n", result.getString("name"));
        }
    }

    private void obtainAndPrintMinionsForGivenVillain(int villainID) throws SQLException {
        String minionsNames = "SELECT m.name, m.age\n" +
                "FROM minions AS m\n" +
                "JOIN minions_villains mv on m.id = mv.minion_id\n" +
                "WHERE villain_id = ?";

        PreparedStatement minionsExtractStmt = connection.prepareStatement(minionsNames);
        minionsExtractStmt.setInt(1, villainID);

        ResultSet minionsSet = minionsExtractStmt.executeQuery();

        int counter = 1;
        while (minionsSet.next()) {
            System.out.printf("%d. %s %d%n", counter++, minionsSet.getString("name"), minionsSet.getInt("age"));
        }
    }
    /*        4.	Add Minion         */
    private void addMinion(BufferedReader reader) throws IOException, SQLException {
        String[] minionData = reader.readLine().split("\\s+");
        String minionName = minionData[1];
        int minionAge = Integer.parseInt(minionData[2]);
        String minionTown = minionData[3];

        String[] villainData = reader.readLine().split("\\s+");
        String villainName = villainData[1];

        boolean townExists = this.checkIfMinionTownExists(minionTown);

        if (!townExists) {
            this.addNewTown(minionTown);
        }

        boolean villainExists = this.checkIfVillainExists(villainName);

        if (!villainExists) {
            this.addNewVillain(villainName);
        }

        this.addNewMinionToExistingVillain(minionName, minionAge, minionTown, villainName);
    }

    private void addNewMinionToExistingVillain(String name, int age, String town, String villain) throws SQLException {
        // INSERT INTO `minions`:
        String insertMinionQuery = "INSERT INTO minions(name, age, town_id) VALUES(?, ?, ?)";

        PreparedStatement insertMinionStmt = connection.prepareStatement(insertMinionQuery);
        int townId = this.getTownId(town);
        insertMinionStmt.setString(1, name);
        insertMinionStmt.setInt(2, age);

        insertMinionStmt.setInt(3, townId);

        insertMinionStmt.execute();

        // INSERT INTO `minions_villains` with corresponding villain id:
        String insertMinionToCorrespondingVillain = "INSERT INTO minions_villains(minion_id, villain_id) \n" +
                "VALUES (?, ?)";

        PreparedStatement insertMinionToCorrespondingVillainStmt = connection.prepareStatement(insertMinionToCorrespondingVillain);
        insertMinionToCorrespondingVillainStmt.setInt(1, this.getMinionId(name));
        insertMinionToCorrespondingVillainStmt.setInt(2, this.getVillainId(villain));

        insertMinionToCorrespondingVillainStmt.execute();
        System.out.println(String.format("Successfully added %s to be minion of %s.", name, villain));
    }
    private boolean checkIfVillainExists(String villainName) throws SQLException {
        String villainCheckQuery = "SELECT name FROM villains WHERE name = ?";

        PreparedStatement villainCheckStmt = connection.prepareStatement(villainCheckQuery);
        villainCheckStmt.setString(1, villainName);

        ResultSet result = villainCheckStmt.executeQuery();

        if (!result.next()) {
            return false;
        }
        return true;
    }

    private void addNewVillain(String villainName) throws SQLException {
        String insertVillainQuery = "INSERT INTO villains(name, evilness_factor) VALUES(?, 'evil')";

        PreparedStatement villainInsertStmt = connection.prepareStatement(insertVillainQuery);
        villainInsertStmt.setString(1, villainName);

        villainInsertStmt.execute();
        System.out.println(String.format("Villain %s was added to the database.", villainName));
    }

    private boolean checkIfMinionTownExists(String minionTown) throws SQLException {
        String townCheckQuery = "SELECT name FROM towns WHERE name = ?";

        PreparedStatement townCheckStmt = connection.prepareStatement(townCheckQuery);
        townCheckStmt.setString(1, minionTown);

        ResultSet result = townCheckStmt.executeQuery();

        if (!result.next()) {
            return false;
        }
        return true;
    }

    private void addNewTown(String minionTown) throws SQLException {
        String insertTownQuery = "INSERT INTO towns(name, country) VALUES(?, NULL)";

        PreparedStatement insertTownStmt = connection.prepareStatement(insertTownQuery);
        insertTownStmt.setString(1, minionTown);

        insertTownStmt.execute();
        System.out.println(String.format("Town %s was added to the database.", minionTown));
    }

    private int getVillainId(String name) throws SQLException {
        String getVillainId = "SELECT id FROM villains WHERE name = ?";

        PreparedStatement villainId = connection.prepareStatement(getVillainId);
        villainId.setString(1, name);

        ResultSet result = villainId.executeQuery();
        result.next();
        return result.getInt(1);
    }

    private int getTownId(String town) throws SQLException {
        String getTownId = "SELECT t.id\n" +
                "FROM towns AS t \n" +
                "WHERE name = ?";

        PreparedStatement townIdStmt = connection.prepareStatement(getTownId);
        townIdStmt.setString(1, town);

        ResultSet result = townIdStmt.executeQuery();
        result.next();
        return result.getInt(1);
    }

    private int getMinionId(String name) throws SQLException {
        String getMinionId = "SELECT id FROM minions WHERE name = ?";

        PreparedStatement minionId = connection.prepareStatement(getMinionId);
        minionId.setString(1, name);

        ResultSet result = minionId.executeQuery();
        result.next();
        return result.getInt(1);
    }



    /* 5.	Change Town Names Casing */
    private void changeTownNameCasing(BufferedReader reader) throws IOException, SQLException {
        String country = reader.readLine();

        String getCountOfAffectedRows = "SELECT count(id) FROM towns WHERE country = ?";

        PreparedStatement pstmt = connection.prepareStatement(getCountOfAffectedRows);
        pstmt.setString(1, country);

        ResultSet countResult = pstmt.executeQuery();
        countResult.next();
        int rows = countResult.getInt(1);

        if (rows == 0) {
            System.out.println("No town names were affected.");
        } else {
            String toUpperCaseQuery = "SELECT UPPER(name) AS 'name' FROM towns WHERE country = ?";

            PreparedStatement toUpperStmt = connection.prepareStatement(toUpperCaseQuery);
            toUpperStmt.setString(1, country);

            ResultSet affectedTowns = toUpperStmt.executeQuery();

            System.out.println(String.format("%d town names were affected.", rows));
            StringBuilder sb = new StringBuilder("[");

            while (affectedTowns.next()) {
                sb.append(affectedTowns.getString("name")).append(", ");
            }

            sb.delete(sb.length() - 2, sb.length());
            sb.append("]");
            System.out.println(sb.toString());
        }

    }

    /* 7.	Print All Minion Names */

    private void printAllMinionsNames() throws SQLException {
        List<String> names = new ArrayList<String>();

        String selectAllMinions = "SELECT name FROM minions";

        PreparedStatement stmt = connection.prepareStatement(selectAllMinions);

        ResultSet result = stmt.executeQuery();

        while (result.next()) {
            names.add(result.getString("name"));
        }

        for (int i = 0; i < names.size() / 2; i++) {
            System.out.println(names.get(i));
            System.out.println(names.get(names.size() - 1 - i));
        }

        if (names.size() % 2 == 1) {
            System.out.println(names.get(names.size() / 2));
        }
    }
    /* 8.	Increase Minions Age */

    private void increaseMinionsAge(BufferedReader reader) throws IOException, SQLException {

        int[] inputIds = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String minionUpdateQuery = "UPDATE minions\n" +
                "SET name = LOWER(name),\n" +
                "    age = age + 1\n" +
                "WHERE id = ?";

        PreparedStatement updateStmt = connection.prepareStatement(minionUpdateQuery);
        for (int inputId : inputIds) {
            updateStmt.setInt(1, inputId);
            updateStmt.execute();
        }

        String selectNameQuery = "SELECT name FROM minions";
        String selectAgeQuery = "SELECT age FROM minions";

        PreparedStatement selectNameStmt = connection.prepareStatement(selectNameQuery);
        PreparedStatement selectAgeStmt = connection.prepareStatement(selectAgeQuery);

        ResultSet namesResult = selectNameStmt.executeQuery();
        ResultSet agesResult = selectAgeStmt.executeQuery();

        //Not a legit option if we have minions with duplicate names.
        // The `name` field in DB does not have an unique constraint!!!
//        Map<String, Integer> minionsWithCorrespondingAge = new LinkedHashMap<>();

        List<String> minionNames = new ArrayList<>();
        List<Integer> minionAges = new ArrayList<>();

        while(namesResult.next() && agesResult.next()) {
            minionNames.add(namesResult.getString("name"));
            minionAges.add(agesResult.getInt("age"));
        }

        for (int i = 0; i < minionAges.size(); i++) {
            System.out.println(minionNames.get(i) + " " + minionAges.get(i));
        }
    }

    /* 9.	Increase Age Stored Procedure */
    private void increaseAgeStoredProcedure(BufferedReader reader) throws SQLException, IOException {
        String callProcedure = "CALL usp_get_older(?)";

        int id = Integer.parseInt(reader.readLine());

        PreparedStatement callProcedureStmt = connection.prepareStatement(callProcedure);
        callProcedureStmt.setInt(1, id);
        callProcedureStmt.execute();

        String selectMinion = "SELECT name, age FROM minions WHERE id = ?";

        PreparedStatement selectStmt = connection.prepareStatement(selectMinion);
        selectStmt.setInt(1, id);

        ResultSet result = selectStmt.executeQuery();

        while (result.next()) {
            System.out.printf("%s %d%n", result.getString("name"), result.getInt("age"));
        }
    }
}
