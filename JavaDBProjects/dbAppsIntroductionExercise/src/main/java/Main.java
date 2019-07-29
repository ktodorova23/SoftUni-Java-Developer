import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class Main {
    private static String CONNECTION_URL = "jdbc:mysql://localhost:3306/minions_db";
    public static void main(String[] args) throws IOException, SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1234");

        Connection connection = DriverManager.getConnection(CONNECTION_URL, properties);

        Engine engine = new Engine(connection);
        engine.run();
    }
}
