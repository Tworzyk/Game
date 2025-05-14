package com.chopaki.gui;


import javax.swing.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.chopaki.logic.Chars;


public class Gui
{
    public Gui(){
        JFrame frame = new JFrame("Password Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);


        JTabbedPane tabPanel = new JTabbedPane();

        // Char Section
        JPanel chars = new JPanel();
        chars.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.insets = new Insets(10,10,5,5);

        gbc.gridx = 1;
        gbc.gridy = 0;
        chars.add(new JLabel("Character Password"), gbc);

        JCheckBox charsNums = new JCheckBox("Enable numbers");
        JCheckBox charsSpecial = new JCheckBox("Enable special");
        JCheckBox charsLarge = new JCheckBox("Enable Large");
        gbc.gridx = 0;
        gbc.gridy = 1;
        chars.add(charsNums, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        chars.add(charsSpecial, gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        chars.add(charsLarge, gbc);

        SpinnerNumberModel passLength = new SpinnerNumberModel(1, 1, 64, 1);
        JSpinner spinner = new JSpinner(passLength);
        gbc.gridx = 1;
        gbc.gridy = 2;
        chars.add(spinner, gbc);
        JTextArea outputChars = new JTextArea();
        JButton charsButton = new JButton("Submit");
        gbc.gridx = 1;
        gbc.gridy = 3;
        charsButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Boolean chars = charsNums.isSelected();
                Boolean special = charsSpecial.isSelected();
                Boolean large = charsLarge.isSelected();
                int length = (Integer) spinner.getValue();
                String password = Chars.genChars(length, chars, special, large);
                outputChars.setText(password);

            }
        });
        chars.add(charsButton, gbc);



        gbc.gridx = 1;
        gbc.gridy = 4;
        chars.add(outputChars, gbc);


        //Word Section
        JPanel words = new JPanel();
        words.add(new JLabel("Words Password"));
        tabPanel.addTab("Character Password",chars);
        tabPanel.addTab("Words Password",words);
        frame.add(tabPanel);



        frame.setVisible(true);
    }
}