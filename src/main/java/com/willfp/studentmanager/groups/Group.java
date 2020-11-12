package com.willfp.studentmanager.groups;

import com.willfp.studentmanager.human.Student;
import com.willfp.studentmanager.util.Nameable;

import java.util.ArrayList;
import java.util.List;

public abstract class Group implements Nameable {
    private final String name;
    private final List<Student> students = new ArrayList<>();

    protected Group(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public List<Student> getStudents() {
        return this.students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return getName().equals(group.getName());
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
