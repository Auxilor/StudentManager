package com.willfp.studentmanager.human;

import com.willfp.studentmanager.util.Nameable;
import com.willfp.studentmanager.work.Performance;
import com.willfp.studentmanager.work.Topic;

import java.util.HashMap;

public class Student implements Nameable {
    private final String name;
    private int targetGrade = 0;
    private int currentGrade = 0;
    private final HashMap<String, Performance> performances = new HashMap<>();

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getTargetGrade() {
        return targetGrade;
    }

    public int getCurrentGrade() {
        return currentGrade;
    }

    public HashMap<String, Performance> getPerformances() {
        return performances;
    }

    public Performance getPerformance(Topic topic) {
        return performances.get(topic.getName());
    }

    public void setPerformance(Topic topic, Performance performance) {
        this.performances.put(topic.getName(), performance);
    }

    public void setTargetGrade(int targetGrade) {
        this.targetGrade = targetGrade;
    }

    public void setCurrentGrade(int currentGrade) {
        this.currentGrade = currentGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", targetGrade=" + targetGrade +
                ", currentGrade=" + currentGrade +
                ", performances=" + performances +
                '}';
    }
}
