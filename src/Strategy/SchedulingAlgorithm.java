package Strategy;

import com.artsiom.util.Process;
import com.artsiom.util.Queue;

import java.util.ArrayList;

public abstract class SchedulingAlgorithm{

    public void statistics(ArrayList<Process> resolved) {
        int waitingTime = 0;
        for(Process process: resolved){
//            System.out.println(process);
            waitingTime += process.getWaitingTime();
        }
        System.out.printf("Average waiting time:%.2f\n", (double)waitingTime/(double) resolved.size());
        System.out.println();
    }

    public Queue<Process> newProcesses(int time , ArrayList<Process> processes, Queue<Process> waitingProcesses ){
        int num = 0;
        for(int i = 0; i < processes.size(); i++){
            Process process = processes.get(i);
            if(process.getAppearanceTime() <= time){
                waitingProcesses.push(process);
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
