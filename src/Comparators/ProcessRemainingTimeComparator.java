package Comparators;

import java.util.Comparator;
import com.artsiom.util.Process;

public class ProcessRemainingTimeComparator implements Comparator<Process> {
    @Override
    public int compare(Process process1, Process process2) {
        if(process1.getRemainingTime() > process2.getRemainingTime())return 1;
        if(process1.getRemainingTime() < process2.getRemainingTime())return -1;
        return 0;
    }
}
