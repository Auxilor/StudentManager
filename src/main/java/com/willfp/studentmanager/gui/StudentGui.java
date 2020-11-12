package com.willfp.studentmanager.gui;

import com.willfp.studentmanager.groups.TeachingGroup;
import com.willfp.studentmanager.gui.renderers.NameableRenderer;
import com.willfp.studentmanager.gui.renderers.PerformanceRenderer;
import com.willfp.studentmanager.human.Student;
import com.willfp.studentmanager.serialisation.util.SerialisationUtils;
import com.willfp.studentmanager.work.Performance;
import com.willfp.studentmanager.work.Topic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.io.File;

public class StudentGui {
    private final JFrame frame = new JFrame("Student Manager");
    private final GridLayout mainPanelLayout = new GridLayout(3, 3, 10, 10);
    private final JPanel mainPanel = new JPanel(mainPanelLayout);

    private final DefaultListModel<Student> studentListModel = new DefaultListModel<>();
    private final JList<Student> studentList = new JList<>(studentListModel);

    private final DefaultListModel<Topic> topicListModel = new DefaultListModel<>();
    private final JList<Topic> topicList = new JList<>(topicListModel);

    private final DefaultComboBoxModel<Performance> topicPerformancesModel = new DefaultComboBoxModel<>();
    private final JComboBox<Performance> topicPerformances = new JComboBox<>(topicPerformancesModel);

    private final JButton confirmButton = new JButton();

    private final JButton loadClassButton = new JButton();
    private final JFileChooser loadClassChooser = new JFileChooser();

    private TeachingGroup group;

    public StudentGui(TeachingGroup group) {
        this.group = group;
        group.getTopics().forEach(topicListModel::addElement);

        studentList.setCellRenderer(new NameableRenderer());
        topicList.setCellRenderer(new NameableRenderer());
        topicPerformances.setRenderer(new PerformanceRenderer());

        topicPerformancesModel.addElement(Performance.GOOD);
        topicPerformancesModel.addElement(Performance.OKAY);
        topicPerformancesModel.addElement(Performance.BAD);

        confirmButton.setText("Get JSON");
        loadClassButton.setText("Load class Json");

        updateTopicList();

        topicList.setSelectedIndex(0);
        studentList.setSelectedIndex(0);

        loadClassChooser.setCurrentDirectory(new File(System.getProperty("user.home")));


        studentList.addListSelectionListener((event) -> {
            topicPerformancesModel.setSelectedItem(getSelectedStudent().getPerformance(getSelectedTopic()));
        });

        topicList.addListSelectionListener((event) -> {
            topicPerformancesModel.setSelectedItem(getSelectedStudent().getPerformance(getSelectedTopic()));
        });

        topicPerformances.addItemListener((event) -> {
            if(getSelectedStudent() == null || getSelectedTopic() == null) JOptionPane.showMessageDialog(frame, "You must select a student and a topic!");
            if(event.getStateChange() == ItemEvent.SELECTED) {
                getSelectedStudent().setPerformance(getSelectedTopic(), (Performance) event.getItem());
            }
        });

        confirmButton.addActionListener((event) -> {
            System.out.println(SerialisationUtils.serialiseGroup(group));
        });

        loadClassButton.addActionListener((event) -> {
            int result = loadClassChooser.showOpenDialog(frame);
            if(result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = loadClassChooser.getSelectedFile();
                setGroup((TeachingGroup) SerialisationUtils.deserialiseGroup(selectedFile, TeachingGroup.class));
                updateTopicList();
            }
        });

        mainPanel.add(studentList);
        mainPanel.add(topicList);
        mainPanel.add(topicPerformances);
        mainPanel.add(confirmButton);
        mainPanel.add(loadClassButton);

        frame.setSize(800, 500);
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setGroup(TeachingGroup group) {
        this.group = group;
    }

    public TeachingGroup getGroup() {
        return group;
    }

    public void addStudent(Student student) {
        this.studentListModel.addElement(student);
        if(studentList.isSelectionEmpty()) {
            studentList.setSelectedIndex(0);
        }
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public Student getSelectedStudent() {
        return studentList.getSelectedValue();
    }

    public Topic getSelectedTopic() {
        return topicList.getSelectedValue();
    }

    public void updateTopicList() {
        topicListModel.clear();
        group.getTopics().forEach(topicListModel::addElement);
    }
}