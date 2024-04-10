package org.learning.calculator;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CalculatorGUI extends JPanel {

    public CalculatorGUI() {

        JFrame f = new JFrame("Java Calculator");
        f.setVisible(true);

        JPanel screen = new JPanel(new GridLayout());
        screen.setBorder(new EmptyBorder(10, 10, 0, 10));
//        screen.setBorder(new LineBorder(Color.green, 3));
        f.add(screen, BorderLayout.NORTH);

        JLabel screenContents = new JLabel("0.0009798789700");
        screenContents.setBorder(new CompoundBorder(
                new LineBorder(new Color(200, 200, 200)),
                new EmptyBorder(20, 10, 20, 10)
        ));

        screenContents.setOpaque(true);
        screenContents.setBackground(Color.white);
        screenContents.setHorizontalAlignment(SwingConstants.RIGHT);
        screen.add(screenContents);

        JPanel body = new JPanel(new GridBagLayout());
        body.setBorder(new EmptyBorder(8, 8, 8, 8));
//        body.setBorder(new LineBorder(Color.red, 3));
        f.add(body, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(2, 2, 2, 2);

        ArrayList<Button> buttons = new ArrayList<>();
        String[] buttonStrings = {
                "7", "8", "9", "+", "CE",
                "4", "5", "6", "-", "C",
                "1", "2", "3", "*", "Del",
                "0", ".", "/", "="
        };
        for (int i = 0; i < buttonStrings.length; i++) {
            Button button = new Button(buttonStrings[i]);
            buttons.add(button);
            body.add(button, gbc);
//
            gbc.gridx++;
//
            if (gbc.gridx == 5) {
                gbc.gridx = 0;
                gbc.gridy++;
            }
            gbc.gridwidth = 1;

            if (i == 14) {
                gbc.gridwidth = 2;
            }

            if (i == 15) {
                gbc.gridx++;
            }
        }

        gbc.gridx = 0;
        gbc.gridy = 1;

        body.add(buttons.get(5), gbc);


//        GridBagConstraints c = new GridBagConstraints();
////        c.weightx = 1;
////        c.weighty = 1;
//        c.fill = GridBagConstraints.BOTH;
//
//
//        JPanel numpad = new JPanel(new GridLayout(3, 3));
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                String s = j + 7 - i * 3 + " ";
//                addBtns(numpad, s);
//            }
//        }
//        c.gridx = 0;
//        c.gridy = 0;
//        c.gridheight = 1;
//        body.add(numpad, c);
//
//
//        JPanel numpad2 = new JPanel(new GridLayout(4, 1));
//        String[] btnControls = {"+", "-", "x", "/"};
//        for (String btnControl : btnControls) {
//            addBtns(numpad2, btnControl);
//        }
//        c.gridx = 1;
//        c.gridy = 0;
//        c.gridheight = 2;
//        body.add(numpad2, c);
//
//
//        JPanel numpad3 = new JPanel(new GridLayout(4, 1));
//        String[] btnControls2 = {"CE", "C", "del", "="};
//        for (String btnControl : btnControls2) {
//            addBtns(numpad3, btnControl);
//        }
//        c.gridx = 2;
//        c.gridy = 0;
//        c.gridheight = 2;
//        body.add(numpad3, c);
//
//
//        JPanel numpad4 = new JPanel(new GridBagLayout());
////        numpad4.setBorder(new LineBorder(Color.green));
//        String[] btnControls3 = {"0", "."};
//        for (String btnControl : btnControls3) {
//            addBtnsExtra(numpad4, btnControl, c);
//        }
//        c.gridx = 0;
//        c.gridy = 1;
//        c.gridwidth = 1;
//        c.gridheight = 1;
//        body.add(numpad4, c);
        f.pack();
        f.setResizable(false);
//        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private static void addBtns(JPanel p, String s) {

        JButton b = new JButton(s);
        b.addActionListener(e -> System.out.println(s));
        Color btnColor = new Color(255, 255, 255);
        Color btnHoverColor = new Color(218, 226, 230);

        if (s.equals("=")) {
            btnColor = new Color(138, 163, 168);
            btnHoverColor = new Color(188, 191, 234);
        }


        b.setBackground(btnColor);

        Color finalBtnHoverColor = btnHoverColor;
        Color finalBtnColor = btnColor;

        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                b.setBackground(finalBtnHoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                b.setBackground(finalBtnColor);

            }
        });

        b.setBorder(new CompoundBorder(
                new LineBorder(new Color(200, 200, 200)),
                new EmptyBorder(20, 30, 20, 30)
        ));
//
//
//        if (s.equals("0")) {
//            b.setBorder(new CompoundBorder(
//                    new LineBorder(new Color(200, 200, 200)),
//                    new EmptyBorder(20, 60, 20, 60)
//            ));
//        }

        b.setHorizontalAlignment(SwingConstants.CENTER);
        b.setFocusPainted(false);
        p.add(b);
    }

    private static void addBtnsExtra(JPanel p, String s, GridBagConstraints c) {

        JButton b = new JButton(s);
        b.addActionListener(e -> System.out.println(s));
        Color btnColor = new Color(255, 255, 255);
        Color btnHoverColor = new Color(218, 226, 230);

        c.fill = GridBagConstraints.BOTH;

        if (s.equals("0")) {
            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 1;
            c.gridheight = 1;
            c.weightx = 0.95;
        }

        if (s.equals(".")) {
            c.gridx = 2;
            c.gridy = 0;
            c.gridwidth = 1;
            c.gridheight = 1;
            c.weightx = 0.05;
        }


        b.setBackground(btnColor);

        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                b.setBackground(btnHoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                b.setBackground(btnColor);

            }
        });

        b.setBorder(new CompoundBorder(
                new LineBorder(new Color(200, 200, 200)),
                new EmptyBorder(20, 30, 20, 30)
        ));
//
//
//        if (s.equals("0")) {
//            b.setBorder(new CompoundBorder(
//                    new LineBorder(new Color(200, 200, 200)),
//                    new EmptyBorder(20, 60, 20, 60)
//            ));
//        }

        b.setHorizontalAlignment(SwingConstants.CENTER);
        b.setFocusPainted(false);
        p.add(b, c);
    }

}

