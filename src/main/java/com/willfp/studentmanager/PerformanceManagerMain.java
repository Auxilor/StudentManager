package com.willfp.studentmanager;

import com.willfp.studentmanager.groups.TeachingGroup;
import com.willfp.studentmanager.gui.StudentGui;
import com.willfp.studentmanager.human.Student;
import com.willfp.studentmanager.serialisation.util.SerialisationUtils;
import com.willfp.studentmanager.work.Performance;
import com.willfp.studentmanager.work.Topic;

public class PerformanceManagerMain {
    public static void main(String[] args) {
        TeachingGroup group = new TeachingGroup("9X/Cs");

        Topic hex = new Topic("hex");
        hex.addPerformanceDescription(Performance.GOOD, "Good work!");
        hex.addPerformanceDescription(Performance.GOOD, "Nice Job!");
        hex.addPerformanceDescription(Performance.OKAY, "Getting there.");
        hex.addPerformanceDescription(Performance.BAD, "Not great.");
        group.addTopic(hex);

        Topic binary = new Topic("binary");
        binary.addPerformanceDescription(Performance.GOOD, "Good work!");
        binary.addPerformanceDescription(Performance.GOOD, "Nice Job!");
        binary.addPerformanceDescription(Performance.OKAY, "Getting there.");
        binary.addPerformanceDescription(Performance.BAD, "Not great.");
        group.addTopic(binary);

        Student james = new Student("james");
        james.setCurrentGrade(7);
        james.setTargetGrade(8);
        james.setPerformance(hex, Performance.GOOD);
        james.setPerformance(binary, Performance.OKAY);
        group.addStudent(james);

        Student tom = new Student("tom");
        tom.setCurrentGrade(5);
        tom.setTargetGrade(6);
        tom.setPerformance(hex, Performance.OKAY);
        tom.setPerformance(binary, Performance.BAD);
        group.addStudent(tom);

        String serialised = SerialisationUtils.serialiseGroup(group);

        StudentGui gui = new StudentGui(group);
        group.getStudents().forEach(gui::addStudent);
        gui.setVisible(true);
    }
}
