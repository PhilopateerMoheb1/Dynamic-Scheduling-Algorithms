public class Operation {
    // ================= attributes ==========================
    private int priority;
    private int timeLeft;
    private int responseTime;
    private final int id;
    private final int arrivalTime;
    private final int exeTime;

    public Operation(int id, int arrivalTime, int exeTime){
        this(id, arrivalTime, exeTime,5);
    }

    public Operation(int id, int arrivalTime, int exeTime, int priority) throws IllegalArgumentException{
        if (priority > 10 || priority < 1)
            throw new IllegalArgumentException("priority must be in range from 1 to 10");
        if (id < 0)
            throw new IllegalArgumentException("id must be positive integer");
        if (arrivalTime < 0)
            throw new IllegalArgumentException("arrivalTime cannot be negative");
        if (exeTime < 1)
            throw new IllegalArgumentException("execution time must be positive");
        if (exeTime > Short.MAX_VALUE)
            throw new IllegalArgumentException("execution time must limited");
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.exeTime = exeTime;
        this.priority = priority;
        this.timeLeft = exeTime;
        this.responseTime = Integer.MAX_VALUE;

    }
    // get methods
    public int getTimeLeft() { return timeLeft; }

    public int getPriority() { return priority; }

    public int getResponseTime() { return responseTime; }

    public int getID() { return id; }

    public int getExecutionTime() { return exeTime; }

    public int getArrival() { return arrivalTime; }

    // set methods
    public void decrementTimeLeft(int val) throws IllegalArgumentException{
        if (this.timeLeft - val < 0)
            throw new IllegalArgumentException("cannot decrement Time lift to negativeTIme");
        this.timeLeft -= val;
    }

    public void setResponseTime(int currentTime) throws IllegalArgumentException{
        if (currentTime < 0)
            throw new IllegalArgumentException("Time to finish cannot be negative");
        if (currentTime < arrivalTime)
            throw new IllegalArgumentException("Time to finish cannot be before arrival time");
        this.responseTime = currentTime;
    }

    public void incrementPriority(int val) throws IllegalArgumentException{
        if (priority +val > 10 || priority+val < 1)
            throw new IllegalArgumentException("priority must be in range from 1 to 10");
        this.priority += val;
    }

    // process times

    public int getTATime() {
        if (responseTime == Integer.MAX_VALUE)
//            throw new IllegalArgumentException("cannot calc TATime before set the Time to Finish");
            return -1;
        return responseTime - arrivalTime;
    }

    public int getWaiting() {
        if (responseTime != Integer.MAX_VALUE)
            return getTATime() - exeTime;
        else
            return -1;
    }

    // addition method
    @Override
    public String toString(){
        return "id: " + this.id +", arrival: " + this.arrivalTime + ", exeTime: " + this.exeTime + ", time left: " + timeLeft;
    }
        public void setTimeLeft(int val)
    { 
    	timeLeft = val ;
    }
 @Override
    protected Operation clone() throws CloneNotSupportedException {
    	Operation o = new Operation(id,arrivalTime,exeTime,priority);
    	o.setResponseTime(responseTime);
    	o.setTimeLeft(timeLeft);
    	return o ;
    }
    public static void main(String[] args) {
        Operation o = new Operation(1,1,32000);
        System.out.println(o);
    }
}
