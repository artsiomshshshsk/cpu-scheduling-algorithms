package Strategy;

import com.artsiom.util.Process;

import java.util.ArrayList;

public interface SchedulingStrategy {
    void run();
    void statistics(ArrayList<Process> resolved);
    ArrayList<Process> newProcesses(int time , ArrayList<Process> processes, ArrayList<Process> waitingProcesses);
}
