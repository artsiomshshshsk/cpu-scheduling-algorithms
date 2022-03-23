package Strategy;

import Comparators.ProcessArrivalTimeComparator;
import Comparators.ProcessPhaseLengthComparator;
import Comparators.ProcessRemainingTimeComparator;
import com.artsiom.util.Data;
import com.artsiom.util.Process;
import com.artsiom.util.Queue;

import java.util.ArrayList;

public class SRTF extends SchedulingAlgorithm implements SchedulingStrategy{
    @Override
    public void run(String filename) {
        System.out.println("___________________SRTF________________________"); // Shortest remaining time first;
        ArrayList<Process> processes = Data.getDataSet(filename);
        ArrayList<Process> resolved = new ArrayList<>();
        Queue<Process> waitingQueue = new Queue<>();

        processes.sort(new ProcessArrivalTimeComparator());

        int time = 0;


        while (processes.size() != 0 || waitingQueue.size() != 0){
            waitingQueue = newProcesses(time, processes,waitingQueue);
            waitingQueue.sort(new ProcessRemainingTimeComparator());


            if(waitingQueue.size() != 0){
                Process temp = waitingQueue.first();

                temp.setRemainingTime(temp.getRemainingTime()-1);
                time++;

                if(temp.getRemainingTime() == 0) {
                    temp.setWaitingTime(time - temp.getAppearanceTime() - temp.getPhaseLength());
                    waitingQueue.pop();
                    resolved.add(temp);
                }
            }else{
                time++;
            }
        }
        statistics(resolved);
    }
}
