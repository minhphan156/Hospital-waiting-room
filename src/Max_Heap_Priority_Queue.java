import java.util.*;
import java.lang.*;


public class Max_Heap_Priority_Queue {
    private ArrayList<Patient> patientQueue = new ArrayList<>();

    //N is number of nodes in the tree, i is the node we analyzing
    public void maxHeapify(ArrayList<Patient> patientQueue, int i, int numberOfNodes ){
        int left = 2*i;                   //left child
        int right = 2*i +1;     //right child
        int largest;
        if(left<= numberOfNodes && patientQueue.get(left).getPriorityNumber() > patientQueue.get(i).getPriorityNumber())
            largest = left;
        else
        largest = i;
        if(right <= numberOfNodes && patientQueue.get(right).getPriorityNumber() > patientQueue.get(largest).getPriorityNumber() )
             largest = right;
        if(largest != i )
        {
            swap(patientQueue, i, largest);
            maxHeapify (patientQueue, largest,numberOfNodes);
        }
    }

    //swap patient who has higher priority
    public void swap(ArrayList<Patient> patientQueue, int lowerPriority, int higherPriority){
        Collections.swap(patientQueue,lowerPriority,higherPriority);

    }

    //build max heap from the tree
    public void buildMaxHeap(ArrayList<Patient> patientQueue){
       int numberOfNodes = patientQueue.size()-1;
       for(int i = numberOfNodes/2;  i >= 1; i--){
           maxHeapify(patientQueue,i,numberOfNodes);
       }

    }

    //remove and return patient with highest priority
    public Patient heapExtractMax(ArrayList<Patient> patientQueue){
        int numberOfNodes = patientQueue.size()-1;
        if(numberOfNodes == 0){
            System.out.println("Queue is empty!!!");
            return null;
        }

        Patient highestPriorityPatient = patientQueue.get(1);
        patientQueue.set(1,patientQueue.get(numberOfNodes));
        patientQueue.remove(numberOfNodes);
        maxHeapify(patientQueue,1,patientQueue.size());
        return highestPriorityPatient;
    }

    //insert new patient with new priority key
    public void maxHeapInsert(ArrayList<Patient> patientQueue, Patient newPatient){
        patientQueue.add(newPatient);
        heapIncreaseKey(patientQueue,patientQueue.size()-1,newPatient.getPriorityNumber());

    }

    //increase the priority for specific patient
    public void heapIncreaseKey(ArrayList<Patient>patientQueue,int i, int newPriorityNumber){
        if(newPriorityNumber < patientQueue.get(i).getPriorityNumber()){
            System.out.println("New priority number is lower than the patient current priority");
            return;
        }
        patientQueue.get(i).setPriorityNumber(newPriorityNumber);
        while(i > 1 &&
                patientQueue.get(i/2).getPriorityNumber() < patientQueue.get(i).getPriorityNumber()){
            swap(patientQueue,i/2,i);
            i = i/2;
        }
    }

    // return patient with highest priority
    public Patient heapMaximum(ArrayList<Patient> patientQueue){
        return patientQueue.get(1);
    }


    //sort heap in ascending order
    public void heapSort(ArrayList<Patient> patientQueue){
        int numberOfNodes = patientQueue.size();
        buildMaxHeap(patientQueue);
        for (int i = numberOfNodes-1; i >= 2; i--){
            swap(patientQueue,1,i);
            numberOfNodes = numberOfNodes-1;
            maxHeapify(patientQueue,1,numberOfNodes-1);
        }
    }

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
