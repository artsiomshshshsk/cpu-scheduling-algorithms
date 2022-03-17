package com.artsiom.util;

public class Process {
    int PID;
    int phaseLength;
    int appearanceTime;
    int waitingTime;
    int remainingTime;

    public Process(int PID, int phaseLength, int appearanceTime) {
        this.PID = PID;
        this.phaseLength = phaseLength;
        this.appearanceTime = appearanceTime;
        this.remainingTime = phaseLength;

    }


    public int getPID() {
        return PID;
    }

    public int getPhaseLength() {
        return phaseLength;
    }

    public int getAppearanceTime() {
        return appearanceTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    @Override
    public String toString() {
        return "Process{" +
                "PID=" + PID +
                ", phaseLength=" + phaseLength +
                ", appearanceTime=" + appearanceTime +
                ", waitingTime=" + waitingTime +
                ", remaining time=" + remainingTime +
                '}';
    }
}
