import org.junit.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

public class OperationTest {
    @Test
    public void getPriorityTest0() {

        try {
            Operation o = new Operation(1, 2, 3, 0);

        } catch (IllegalArgumentException e) {
            System.out.println("Passed");
        }
        fail("Program doesn't throw illgal argument excption");
    }

    @Test
    public void getPriorityTest1() {

        try {
            Operation o = new Operation(1, 2, 3, -1);

        } catch (IllegalArgumentException e) {
            System.out.println("Passed");
        }
        fail("Program doesn't throw illegal argument excption");
    }

    @Test
    public void getPriorityTest2() {

        Operation o = new Operation(1, 2, 3, 1);
        assertEquals(1, o.getPriority());

    }

    @Test
    public void getPriorityTest3() {

        Operation o = new Operation(1, 2, 3, 10);
        assertEquals(10, o.getPriority());
    }

    @Test
    public void getPriorityTest4() {

        try {
            Operation o = new Operation(1, 2, 3, 100);

        } catch (IllegalArgumentException e) {
            System.out.println("Passed");
        }
        fail("Program doesn't throw illegal argument excption");
    }

    @Test
    public void getPriorityTest5() {

        Operation o = new Operation(1, 2, 3, 9);
        assertEquals(9, o.getPriority());
    }

    @Test
    public void getPriorityTest6() {

        Operation o = new Operation(1, 2, 3, 5);
        assertEquals(5, o.getPriority());
    }

    @Test
    public void incrementPriorityTest1() {

        try {
            Operation o = new Operation(1, 2, 3, 10);
            o.incrementPriority(10);
        } catch (IllegalArgumentException e) {
            System.out.println("Passed");
            return;
        }
        fail("Program doesn't throw illegal argument excption");

    }

    @Test
    public void IDTest1() {

        try {
            Operation o = new Operation(-1, 2, 3, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Passed");
            return;
        }
        fail("Program doesn't throw illegal argument excption");

    }

    @Test
    public void ArrivalTimeTest1() {

        try {
            Operation o = new Operation(1, -2, 3, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Passed");
            return;
        }
        fail("Program doesn't throw illegal argument excption");

    }

    @Test
    public void ExeTimeTest1() {

        try {
            Operation o = new Operation(1, 2, -1, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Passed");
            return;
        }
        fail("Program doesn't throw illegal argument excption");

    }

    @Test
    public void ExeTimeTest2() {

        try {
            Operation o = new Operation(1, 2, 0, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Passed");
            return;
        }
        fail("Program doesn't throw illegal argument excption");

    }

    @Test
    public void ValidOperationTest1() {

        Operation o = new Operation(1, 2, 3, 5);
        assertEquals(1, o.getID());
        assertEquals(2, o.getArrival());
        assertEquals(3, o.getExecutionTime());
        assertEquals(5, o.getPriority());
        assertEquals(3, o.getTimeLeft());
        assertEquals(Integer.MAX_VALUE, o.getResponseTime());
        assertEquals(-1, o.getTATime());

    }

    @Test
    public void ExeTimeTest3() {

        try {
            Operation o = new Operation(1, 2, 1, 5);
            o.decrementTimeLeft(2);
        } catch (IllegalArgumentException e) {
            System.out.println("Passed");
            return;
        }
        fail("Program doesn't throw illegal argument excption");

    }

    @Test
    public void getWaitingTest1() {

        try {
            Operation o = new Operation(1, 2, 1, 5);
            o.getWaiting();
        } catch (IllegalArgumentException e) {
            System.out.println("Passed");
            return;
        }
        fail("Program doesn't throw illegal argument excption");

    }

    @Test
    public void setResponseTimeTest1() {

        try {
            Operation o = new Operation(1, 2, 1, 5);
            o.setResponseTime(-2);
        } catch (IllegalArgumentException e) {
            System.out.println("Passed");
            return;
        }
        fail("Program doesn't throw illegal argument excption");

    }

    @Test
    public void getTATimeTest1() {

        try {
            Operation o = new Operation(1, 2, 1, 5);
            o.setResponseTime(-2);
            o.getTATime();
        } catch (IllegalArgumentException e) {
            System.out.println("Passed");
            return;
        }
        fail("Program doesn't throw illegal argument excption");

    }

}
