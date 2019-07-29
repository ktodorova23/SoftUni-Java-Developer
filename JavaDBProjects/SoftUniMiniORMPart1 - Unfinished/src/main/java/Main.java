import entities.User;
import orm.Connector;
import orm.EntityManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connector.createConnection("root", "1234", "minions_db");

        Connection connection = Connector.getConnection();

        User user = new User("root", "1234", 25, Date.valueOf("2019-05-06"));

        EntityManager<User> userManager = new EntityManager<User>(connection);

        userManager.persist(user); // insert
        user.setPassword("23456");
        userManager.persist(user); //update
    }
}
