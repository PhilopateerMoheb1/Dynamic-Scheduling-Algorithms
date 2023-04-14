public class PreemptivePriorityQ extends PriorityQ
{
    @Override
    public Operation consumeTimeUnit() {
        Timer++;
        // check if arrival time of processes is come
        while (!temp.isEmpty() && temp.peek().getArrival() == Timer-1)
            readyQueue.add(temp.remove());
        // check if queue is empty, will return null
        if (readyQueue.isEmpty())
            return null;

        servedProcess = readyQueue.peek();
        servedProcess.decrementTimeLeft(1);
        // check if current executed process is finished
        if(servedProcess.getTimeLeft() == 0){
            // remove current served process
            Operation endOp = servedProcess;
            readyQueue.remove(servedProcess);
            // set its response time
            endOp.setResponseTime(Timer);
            // exchange the current process to be executing
            servedProcess = readyQueue.peek();
            return endOp;
        }
        return servedProcess;
    }


    public static void main(String[] args) {

    PreemptivePriorityQ priorityQ = new PreemptivePriorityQ();
    Operation o1 = new Operation(1, 0, 5,5);
    Operation o2 = new Operation(2, 4, 2,1);
    Operation o3 = new Operation(3, 2, 4,2);
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
