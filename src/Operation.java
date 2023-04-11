public class Operation {
    // ================= attributes ==========================
    int priority; // priority of
    int timeLeft;
    int responseTime;
    final int id;
    final int arrivalTime;
    final int exeTime;

    public Operation(int id, int arrivalTime, int exeTime){
        this(id, arrivalTime, exeTime,5);
    }

    public Operation(int id, int arrivalTime, int exeTime, int priority){
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
    public void decrementTimeLeft(int val){
        this.timeLeft -= val;
    }

    public void setResponseTime(int currentTime) {
        this.responseTime = currentTime;
    }

    public void incrementPriority(int val){
        this.priority += val;
    }

    // process times

    public int getTATime() {
        if (responseTime == Integer.MAX_VALUE)
            return -1;
        return responseTime - arrivalTime;
    }

    public int getWaiting() {
        return getTATime() - exeTime;
    }
}
