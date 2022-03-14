package Simulation;

import Comparators.ProcessArrivalTimeComparator;
import Strategy.FCFS;
import Strategy.SchedulingStrategy;

import java.util.ArrayList;

import com.artsiom.util.Data;
import com.artsiom.util.Process;

public class Simulation {

    SchedulingStrategy CPUSchedulingAlgorithm;
    ArrayList<Process> data;


    public Simulation(SchedulingStrategy CPUSchedulingAlgorithm) {
        this.CPUSchedulingAlgorithm = CPUSchedulingAlgorithm;
    }

    public void setCPUSchedulingAlgorithm(SchedulingStrategy CPUSchedulingAlgorithm) {
        this.CPUSchedulingAlgorithm = CPUSchedulingAlgorithm;
    }

    public void runSimulation(){
        CPUSchedulingAlgorithm.run();
    }

    public static void main(String[] args) {
        Simulation simulation = new Simulation(new FCFS());
        simulation.runSimulation();
    }
}
