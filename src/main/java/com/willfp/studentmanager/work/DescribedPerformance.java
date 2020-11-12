package com.willfp.studentmanager.work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DescribedPerformance {
    private final Performance performance;
    private final List<String> descriptions = new ArrayList<>(Collections.singletonList("Empty Description"));

    public DescribedPerformance(Performance performance) {
        this.performance = performance;
    }

    public void addDescription(String description) {
        if(this.descriptions.contains("Empty Description"))
            this.descriptions.clear();
        this.descriptions.add(description);
    }

    public String getRandomDescription() {
        Collections.shuffle(this.descriptions);
        return this.descriptions.get(0);
    }

    public Performance getPerformance() {
        return performance;
    }

    @Override
    public String toString() {
        return "DescribedPerformance{" +
                "performance=" + performance +
                ", descriptions=" + descriptions +
                '}';
    }
}
