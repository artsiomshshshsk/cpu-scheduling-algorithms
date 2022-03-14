package Comparators;
import com.artsiom.util.Process;

import java.util.Comparator;

public class ProcessArrivalTimeComparator implements Comparator<Process> {
    @Override
    public int compare(Process process1, Process process2) {
        if(process1.getAppearanceTime() > process2.getAppearanceTime())return 1;
        if(process1.getAppearanceTime() < process2.getAppearanceTime())return -1;
        return 0;
    }
}
