package Strategy;

import Comparators.ProcessArrivalTimeComparator;
import com.artsiom.util.Data;
import com.artsiom.util.Process;

import java.util.ArrayList;

public class FCFS extends SchedulingAlgorithm implements SchedulingStrategy{
    @Override
    public void run() {
        System.out.println("___________________FCFS________________________");

        ArrayList<Process> processes = Data.getDataSet();
        ArrayList<Process> resolved = new ArrayList<>();
        processes.sort(new ProcessArrivalTimeComparator());

        int time = 0 ;
        while(processes.size() != 0){
            Process temp = processes.remove(0);

            while(time < temp.getAppearanceTime()){
                time++;
            }

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
        }
        statistics(resolved);
    }

}
