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
}
