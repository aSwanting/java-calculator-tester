package org.learning.calculator;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Button extends JButton {
    String text;
    Color bg;

    public Button(String text) {
        super(text);
        this.setBorder(new CompoundBorder(
                new LineBorder(new Color(0xC0C4CC)),
                new EmptyBorder(20, 40, 20, 40)
        ));

        bg = new Color(0xFFFFFF);
        this.setBackground(bg);
        this.setFocusPainted(false);

        this.addActionListener(e -> System.out.println(text));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                bg = new Color(0xE1E1E1);
                setBackground(bg);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                bg = new Color(0xFFFFFF);
                setBackground(bg);
            }

        });
    }
}
