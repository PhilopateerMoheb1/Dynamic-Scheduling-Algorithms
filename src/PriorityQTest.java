
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

public class PriorityQTest {
    @Test
    public void enqueuePriorityQTest1() {
        try {
            PriorityQ priorityQ = new PriorityQ();
            Operation o1 = new Operation(1, 4, 5);
            Operation o2 = new Operation(2, 0, 7);
            // Operation o3 = new Operation(3, 2, 7);
            // Operation o4 = new Operation(4, 3, 10);
            priorityQ.enqueue(o1);
            priorityQ.consumeTimeUnit();
            priorityQ.enqueue(o2);
            // q.enqueue(o3);
            // q.enqueue(o4);
        } catch (IllegalArgumentException e) {
            System.out.println("PASSED");
            return;
        }
        fail("Program doesn't throw illegal argument excption");
    }

    // 31
    @Test
    public void ConsumeTimeUnitTest1() {

        PriorityQ priorityQ = new PriorityQ();
        assertNull(priorityQ.consumeTimeUnit());

    }

    @Test
    public void PriorityQTest2() {
        PriorityQ priorityQ = new PriorityQ();
        Operation o1 = new Operation(1, 1, 1);
        Operation o2 = new Operation(2, 1, 2);
        Operation o3 = new Operation(3, 1, 3);
        Operation o4 = new Operation(4, 1, 4);
        priorityQ.enqueue(o1);
        priorityQ.enqueue(o2);
        priorityQ.enqueue(o3);
        priorityQ.enqueue(o4);
        assertNull(priorityQ.consumeTimeUnit());
        assertNotNull(priorityQ.consumeTimeUnit());
    }

    // 33
    @Test
    public void PriorityQTest3() {

        PriorityQ rr = new PriorityQ();
        Operation o1 = new Operation(1, 0, 1);
        rr.enqueue(o1);
        rr.consumeTimeUnit();
        assertNull(rr.consumeTimeUnit());
    }

    @Test
    public void priorityQTest4() {
        PriorityQ rr = new PriorityQ();
        Operation o1 = new Operation(1, 0, 3);
        Operation o2 = new Operation(2, 1, 7);
        Operation o3 = new Operation(3, 1, 4);
        Operation o4 = new Operation(4, 1, 6);
        rr.enqueue(o1);
        rr.enqueue(o2);
        rr.enqueue(o3);
        rr.enqueue(o4);
        rr.consumeTimeUnit();
        assertNotNull(rr.consumeTimeUnit());
    }

}
