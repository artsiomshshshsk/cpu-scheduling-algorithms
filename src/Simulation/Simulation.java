package Simulation;

import Comparators.ProcessArrivalTimeComparator;
import Strategy.*;

import java.util.ArrayList;

import com.artsiom.util.Data;
import com.artsiom.util.Process;

public class Simulation {

    private SchedulingStrategy CPUSchedulingAlgorithm;
    private String data;


    public Simulation(SchedulingStrategy CPUSchedulingAlgorithm,String data) {
        this.CPUSchedulingAlgorithm = CPUSchedulingAlgorithm;
        this.data = data;
    }

    public void setCPUSchedulingAlgorithm(SchedulingStrategy CPUSchedulingAlgorithm) {
        this.CPUSchedulingAlgorithm = CPUSchedulingAlgorithm;
    }

    public void runSimulation(){
        CPUSchedulingAlgorithm.run(data);
    }

    public static void main(String[] args) {
//        String dataFileName = "small";
//        String dataFileName = "medium";
        String dataFileName = "large";
//        String dataFileName = "test";
//        String dataFileName = "SRTF_better_than_SJF";
//        String dataFileName = "bad_for_FCFS";


        System.out.println("_____________________________________________");
        System.out.println();
        System.out.println("TOTAL NUMBER OF PROCESSES:" + Data.getDataSet(dataFileName).size());
        System.out.println();
//        System.out.println("_____________________________________________");
        System.out.println();

        Simulation simulation = new Simulation(new FCFS(), dataFileName);
        simulation.runSimulation();
        System.out.println();


        simulation.setCPUSchedulingAlgorithm(new SJF());
        simulation.runSimulation();
        System.out.println();

        simulation.setCPUSchedulingAlgorithm(new SRTF());
        simulation.runSimulation();
        System.out.println();

        simulation.setCPUSchedulingAlgorithm(new RR(1));;
        simulation.runSimulation();
        System.out.println();
    }
}
