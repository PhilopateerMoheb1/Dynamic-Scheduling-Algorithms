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

public class RoundRobinTest {
    @Test
    public void enqueueSJFTest1() {
        try {
            RoundRobin sjfq = new RoundRobin(3);
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

    // 31
    @Test
    public void ConsumeTimeUnitTest1() {

        RoundRobin roundRobin = new RoundRobin(2);
        assertNull(roundRobin.consumeTimeUnit());

    }

    @Test
    public void DeadLockTestRoundRobin() {
        RoundRobin rr = new RoundRobin(2);
        Operation o1 = new Operation(1, 1, 1);
        Operation o2 = new Operation(2, 1, 2);
        Operation o3 = new Operation(3, 1, 3);
        Operation o4 = new Operation(4, 1, 4);
        rr.enqueue(o1);
        rr.enqueue(o2);
        rr.enqueue(o3);
        rr.enqueue(o4);
        assertNull(rr.consumeTimeUnit());
        assertNotNull(rr.consumeTimeUnit());
    }

    // 33
    @Test
    public void RoundRobinTest33() {

        RoundRobin rr = new RoundRobin(2);
        Operation o1 = new Operation(1, 0, 1);
        rr.enqueue(o1);
        rr.consumeTimeUnit();
        assertNull(rr.consumeTimeUnit());
    }

    @Test
    public void RoundRobinTest34() {
        RoundRobin rr = new RoundRobin(4);
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
