import java.util.Iterator;

public class PreemptiveSJFQ extends SJFQ {
    @Override
    public Operation consumeTimeUnit() {
        Timer++;
        // check if arrival time of processes is come
        while (!temp.isEmpty() && temp.peek().getArrival() == Timer-1)
            q.add(temp.remove());
        // check if queue is empty, will return null
        if (q.isEmpty())
            return null;

        servedProcess = q.peek();
        servedProcess.decrementTimeLeft(1);
        // check if current executed process is finished
        if(servedProcess.getTimeLeft() == 0){
            // remove current served process
            Operation endOp = servedProcess;
            q.remove(servedProcess);
            // set its response time
            endOp.setResponseTime(Timer);
            // exchange the current process to be executing
            servedProcess = q.peek();
            return endOp;
        }
        return servedProcess;
    }

    public static void main(String[] args) {
        PreemptiveSJFQ q = new PreemptiveSJFQ();
        Operation o1 = new Operation(1,4,5);
        Operation o2 = new Operation(2,25,7);
        Operation o3 = new Operation(3,4,7);
        Operation o4 = new Operation(4,0,10);
        q.enqueue(o1);
        q.enqueue(o2);
        q.enqueue(o3);
        q.enqueue(o4);
        while(!q.isEmpty()){
            if (q.getTimer() == 4)
                q.enqueue(new Operation(5,4,2));
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
