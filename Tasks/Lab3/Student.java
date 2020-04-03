package com.company.utils;

public class Student {

    private int checkingProgress;
    private int load;
    private Type type;

    public Student(int load, Type type) {
        this.load = load;
        this.type = type;
    }

    public void increaseCheckingProgress(int value) {
        checkingProgress += value;
    }

    public boolean checkProgress() {
        return checkingProgress < load;
    }

    public int getCheckingProgress() {
        return checkingProgress;
    }

    public int getLoad() {
        return load;
    }

    public Type getType() {
        return type;
    }
}
