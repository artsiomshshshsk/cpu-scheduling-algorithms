package Strategy;

import Comparators.ProcessArrivalTimeComparator;
import com.artsiom.util.Data;
import com.artsiom.util.Process;

import java.util.ArrayList;
import java.util.Queue;

public class FCFS extends SchedulingAlgorithm implements SchedulingStrategy{
    @Override
    public void run() {
        System.out.println("___________________FCFS________________________");

        ArrayList<Process> processes = Data.getDataSet();
        ArrayList<Process> resolved = new ArrayList<>();
        ArrayList<Process> waitingProcesses = new ArrayList<>();


        processes.sort(new ProcessArrivalTimeComparator());

        int time = 0 ;
        while(processes.size() != 0 || waitingProcesses.size() != 0 ){
            waitingProcesses = newProcesses(time, processes, waitingProcesses);
            if(waitingProcesses.size() != 0 ){
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
            }
            time++;
        }
        statistics(resolved);
    }


    public ArrayList<Process> newProcesses(int time , ArrayList<Process> processes,ArrayList<Process> waitingProcesses ){
        int num = 0;

        for(int i = 0; i < processes.size(); i++){
            Process process = processes.get(i);
            if(process.getAppearanceTime() <= time){
                waitingProcesses.add(process);
                num++;
            }else {
                break;
            }
        }

        while(num-- > 0){
            processes.remove(0);
        }

        return waitingProcesses;
    }







}
