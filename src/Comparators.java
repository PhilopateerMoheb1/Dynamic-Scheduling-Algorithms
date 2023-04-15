import java.util.Comparator;

public class Comparators {
    // arrange Process wrt Time left to be finished
    static class SJFComparator implements Comparator<Operation> {

        @Override
        public int compare(Operation o1, Operation o2) {
            if (o1.getTimeLeft() < o2.getTimeLeft())
                return -1;
            else if (o1.getTimeLeft() == o2.getTimeLeft())
                return 0;
            else
                return 1;
        }
    }
    // arrange Process wrt its arrival time
    static class FCFSComparator implements Comparator<Operation>{

        @Override
        public int compare(Operation o1, Operation o2) {
            if (o1.getArrival() < o2.getArrival())
                return -1;
            else if (o1.getArrival() == o2.getArrival())
                return 0;
            else
                return 1;
        }
    }
    // arrange Process wrt its ID
    static class IDComparator implements Comparator<Operation>{
        @Override
        public int compare(Operation o1, Operation o2) {
            if (o1.getID() < o2.getID())
                return -1;
            else if (o1.getID() == o2.getID())
                return 0;
            else
                return 1;
        }
    }

    static class PriorityComparator implements Comparator<Operation>{
        @Override
        public int compare(Operation o1, Operation o2) {
            if (o1.getPriority() < o2.getPriority())
                return -1;
            else if (o1.getPriority() == o2.getPriority())
                return 0;
            else
                return 1;
        }
    }

}
