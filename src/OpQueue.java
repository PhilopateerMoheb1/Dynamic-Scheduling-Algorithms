import java.util.Iterator;

public interface OpQueue {
    // add process to the queue
    public void enqueue(Operation process);
    // increment time, decrement time of LiftTime of operation and dequeue if leftTime == 0
    public Operation consumeTimeUnit();
    // get Iterator for iterate on queue of Operation
    public Iterator<Operation> iterate();
    // check if queue is empty of not
    public boolean isEmpty();
    // return Time
    public int getTimer();
    	public void setTimer(int t);

	public OpQueue clone() throws CloneNotSupportedException;
}
