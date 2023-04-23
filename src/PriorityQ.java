import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQ implements OpQueue
 {

    protected Queue<Operation> readyQueue;
    protected Queue<Operation> temp;
    protected Queue<Operation> allProcess;
    protected int Timer;
    protected Operation servedProcess;

    public PriorityQ(){
        readyQueue = new PriorityQueue<Operation>(new Comparators.PriorityComparator());
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
        readyQueue.add(process);
    }

    @Override
    public Operation consumeTimeUnit() {
        Timer++;
        // check if arrival time of processes is come
        while (!temp.isEmpty() && temp.peek().getArrival() == Timer-1)
        readyQueue.add(temp.remove());
        // check if queue is empty, will return null
        if (readyQueue.isEmpty())
            return null;
        // check if no current process is executing currently
        if(servedProcess == null)
            servedProcess = readyQueue.peek();

        servedProcess.decrementTimeLeft(1);
        // check if current process is finished executing
        if(servedProcess.getTimeLeft() == 0){
            // remove exchange process from queue
            Operation endOp = servedProcess;
            readyQueue.remove(servedProcess);
            // set process's response time
            endOp.setResponseTime(Timer);
            // exchange the process to be executed
            servedProcess = readyQueue.peek();
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
        return readyQueue.isEmpty() && temp.isEmpty();
    }

    @Override
    public int getTimer() { return Timer; }
	@Override
	public void setTimer(int t) {
		Timer = t;

	}

	@Override
	public OpQueue clone() throws CloneNotSupportedException {
		PriorityQ tempQ = new PriorityQ();
		Iterator it = readyQueue.iterator();
		while (it.hasNext()) {
			Operation o = (Operation) (it.next());

			tempQ.readyQueue.add(o.clone());
		}
		it = allProcess.iterator();
		while (it.hasNext()) {
			Operation o = (Operation) (it.next());
			tempQ.allProcess.add(o.clone());
		}
		it = this.temp.iterator();
		while (it.hasNext()) {
			Operation o = (Operation) (it.next());
			tempQ.temp.add(o.clone());
		}
		if (servedProcess != null)
			tempQ.servedProcess = servedProcess.clone();
		tempQ.setTimer(Timer);
		return tempQ;
	}

    public static void main(String[] args) {
        
        PriorityQ priorityQ= new PriorityQ();
        Operation o1 = new Operation(1, 1, 2,1);
        Operation o2 = new Operation(2, 5, 2,5);
        Operation o3 = new Operation(3, 2, 3,2);
        Operation o4 = new Operation(4, 1, 4,8);
        priorityQ.enqueue(o1);
        priorityQ.enqueue(o2);
        priorityQ.enqueue(o3);
        priorityQ.enqueue(o4);
        while (!priorityQ.isEmpty()){
            System.out.println("At time "+priorityQ.getTimer() + ": " + priorityQ.consumeTimeUnit());
        }
    }

}

