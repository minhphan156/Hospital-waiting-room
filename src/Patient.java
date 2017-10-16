public class Patient {
    private String name;
    private int priorityNumber;

    Patient(String name, int priorityNumber){
        this.name = name;
        this.priorityNumber = priorityNumber;
    }

    //get priority number from patient
    public int getPriorityNumber() {
        return priorityNumber;
    }

    public void setPriorityNumber(int newPriority){
        this.priorityNumber = newPriority;
    }
    //get patient's name
    public String getName() {
        return name;
    }
}
