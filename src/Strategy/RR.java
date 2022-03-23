package Strategy;

import Comparators.ProcessArrivalTimeComparator;
import com.artsiom.util.Data;
import com.artsiom.util.Process;
import com.artsiom.util.Queue;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class RR extends SchedulingAlgorithm implements SchedulingStrategy{
    private int timeQuantum;
    private ArrayList<Process> processes;
    private ArrayList<Process> resolved;
    private Queue<Process> waitingQueue;

    public RR(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    @Override
    public void run(String filename) {
        System.out.println("___________________Round Robin________________________");
        processes = Data.getDataSet(filename);
        processes.sort(new ProcessArrivalTimeComparator());

        resolved = new ArrayList<>();
        waitingQueue = new Queue<>();

        int time = 0;
        while(processes.size() != 0 || waitingQueue.size() != 0){
            waitingQueue = newProcesses(time, processes,waitingQueue);
            if(waitingQueue.size()!=0){
                Process temp = waitingQueue.pop();
                time = resolveProcess(temp, time);
            }else{
                time++;
            }
        }

        statistics(resolved);
    }


    public int resolveProcess(Process temp, int time){
        if(temp.getRemainingTime() <= timeQuantum){
            time += temp.getRemainingTime();
            temp.setRemainingTime(0);
            temp.setWaitingTime(time - temp.getAppearanceTime() - temp.getPhaseLength());
            resolved.add(temp);
        }else{
            time += timeQuantum;
            temp.setRemainingTime(temp.getRemainingTime() - timeQuantum);
            waitingQueue = newProcesses(time, processes,waitingQueue);
            waitingQueue.push(temp);
        }
        return time;
    }

}
