package Strategy;

import Comparators.ProcessArrivalTimeComparator;
import Comparators.ProcessPhaseLengthComparator;
import com.artsiom.util.Data;
import com.artsiom.util.Process;
import com.artsiom.util.Queue;

import java.util.ArrayList;

public class SJF extends SchedulingAlgorithm implements SchedulingStrategy{
    @Override
    public void run(String filename) {
        System.out.println("___________________SJF________________________");
        ArrayList<Process> processes = Data.getDataSet(filename);
        ArrayList<Process> resolved = new ArrayList<>();
        Queue<Process> waitingQueue = new Queue<>();
        processes.sort(new ProcessArrivalTimeComparator());

        int time = 0;
        while(processes.size() != 0 || waitingQueue.size() != 0 ){
            waitingQueue = newProcesses(time, processes, waitingQueue);
            if(waitingQueue.size() != 0 ){
                waitingQueue.sort(new ProcessPhaseLengthComparator());  //Shortest

                Process temp = waitingQueue.pop();
                time = resolveProcess(temp, time);
                resolved.add(temp);
            }else{
                time++;
            }
        }
        statistics(resolved);
    }

    public int resolveProcess(Process temp, int time){
        if(time - temp.getAppearanceTime() < 0){
            temp.setWaitingTime(0);
        }else {
            temp.setWaitingTime(time - temp.getAppearanceTime());
        }
        while(temp.getRemainingTime() > 0){
            temp.setRemainingTime(temp.getRemainingTime()-1);
            time++;
        }
        return time;
    }
}
