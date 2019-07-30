package p2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(new Person(1, "Pesho")
                , new Person(1, "Ivan")
                , new Person(3, "Dragan"));
    }


    @Test(expected = OperationNotSupportedException.class)
    public void searchedUsernameShouldNotBeNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowAnExceptionIfMoreThanOneMatchIsFound() throws OperationNotSupportedException {
        database = new Database(new Person(1, "Pesho"),
                new Person(1, "Ivan"),
                new Person(3, "Dragan"),
                new Person(4, "Dragan"));

        database.findByUsername("Dragan");
    }

    @Test
    public void findByUsernameShouldCorectlySearchTheDatabase() throws OperationNotSupportedException {
        Person person = database.getElements()[1];
        Assert.assertEquals(person, database.findByUsername("Ivan"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByIdShouldThrowAnExceptionIfMoreThanOnePeopleAreFoundWithTheSameId() throws OperationNotSupportedException {
        database.findById(1L);
    }

    @Test
    public void findByIdFindsAPersonCorectly() throws OperationNotSupportedException {
        Assert.assertEquals(database.getElements()[2], database.findById(3L));
    }
}
