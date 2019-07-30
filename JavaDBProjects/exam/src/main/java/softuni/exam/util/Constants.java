package softuni.exam.util;

public class Constants {
    public final static String PLAYERS_JSON_IMPORT_FILE_PATH =
            "E:\\Java\\DB Projects\\JavaDB\\exam\\src\\main\\resources\\files\\json\\players.json";

    public final static String PICTURES_XML_IMPORT_FILE_PATH =
            "E:\\Java\\DB Projects\\JavaDB\\exam\\src\\main\\resources\\files\\xml\\pictures.xml";

    public final static String TEAMS_XML_IMPORT_FILE_PATH =
            "E:\\Java\\DB Projects\\JavaDB\\exam\\src\\main\\resources\\files\\xml\\teams.xml";

    public final static String INCORRECT_DATA_ENTITY_MESSAGE = "Invalid %s!";

    public final static String SUCCESSFUL_DATA_ENTITY_IMPORT_MESSAGE = "Successfully imported %s - %s";

    public final static String PLAYERS_FROM_NORTH_HUB_INFO = "\tPlayer name: %s %s - %s%n" +
            "\tNumber: %d";

    public final static String PLAYER_WITH_SALARY_GREATER_THAN_AMOUNT_INFO = "Player name: %s %s%n" +
            "\tNumber: %s%n" +
            "\tSalary: %s%n" +
            "\tTeam: %s";

    public Constants() {}
}
