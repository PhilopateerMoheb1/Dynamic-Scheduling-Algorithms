import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class RoundRobinModified implements OpQueue
{
    private Queue<Operation> readyQueue;
    private Queue<Operation> allProcess;
    private Queue<Operation> temp;
    private int quantum;
    private int timer;
    private int endTime;
    private Operation currentProcess;

    public RoundRobinModified(int quantum) {
        this.quantum = quantum;
        this.readyQueue =  new LinkedList<Operation>();
        this.temp = new PriorityQueue<>(new Comparators.FCFSComparator());
        this.allProcess = new PriorityQueue<>(new Comparators.IDComparator());
        this.timer = 0;
        this.endTime = this.quantum;
    }

    @Override
    public void enqueue(Operation process) throws IllegalArgumentException{
        // check if process is come with arrival time in the past, in this case, drop it
        if (process.getArrival() < timer)
            throw new IllegalArgumentException("ArrivalTime of operation cannot be before the timer");
        allProcess.add(process);
        // check if process will arrive in the future
        if (process.getArrival() > timer)
            temp.add(process);
        // check if process is arrive in right(current) time
        else if (process.getArrival() == timer )
            readyQueue.add(process);
    }

    @Override
    public Operation consumeTimeUnit() {
        timer++;
    
        // Check if the current process has finished
        if (currentProcess != null && currentProcess.getTimeLeft() == 0) {
            Operation endOp = readyQueue.remove();
            endOp.setResponseTime(timer - 1);
            currentProcess = null;
            return endOp;
        }
    
        // Add any newly arrived processes to the ready queue
        while (!temp.isEmpty() && temp.peek().getArrival() <= timer-1)
            readyQueue.add(temp.remove());
    
        // Check if the ready queue is empty
        if (readyQueue.isEmpty()) {
            currentProcess = null;
            return null;
        }
    
        // Get the next process from the ready queue
   
        currentProcess = readyQueue.peek();
    
        // Decrement the current process's time left by 1
        currentProcess.decrementTimeLeft(1);
        endTime--;
    
        // Check if the current process has finished
        if (currentProcess.getTimeLeft() == 0) {
            Operation endOp = readyQueue.remove();
            endOp.setResponseTime(timer);
            currentProcess = null;
            if (!readyQueue.isEmpty())
                currentProcess = readyQueue.peek();
            endTime = quantum;
            return endOp;
        }
    
        // Check if the current process has exceeded its quantum
        if (endTime == 0 && currentProcess.getTimeLeft() > 0) {
            readyQueue.remove();
            readyQueue.offer(currentProcess);
            endTime = quantum;
        }
    
        return currentProcess;
    }
    
    @Override
    public Iterator<Operation> iterate() {
        return allProcess.iterator();
    }

    @Override
    public boolean isEmpty() {
        return readyQueue.isEmpty();
    }

    @Override
    public int getTimer() {
        return (timer-1);
    }

    public static void main(String[] args) {
        OpQueue queue = new RoundRobinModified(4);
        queue.enqueue(new Operation(1, 1, 10));
        queue.enqueue(new Operation(2, 4, 3));
        queue.enqueue(new Operation(3, 2, 16));
        queue.enqueue(new Operation(4, 19 , 1));
        queue.enqueue(new Operation(5, 5, 1));
        queue.enqueue(new Operation(6, 35, 1));

        Operation o ;


        for (int i = 0; i <= 50; i++) {
            o=queue.consumeTimeUnit() ;
            System.out.println("at time: " + queue.getTimer() + ", process being executing : " + o);
        }


        Iterator<Operation> i = queue.iterate();
        Operation o1;
        while (i.hasNext()){
            o1 = (Operation)i.next();
            System.out.println( o1 + " responseTime = " + o1.getResponseTime());
        }
  
    }

}

       
