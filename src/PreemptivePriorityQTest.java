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

public class PreemptivePriorityQTest {

    @Test
    public void enqueuePreemptivePriorityQTest1() {
        try {
            PreemptivePriorityQ preemptivePriorityQ = new PreemptivePriorityQ();
            Operation o1 = new Operation(1, 4, 5);
            Operation o2 = new Operation(2, 0, 7);
            // Operation o3 = new Operation(3, 2, 7);
            // Operation o4 = new Operation(4, 3, 10);
            preemptivePriorityQ.enqueue(o1);
            preemptivePriorityQ.consumeTimeUnit();
            preemptivePriorityQ.enqueue(o2);
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

        PreemptivePriorityQ preemptivePriorityQ = new PreemptivePriorityQ();
        assertNull(preemptivePriorityQ.consumeTimeUnit());

    }

    @Test
    public void PreemptivePriorityQTest2() {
        PreemptivePriorityQ priorityQ = new PreemptivePriorityQ();
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
    public void PreemptivePriorityQTest3() {

        PreemptivePriorityQ preemptivePriorityQ = new PreemptivePriorityQ();
        Operation o1 = new Operation(1, 0, 1);
        preemptivePriorityQ.enqueue(o1);
        preemptivePriorityQ.consumeTimeUnit();
        assertNull(preemptivePriorityQ.consumeTimeUnit());
    }

    @Test
    public void PreemptivePriorityQTest4() {
        PreemptivePriorityQ rr = new PreemptivePriorityQ();
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

    @Test
    public void PreemptivePriorityQTest5() {
        PreemptivePriorityQ rr = new PreemptivePriorityQ();
        Operation o1 = new Operation(1, 0, 3, 1);
        Operation o2 = new Operation(2, 0, 7, 2);
        rr.enqueue(o1);
        rr.enqueue(o2);
        assertEquals(o2, rr.consumeTimeUnit());
    }

    @Test
    public void PreemptivePriorityQTest6() {
        PreemptivePriorityQ rr = new PreemptivePriorityQ();
        Operation o1 = new Operation(1, 0, 7, 1);
        Operation o2 = new Operation(2, 0, 3, 1);
        Operation o3 = new Operation(3, 0, 1, 1);

        rr.enqueue(o1);
        rr.enqueue(o2);
        rr.enqueue(o3);
        assertEquals(o3, rr.consumeTimeUnit());
    }

}
