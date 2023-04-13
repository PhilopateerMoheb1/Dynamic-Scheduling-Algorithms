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

public class PreemptiveSJFQTest {
    @Test
    public void PreemptiveSJFQTest1() {

        PreemptiveSJFQ preemptiveSJFQ = new PreemptiveSJFQ();
        Operation o1 = new Operation(1, 0, 1);
        preemptiveSJFQ.enqueue(o1);
        preemptiveSJFQ.consumeTimeUnit();
        assertNull(preemptiveSJFQ.consumeTimeUnit());
    }

    @Test
    public void DeadLockTestPreemptiveSJFQ() {
        PreemptiveSJFQ preemptiveSJFQ = new PreemptiveSJFQ();
        Operation o1 = new Operation(1, 1, 1);
        Operation o2 = new Operation(2, 1, 2);
        Operation o3 = new Operation(3, 1, 3);
        Operation o4 = new Operation(4, 1, 4);
        preemptiveSJFQ.enqueue(o1);
        preemptiveSJFQ.enqueue(o2);
        preemptiveSJFQ.enqueue(o3);
        preemptiveSJFQ.enqueue(o4);
        assertNull(preemptiveSJFQ.consumeTimeUnit());
        assertNotNull(preemptiveSJFQ.consumeTimeUnit());
    }

    @Test
    public void PreemptiveSJFQTest2() {

        PreemptiveSJFQ preemptiveSJFQ = new PreemptiveSJFQ();
        assertNull(preemptiveSJFQ.consumeTimeUnit());

    }
}