import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Waiting_room {
    static final int QUEUE_CAPACITY = 20;

    public static void main (String [] args){
        String  listOfPatientName []= {"Kyra", "Keren", "Velvet", "Mila", "Leslie",
                "Julienne", "Argelia", "Loren", "Ashlea", "Cherish", "Kathryn",
                "Wanda", "Mayme","Milagro", "Elaina", "Jayne", "Dorthey",
                "Darryl", "Salome", "Catrina", "Keira", "Kaila",
                "Suzette", "Rhett", "Elfreda", "Claretta",
                "Curt", "Elwood", "Delbert"};
        ArrayList<Patient> patientsQueue = new ArrayList<>();
        Max_Heap_Priority_Queue priority_queue = new Max_Heap_Priority_Queue();
        Waiting_room waitRoom = new Waiting_room();

        System.out.println("\n************* BEFORE BUILD MAX HEAP ********************");
        patientsQueue = waitRoom.generatePatientQueue(listOfPatientName,patientsQueue);
        waitRoom.printQueue(patientsQueue);

        System.out.println("\n************* AFTER BUILD MAX HEAP ********************");
        priority_queue.buildMaxHeap(patientsQueue);
        waitRoom.printQueue(patientsQueue);

        System.out.println("\n************* AFTER HEAP EXTRACT MAX ********************");
        Patient patient = priority_queue.heapExtractMax(patientsQueue);
        waitRoom.printQueue(patientsQueue);
        System.out.println("Patient Name: " + patient.getName() + "\nPatient Number: " + patient.getPriorityNumber() );

        System.out.println("\n************* AFTER MAX HEAP INSERT  ********************");
        Patient patient1 = new Patient("Minh", 1234);
        System.out.println("New Patient: " + patient1.getName() + "\nNumber: " + patient1.getPriorityNumber());
        priority_queue.maxHeapInsert(patientsQueue,patient1);
        waitRoom.printQueue(patientsQueue);

        System.out.println("\n************* AFTER HEAP MAXIMUM ********************");
        Patient patient2 = priority_queue.heapMaximum(patientsQueue);
        waitRoom.printQueue(patientsQueue);
        System.out.println("Patient Name: " + patient2.getName() + "\nPatient Number: " + patient2.getPriorityNumber() );


        System.out.println("\n************* AFTER HEAP INCREASE KEY ********************");
        int newNumber = 1000;
        int queueIndex = 2;
        System.out.println("New priority number: " + newNumber + "\nAt the queue index: " + queueIndex);
        priority_queue.heapIncreaseKey(patientsQueue,queueIndex,newNumber);
        waitRoom.printQueue(patientsQueue);


        System.out.println("\n************* AFTER HEAP SORT********************");
        priority_queue.heapSort(patientsQueue);
        waitRoom.printQueue(patientsQueue);

    }

    // IMPORTANT: patient queue actually has 21 items including one dummy; index from 0 to 20
    ArrayList<Patient> generatePatientQueue(String []listOfPatientName, ArrayList<Patient> patientsQueue){
        patientsQueue.add(new Patient("dummyPatient",-1));
        for(int i = 1; i < QUEUE_CAPACITY+1; i++) {
            Random rand = new Random();
            int n = rand.nextInt(900) + 1;

            patientsQueue.add(i,(new Patient(listOfPatientName[i],n)));
        }
        return patientsQueue;

    }

    // print out patient start with index 1 to 20, we ignore index 0 and size of queue is 21
    public void printQueue(ArrayList<Patient> patientsQueue){
        Iterator<Patient> itr = patientsQueue.iterator();
            int i = 0;
            double level = 0;
        while (itr.hasNext()) {
            if (i == 0) {
                itr.next();
                i++;
                System.out.print("");
            } else {
                while (level < 5) {
                    double numOfMaxNode = Math.pow(2, level);
                    while (i < numOfMaxNode * 2 && i < 21 && itr.hasNext()) {

                        Patient temp = itr.next();

                        System.out.print(" " + temp.getPriorityNumber()
                                 + "-" + temp.getName()
                        );
                        i++;
                    }
                    level++;
                    System.out.println();
                }
            }
        }
    }



}
