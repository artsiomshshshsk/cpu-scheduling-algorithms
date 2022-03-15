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
        ArrayList<Process> awaitingProcesses = new ArrayList<>();

        processes.sort(new ProcessArrivalTimeComparator());

        int time = 0;
        while (processes.size()!=0){

            for(int i = 0; i < processes.size();i++){
                Process p = processes.get(i);
                if(p.getAppearanceTime() <= time){
                    awaitingProcesses.add(p);
                }else{

                }
            }
            time++;
        }


        for(Process process:processes){
            System.out.println(process);
        }
    }

    @Override
    public ArrayList<Process> newProcesses(int time, ArrayList<Process> processes, ArrayList<Process> waitingProcesses) {
        return null;
    }
}
