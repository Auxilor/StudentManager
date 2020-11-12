package com.willfp.studentmanager.gui.renderers;

import com.willfp.studentmanager.util.Nameable;

import javax.swing.*;
import java.awt.*;

public class NameableRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        Nameable nameable = (Nameable) value;
        setText(nameable.getName());
        return this;
    }
}
