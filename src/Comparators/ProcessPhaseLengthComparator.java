package Comparators;

import java.util.Comparator;
import com.artsiom.util.Process;

public class ProcessPhaseLengthComparator implements Comparator<Process> {
    @Override
    public int compare(Process process1, Process process2) {
        if(process1.getPhaseLength() > process2.getPhaseLength())return 1;
        if(process1.getPhaseLength() < process2.getPhaseLength())return -1;
        return 0;
    }
}
