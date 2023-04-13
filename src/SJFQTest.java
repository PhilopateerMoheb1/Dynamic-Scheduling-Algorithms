import org.junit.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;

public class SJFQTest {
    @Test
    public void enqueueSJFTest1() {
        try {
            SJFQ sjfq = new SJFQ();
            Operation o1 = new Operation(1, 4, 5);
            Operation o2 = new Operation(2, 0, 7);
            // Operation o3 = new Operation(3, 2, 7);
            // Operation o4 = new Operation(4, 3, 10);
            sjfq.enqueue(o1);
            sjfq.consumeTimeUnit();
            sjfq.enqueue(o2);
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

        SJFQ sjfq = new SJFQ();
        Operation o1 = new Operation(1, 0, 1);
        Operation o2 = new Operation(2, 0, 2);
        Operation o3 = new Operation(3, 0, 3);
        Operation o4 = new Operation(4, 0, 4);
        sjfq.enqueue(o1);
        sjfq.enqueue(o2);
        sjfq.enqueue(o3);
        sjfq.enqueue(o4);
        Operation expected = new Operation(1, 0, 1);
        expected.decrementTimeLeft(1);
        assertEquals(expected.getTimeLeft(), sjfq.consumeTimeUnit().getTimeLeft());
    }

    @Test
    public void ConsumeTimeUnitTest1() {
        try {
            SJFQ sjfq = new SJFQ();
            sjfq.consumeTimeUnit();
        } catch (IllegalArgumentException e) {
            System.out.println("PASSED");
            return;
        }
        fail("Program doesn't throw illegal argument excption");
    }

    @Test
    public void DeadLockTest1() {
        SJFQ sjfq = new SJFQ();
        Operation o1 = new Operation(1, 1, 1);
        Operation o2 = new Operation(2, 1, 2);
        Operation o3 = new Operation(3, 1, 3);
        Operation o4 = new Operation(4, 1, 4);
        sjfq.enqueue(o1);
        sjfq.enqueue(o2);
        sjfq.enqueue(o3);
        sjfq.enqueue(o4);
        assertNotNull(sjfq.consumeTimeUnit());
    }

    @Test
    public void ConsumeTimeUnitTest3() {
        try {
            SJFQ sjfq = new SJFQ();
            Operation o1 = new Operation(1, 0, 1);
            sjfq.enqueue(o1);
            sjfq.consumeTimeUnit();
        } catch (IllegalArgumentException exception) {
            System.out.println("Passed");
            return;
        }
        fail("Program doesn't throw illegal argument excption");
    }

}
