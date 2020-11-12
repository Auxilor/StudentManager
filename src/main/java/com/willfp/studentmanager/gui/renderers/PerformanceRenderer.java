package com.willfp.studentmanager.gui.renderers;

import com.willfp.studentmanager.work.Performance;

import javax.swing.*;
import java.awt.*;

public class PerformanceRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        Performance performance = (Performance) value;
        setText(performance.name());
        return this;
    }
}
