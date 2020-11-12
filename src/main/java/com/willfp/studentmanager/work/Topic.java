package com.willfp.studentmanager.work;

import com.willfp.studentmanager.util.Nameable;

import java.util.HashSet;
import java.util.Set;

public class Topic implements Nameable {
    private final String name;
    private final Set<DescribedPerformance> performanceDescriptions = new HashSet<DescribedPerformance>() {{
        add(new DescribedPerformance(Performance.GOOD));
        add(new DescribedPerformance(Performance.OKAY));
        add(new DescribedPerformance(Performance.BAD));
    }};

    public Topic(String name) {
        this.name = name;
    }

    public void addPerformanceDescription(Performance performance, String description) {
        this.performanceDescriptions.stream().filter(describedPerformance -> describedPerformance.getPerformance().equals(performance)).findFirst().get().addDescription(description);
    }

    @Override
    public String getName() {
        return name;
    }

    public String getRandomDescription(Performance performance) {
        return this.performanceDescriptions.stream().filter(describedPerformance -> describedPerformance.getPerformance().equals(performance)).findFirst().get().getRandomDescription();
    }

    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                ", performanceDescriptions=" + performanceDescriptions +
                '}';
    }
}
