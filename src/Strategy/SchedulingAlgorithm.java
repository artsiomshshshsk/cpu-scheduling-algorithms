package Strategy;

import com.artsiom.util.Process;

import java.util.ArrayList;

public abstract class SchedulingAlgorithm{
    public void statistics(ArrayList<Process> resolved) {
        int waitingTime = 0;
        for(Process process: resolved){
            System.out.println(process);
            waitingTime += process.getWaitingTime();
        }
        System.out.println("Average waiting time:" + Math.round(waitingTime/resolved.size()));
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
