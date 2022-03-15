package Strategy;

import Comparators.ProcessArrivalTimeComparator;
import Comparators.ProcessPhaseLengthComparator;
import com.artsiom.util.Data;
import com.artsiom.util.Process;

import java.util.ArrayList;

public class SJF extends SchedulingAlgorithm implements SchedulingStrategy{
    @Override
    public void run() {
        System.out.println("___________________SJF________________________");
        ArrayList<Process> processes = Data.getDataSet();
        ArrayList<Process> resolved = new ArrayList<>();
        ArrayList<Process> waitingProcesses = new ArrayList<>();
        processes.sort(new ProcessArrivalTimeComparator());

        int time = 0;
        while(processes.size() != 0 || waitingProcesses.size() != 0 ){
            waitingProcesses = newProcesses(time, processes, waitingProcesses);
            if(waitingProcesses.size() != 0 ){
                waitingProcesses.sort(new ProcessPhaseLengthComparator());  //Shortest

                Process temp = waitingProcesses.remove(0);
                if(time - temp.getAppearanceTime() < 0){
                    temp.setWaitingTime(0);
                }else {
                    temp.setWaitingTime(time - temp.getAppearanceTime());
                }
                while(temp.getRemainingTime() > 0){
                    temp.setRemainingTime(temp.getRemainingTime()-1);
                    time++;
                }
                resolved.add(temp);
            }else{
                time++;
            }
    }
        statistics(resolved);
}
}
