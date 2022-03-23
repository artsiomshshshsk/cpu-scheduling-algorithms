package com.artsiom.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public class Data {

    public static void generateDataSet(String filename, int n, int minPhase, int maxPhase) {

        String filePath = "src/data/" + filename;
        File dataSet = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataSet))) {

            String header = String.format("%-15s %-15s %-15s\n", "PID", "Arrival time", "Phase Length");
            writer.write(header);
            Random random = new Random();

            for (int i = 0; i < n; i++) {
                int PID = i + 1;
                int appearanceTime = random.nextInt(n);
                int phaseLength = random.nextInt(minPhase, maxPhase);
                writer.write(String.format("%-15d %-15d %-15d\n", PID, appearanceTime, phaseLength));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<Process> getDataSet(String filename){
        String filePath = "src/data/"+filename;
        File dataSet = new File(filePath);
        ArrayList<Process> processes = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(dataSet))) {
            reader.readLine(); // read header

            String line = null;

            while((line = reader.readLine()) != null){
                String[] lineArray = line.split("\\s+");
                int PID = Integer.parseInt(lineArray[0]);
                int arrivalTime = Integer.parseInt(lineArray[1]);
                int phaseLength = Integer.parseInt(lineArray[2]);
                Process process = new Process(PID, phaseLength, arrivalTime);
                processes.add(process);
            }
            return processes;

        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {
        String filename = "small";

        generateDataSet(filename,20,1,20);
        ArrayList<Process> dataSet = getDataSet(filename);

        for(Process process: dataSet){
            System.out.println(process);
        }

    }
}
