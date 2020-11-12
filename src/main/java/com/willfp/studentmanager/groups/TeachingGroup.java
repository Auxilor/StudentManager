package com.willfp.studentmanager.groups;

import com.willfp.studentmanager.work.Topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeachingGroup extends Group {
    private final List<Topic> topics = new ArrayList<>();

    public TeachingGroup(String name) {
        super(name);
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void addTopic(Topic topic) {
        this.topics.add(topic);
    }

    public Topic getTopicByName(String name) {
        Optional<Topic> matching = this.topics.stream().filter(topic -> topic.getName().equalsIgnoreCase(name)).findFirst();
        return matching.orElse(null);
    }
}
