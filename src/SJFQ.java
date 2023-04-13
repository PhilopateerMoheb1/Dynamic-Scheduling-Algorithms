import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SJFQ implements OpQueue{
    protected Queue<Operation> q;
    protected Queue<Operation> temp;
    protected Queue<Operation> allProcess;
    protected int Timer;
    protected Operation servedProcess;

    public SJFQ(){
        q = new PriorityQueue<Operation>(new Comparators.SJFComparator());
        temp = new PriorityQueue<>(new Comparators.FCFSComparator());
        allProcess = new PriorityQueue<>(new Comparators.IDComparator());
        Timer = 0;
    }


    @Override
    public void enqueue(Operation process) {
        // check if process is come with arrival time in the past, in this case, drop it
        if (process.getArrival() < Timer)
            throw new IllegalArgumentException("ArrivalTime of operation cannot be before the timer");

        allProcess.add(process);
        // check if process will arrive in the future
        if (process.getArrival() > Timer)
            temp.add(process);
        // check if process is arrive in right(current) time
        else if (process.getArrival() == Timer)
            q.add(process);
    }

    @Override
    public Operation consumeTimeUnit() {
        Timer++;
        // check if arrival time of processes is come
        while (!temp.isEmpty() && temp.peek().getArrival() == Timer-1)
            q.add(temp.remove());
        // check if queue is empty, will return null
        if (q.isEmpty())
            return null;
        // check if no current process is executing currently
        if(servedProcess == null)
            servedProcess = q.peek();

        servedProcess.decrementTimeLeft(1);
        // check if current process is finished executing
        if(servedProcess.getTimeLeft() == 0){
            // remove exchange process from queue
            Operation endOp = servedProcess;
            q.remove(servedProcess);
            // set process's response time
            endOp.setResponseTime(Timer);
            // exchange the process to be executed
            servedProcess = q.peek();
            // return finished process
            return endOp;
        }
        return servedProcess;
    }

    @Override
    public Iterator<Operation> iterate() {
        return allProcess.iterator();
    }

    @Override
    public boolean isEmpty() {
        return q.isEmpty() && temp.isEmpty();
    }

    @Override
    public int getTimer() { return Timer; }

    public static void main(String[] args) {
//        SJFQ q = new SJFQ();
//        Operation o1 = new Operation(1,4,5);
//        Operation o2 = new Operation(2,5,7);
//        Operation o3 = new Operation(3,2,7);
//        Operation o4 = new Operation(4,3,10);
//        q.enqueue(o1);
//        q.enqueue(o2);
//        q.enqueue(o3);
//        q.enqueue(o4);
//        for (int i = 0; i <= 40; i++) {
//            if (i == 4)
//                q.enqueue(new Operation(5,5,2));
//            System.out.println("at time: " + q.getTimer() + ", process in exe: " + q.consumeTimeUnit() );
//        }
        SJFQ sjfq = new SJFQ();
        Operation o1 = new Operation(1, 1, 1);
        Operation o2 = new Operation(2, 1, 2);
        Operation o3 = new Operation(3, 1, 3);
        Operation o4 = new Operation(4, 1, 4);
        sjfq.enqueue(o1);
        sjfq.enqueue(o2);
        sjfq.enqueue(o3);
        sjfq.enqueue(o4);
        while (!sjfq.isEmpty()){
            System.out.println(sjfq.getTimer() + ": " + sjfq.consumeTimeUnit());
        }
    }

}
