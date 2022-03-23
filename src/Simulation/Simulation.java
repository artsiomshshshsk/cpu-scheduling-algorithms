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
        Simulation simulation = new Simulation(new FCFS(), "big");
        simulation.runSimulation();

        simulation.setCPUSchedulingAlgorithm(new SJF());
        simulation.runSimulation();

        simulation.setCPUSchedulingAlgorithm(new SRTF());
        simulation.runSimulation();
//
        simulation.setCPUSchedulingAlgorithm(new RR(50));;
        simulation.runSimulation();
    }
}
