
import org.junit.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;

public class FCFSQTest {

    @Test
    public void enqueueFCFSQTest1() {
        try {
            FCFSQ q = new FCFSQ();
            Operation o1 = new Operation(1, 4, 5);
            Operation o2 = new Operation(2, 0, 7);
            // Operation o3 = new Operation(3, 2, 7);
            // Operation o4 = new Operation(4, 3, 10);
            q.enqueue(o1);
            q.consumeTimeUnit();
            q.enqueue(o2);
            // q.enqueue(o3);
            // q.enqueue(o4);
        } catch (IllegalArgumentException e) {
            System.out.println("PASSED");
            return;
        }
        fail("Program doesn't throw illegal argument excption");
    }

    @Test
    public void consumeTimeUnitTest1() {
        try {
            FCFSQ q = new FCFSQ();
            // Operation o1 = new Operation(1, 4, 5);
            // Operation o2 = new Operation(2, 0, 7);
            // Operation o3 = new Operation(3, 2, 7);
            // Operation o4 = new Operation(4, 3, 10);
            // q.enqueue(o1);
            q.consumeTimeUnit();
            // q.enqueue(o2);
            // q.enqueue(o3);
            // q.enqueue(o4);
        } catch (NullPointerException e) {
            System.out.println("PASSED");
            return;
        }
        fail("Program doesn't throw NullPointer excption");
    }

    @Test
    public void consumeTimeUnitTest2() {
        try {
            FCFSQ q = new FCFSQ();
            Operation o1 = new Operation(1, 4, 1);
            // Operation o2 = new Operation(2, 0, 7);
            // Operation o3 = new Operation(3, 2, 7);
            // Operation o4 = new Operation(4, 3, 10);
            // q.enqueue(o1);
            q.consumeTimeUnit();
            // q.enqueue(o2);
            // q.enqueue(o3);
            // q.enqueue(o4);
        } catch (NullPointerException e) {
            System.out.println("PASSED");
            return;
        }
        fail("Program doesn't throw NullPointer excption");
    }

    @Test
    public void getIteratorTest1() {

        FCFSQ q = new FCFSQ();
        Iterator<Operation> iterator = q.iterate();
        assertFalse("Must be false", iterator.hasNext());

    }

}
