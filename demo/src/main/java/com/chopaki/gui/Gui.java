package com.chopaki.gui;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

import com.chopaki.logic.Chars;
import com.chopaki.logic.Words;



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
        words.setLayout(new GridBagLayout());
         GridBagConstraints gbs = new GridBagConstraints();
        gbs.fill = GridBagConstraints.HORIZONTAL;

        gbs.insets = new Insets(10,10,5,5);
        gbs.gridx = 1;
        gbs.gridy = 0;
        words.add(new JLabel("Words Password"), gbs);

        gbs.gridx = 1;
        gbs.gridy = 1;
        words.add(new JLabel("Number of Words"), gbs);

        SpinnerNumberModel charcounter = new SpinnerNumberModel(1, 1, 64, 1);
        JSpinner spinnerwords = new JSpinner(charcounter);
        gbs.gridx = 2;
        gbs.gridy = 1;
        words.add(spinnerwords, gbs);
        gbs.gridx = 1;
        gbs.gridy = 3;
        words.add(new JLabel("Random Sign"),gbs);
        gbs.gridx = 2;
        gbs.gridy = 3;
        JCheckBox randomSign = new JCheckBox("Enable");
        words.add(randomSign,gbs);
        JTextArea outputWords= new JTextArea();
        JButton wordsButton = new JButton("Submit");

        wordsButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int lengthwords = (Integer) spinnerwords.getValue();
                Boolean random = randomSign.isSelected();
                String passwordW = Words.addWords(random, lengthwords);
                outputWords.setLineWrap(true);
                outputWords.setText(passwordW);
            }
        });
        gbs.gridx = 1;
        gbs.gridy = 4;
        words.add(wordsButton,gbs);
        gbs.gridx = 1;
        gbs.gridy = 5;
        gbs.gridwidth = 3;
        words.add(outputWords,gbs);
        tabPanel.addTab("Character Password",chars);
        tabPanel.addTab("Words Password",words);
        frame.add(tabPanel);
        frame.setVisible(true);
    }
}