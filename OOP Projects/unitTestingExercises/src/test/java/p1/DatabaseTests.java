package p1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {
    private static final Integer NUMBER = 5;

    private Database database;

    @Before
    public void setUpDatabase() throws OperationNotSupportedException {
        this.database = new Database(new Integer[3]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void classShouldNotInitializeANewInstanceIfLessThanOneArgumentsEnteredInConstructor() throws OperationNotSupportedException {
        database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void classShouldNotInitializeANewInstanceIfMoreThanSixteenArgumentsEnteredInConstructor() throws OperationNotSupportedException {
        database = new Database(new Integer[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addOperationShouldThrowAnExceptionWhenANullElementIsEntered() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void databaseShouldIncreaseLengthAfterAddingAnElement() throws OperationNotSupportedException {
        database.add(NUMBER);

        Assert.assertEquals(4, database.getElements().length);
    }

    @Test
    public void addingCommandShouldAddOnTheNextFreeCell() throws OperationNotSupportedException {
        database.add(NUMBER);

        Assert.assertEquals(NUMBER, database.getElements()[0]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removingAnElementFromAnEmptyDatabaseShouldThrowAnException() throws OperationNotSupportedException {
        database = new Database(new Integer[1]);

        database.remove();
        database.remove();
    }

    @Test
    public void removeOperationShouldReduceTheLengthOfTheDatabase() throws OperationNotSupportedException {
        database.remove();

        Assert.assertEquals(2, database.getElements().length);
    }
}
