import java.util.*;

public class FCFSQ implements OpQueue{
    private Queue<Operation> q;
    private Queue<Operation> allProcess;
    private int Timer;


    public FCFSQ(){
        q = new PriorityQueue<Operation>(new Comparators.FCFSComparator());
        allProcess = new PriorityQueue<>(new Comparators.IDComparator());
        Timer = 0;
    }

    @Override
    public void enqueue(Operation process) {
        if (process.getArrival() < Timer)
            return;
        q.add(process);
        allProcess.add(process);
    }

    @Override
    public Operation consumeTimeUnit() {
        // increment time
        Timer++;
        // get the first arrival process
        Operation head = q.peek();
        // check if the queue has process and the time to execute it is come
        if (head != null && head.getArrival() <= Timer -1) {
            head.decrementTimeLeft(1);
            // check if process is end
            if (head.getTimeLeft() == 0) {
                Operation endOp = q.remove();
                endOp.setResponseTime(Timer);
                head = q.peek();
                return endOp;
            }
            else
                return head;
        }
        return null;
    }

    @Override
    public Iterator<Operation> iterate() {
        return allProcess.iterator();
    }

    @Override
    public boolean isEmpty() {
        return q.isEmpty();
    }

    @Override
    public int getTimer() { return Timer; }

    // Class for Comparator to set Priority Queue to sort the new items



    public static void main(String[] args) {
        FCFSQ q = new FCFSQ();
        Operation o1 = new Operation(1,4,5);
        Operation o2 = new Operation(2,5,7);
        Operation o3 = new Operation(3,2,7);
        Operation o4 = new Operation(4,3,10);
        q.enqueue(o1);
        q.enqueue(o2);
        q.enqueue(o3);
        q.enqueue(o4);
        for (int i = 0; i <= 40; i++) {
            if (i == 4)
                q.enqueue(new Operation(5,5,2));
            System.out.println("at time: " + q.getTimer() + ", process in exe: " + q.consumeTimeUnit() );
        }

        Iterator i = q.iterate();
        Operation o;
        while (i.hasNext()){
            o = (Operation)i.next();
            System.out.println( o + " responseTime = " + o.getResponseTime());
        }
    }
}
