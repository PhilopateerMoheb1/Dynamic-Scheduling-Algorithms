import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class RoundRobin implements OpQueue
{
        private Queue<Operation> readyQueue;
        private Queue<Operation> allProcess;
        private Queue<Operation> temp;
        private int quantum;
        private int timer;
        private Operation currentProcess;

        public RoundRobin(int quantum) {
          this.quantum = quantum;
          this.readyQueue =  new LinkedList<Operation>();
          this.temp = new PriorityQueue<>(new Comparators.FCFSComparator());
          this.allProcess = new PriorityQueue<>(new Comparators.IDComparator());
          this.timer = 0;
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
        while (!temp.isEmpty() && temp.peek().getArrival() <= timer-1)
            readyQueue.add(temp.remove());

        // check if queue is empty, will return null
        if (readyQueue.isEmpty())
        {
            return null;
        }
        
        currentProcess = readyQueue.peek();
        int timeLeft = currentProcess.getTimeLeft();

        //checks wheather the burstTime is greater than quantum or not
        if (timeLeft > quantum) 
        {
            currentProcess.decrementTimeLeft(quantum);
            readyQueue.remove(currentProcess);
            timer=(timer-1)+quantum;
            while (!temp.isEmpty() && temp.peek().getArrival() <= timer-1)
                 readyQueue.add(temp.remove());
            readyQueue.offer(currentProcess); // adds the uncompleted process to back of queue 
         } 
        else 
        {
            currentProcess.decrementTimeLeft(timeLeft);
            //check if process is end
            if (currentProcess.getTimeLeft() == 0) {
                Operation endOp = readyQueue.remove();
                timer+=timeLeft-1;
                endOp.setResponseTime(timer);
                currentProcess = readyQueue.peek();
                return endOp;
            }
             
       
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
        return timer;
    }


    public static void main(String[] args) {
        OpQueue queue = new RoundRobin(4);
        queue.enqueue(new Operation(1, 1, 10));
        queue.enqueue(new Operation(2, 4, 3));
        queue.enqueue(new Operation(3, 3, 16));
        queue.enqueue(new Operation(4, 19 , 1));
        queue.enqueue(new Operation(5, 5, 1));

        Operation o ;


        for (int i = 0; i <= 10; i++) {
            // if (i == 4)
            o=queue.consumeTimeUnit() ;
            
            System.out.println("at time: " + queue.getTimer() + ", process finished exe: " + o);
        }


        Iterator i = queue.iterate();
        Operation o1;
        while (i.hasNext()){
            o1 = (Operation)i.next();
            System.out.println( o1 + " responseTime = " + o1.getResponseTime());
        }
  
    }

}
