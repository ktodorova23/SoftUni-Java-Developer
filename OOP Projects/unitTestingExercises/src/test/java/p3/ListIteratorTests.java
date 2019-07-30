package p3;

import org.junit.Before;
import org.junit.Test;
import p03_IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTests {
    private ListIterator listIterator;

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator("first", "second", "third");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void listIteratorShouldNotBeAbleToBeInstantiatedIfReceivingNull() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }


}
