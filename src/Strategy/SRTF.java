package Strategy;

import Comparators.ProcessArrivalTimeComparator;
import Comparators.ProcessPhaseLengthComparator;
import Comparators.ProcessRemainingTimeComparator;
import com.artsiom.util.Data;
import com.artsiom.util.Process;

import java.util.ArrayList;

public class SRTF extends SchedulingAlgorithm implements SchedulingStrategy{
    @Override
    public void run() {
        System.out.println("___________________SRTF________________________"); // Shortest remaining time first;
        ArrayList<Process> processes = Data.getDataSet();
        ArrayList<Process> resolved = new ArrayList<>();
        ArrayList<Process> waitingProcesses = new ArrayList<>();

        processes.sort(new ProcessArrivalTimeComparator());

        int time = 0;
        while (processes.size() != 0 || waitingProcesses.size() != 0){
            waitingProcesses = newProcesses(time, processes,waitingProcesses);
            waitingProcesses.sort(new ProcessRemainingTimeComparator());

            if(waitingProcesses.size() != 0){
                Process temp = waitingProcesses.get(0);
                temp.setRemainingTime(temp.getRemainingTime()-1);
                time++;

                if(temp.getRemainingTime() == 0) {
                    temp.setWaitingTime(time - temp.getAppearanceTime() - temp.getPhaseLength());
                    waitingProcesses.remove(0);
                    resolved.add(temp);
                }
            }else{
                time++;
            }
        }
        statistics(resolved);
    }
}
