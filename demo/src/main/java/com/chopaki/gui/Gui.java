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
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

import com.chopaki.logic.Chars;
import com.chopaki.logic.Words;
import com.chopaki.logic.load;
import com.chopaki.logic.save;



public class Gui
{
    public Gui(){
        JFrame frame = new JFrame("Password Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        
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

        gbc.gridwidth = 0;
        gbc.gridx = 0;
        gbc.gridy = 4;
        chars.add(outputChars, gbc);
        JButton saveButtonchar = new JButton("Save");
        gbc.gridwidth = 0;
        gbc.gridx = 0;
        gbc.gridy = 6;
        chars.add(saveButtonchar, gbc);
        saveButtonchar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                save.save(outputChars.getText());
            }
        });
     

        //Word Section
        JPanel words = new JPanel();
        words.setLayout(new GridBagLayout());
         GridBagConstraints gbs = new GridBagConstraints();
        gbs.fill = GridBagConstraints.HORIZONTAL;

        gbs.insets = new Insets(10,10,5,5);
        gbs.gridx = 1;
        gbs.gridy = 0;
        words.add(new JLabel("Words Password"), gbs);

        gbs.gridx = 0;
        gbs.gridy = 1;
        words.add(new JLabel("Number of Words"), gbs);

        SpinnerNumberModel charcounter = new SpinnerNumberModel(1, 1, 64, 1);
        JSpinner spinnerwords = new JSpinner(charcounter);
        gbs.gridx = 1;
        gbs.gridy = 1;
        words.add(spinnerwords, gbs);
        gbs.gridx = 0;
        gbs.gridy = 3;
        words.add(new JLabel("Random Sign"),gbs);
        gbs.gridx = 1;
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
        gbs.gridx = 2;
        gbs.gridy = 3;
        
        words.add(wordsButton,gbs);
        gbs.gridx = 0;
        gbs.gridwidth = 3;
        gbs.gridy = 5;

        words.add(outputWords,gbs);

        JButton saveButtonwords = new JButton("Save");
        gbs.gridwidth = 0;
        gbs.gridx = 0;
        gbs.gridy = 6;
        words.add(saveButtonwords, gbs);
        saveButtonwords.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                save.save(outputWords.getText());
            }
        });


        //user password section
        JPanel userpasswword = new JPanel();
        userpasswword.setLayout(new GridBagLayout());
        GridBagConstraints gbu = new GridBagConstraints();
        gbu.fill = GridBagConstraints.HORIZONTAL;
        gbu.insets = new Insets(10,10,5,5);
        gbu.gridx = 0;
        gbu.gridy = 0;
        userpasswword.add(new JLabel("User Password"), gbu);
        gbu.gridx = 2;
        gbu.gridy = 0;
        JLabel charscounter = new JLabel("Number of Characters");
        userpasswword.add(charscounter, gbu);
        gbu.gridx = 1;
        gbu.gridy = 0;
        JLabel ProvidePassword = new JLabel("Provide Password");
        userpasswword.add(ProvidePassword, gbu);
        gbu.gridx = 1;
        gbu.gridy = 1;
        JPasswordField passwordField = new JPasswordField(10);
        userpasswword.add(passwordField, gbu);
        gbu.gridx = 0;
        gbu.gridy = 1;
        JCheckBox showPassword = new JCheckBox("Show Password");
        userpasswword.add(showPassword, gbu);
        JCheckBox RandomWods = new JCheckBox("Enable Random Words");
        gbu.gridx = 0;
        gbu.gridy = 2;
        userpasswword.add(RandomWods, gbu);
        JCheckBox charsNumsUser = new JCheckBox("Enable numbers");
        JCheckBox charsSpecialUser = new JCheckBox("Enable special");
        gbu.gridx = 1;
        gbu.gridy = 2;
        userpasswword.add(charsNumsUser, gbu);
        gbu.gridx = 2;
        gbu.gridy = 2;
        userpasswword.add(charsSpecialUser, gbu);
        gbu.gridx = 2;
        gbu.gridy = 3;
        JButton userpassButton = new JButton("Submit");
        userpasswword.add(userpassButton, gbu);
        gbu.gridx = 0;
        gbu.gridwidth = 2;
        gbu.gridy = 3;
        JPasswordField outputPasswordUser = new JPasswordField();
        userpasswword.add(outputPasswordUser, gbu);
        gbu.gridx = 2;
        gbu.gridy = 1;

        SpinnerNumberModel charcounteruser = new SpinnerNumberModel(1, 1, 64, 1);
        JSpinner spinnercharsuser = new JSpinner(charcounteruser);
        userpasswword.add(spinnercharsuser, gbu);
        JButton saveButtonuser = new JButton("Save");
        gbu.gridwidth = 0;
        gbu.gridx = 0;
        gbu.gridy = 4;
        userpasswword.add(saveButtonuser, gbu);
        saveButtonuser.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String passwordu = new String(passwordField.getPassword());
                save.save(outputPasswordUser.getText());
            }
        });

        userpassButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String password = new String(passwordField.getPassword());
                Boolean chars = charsNumsUser.isSelected();
                Boolean special = charsSpecialUser.isSelected();
                Boolean random = RandomWods.isSelected();
                int howmanychars = (Integer)spinnercharsuser.getValue();
                String passwordU = Words.genCharsUser(password, chars, special, random,howmanychars);
                outputPasswordUser.setText(passwordU);
            }
        });

        showPassword.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (showPassword.isSelected())
                {
                    passwordField.setEchoChar((char) 0);
                    outputPasswordUser.setEchoChar((char) 0);
                }
                else
                {
                    passwordField.setEchoChar('*');
                    outputPasswordUser.setEchoChar('*');
                }
            }
        });
        //Load password page 

        JPanel loadpassword = new JPanel();
        loadpassword.setLayout(new GridBagLayout());
        GridBagConstraints gbl = new GridBagConstraints();
        gbl.fill = GridBagConstraints.HORIZONTAL;
        gbl.insets = new Insets(10,10,5,5);
        gbl.gridx = 0;
        gbl.gridy = 0;
        loadpassword.add(new JLabel("Load Password"), gbl);
        gbl.gridx = 1;
        gbl.gridy = 0;
        JButton loadButton = new JButton("Load");
        loadpassword.add(loadButton, gbl);
        JButton clearboard = new JButton("Clear");
        gbl.gridx = 1;
        gbl.gridy = 1;
        loadpassword.add(clearboard, gbl);
        JTextArea loadText = new JTextArea();
        gbl.gridx = 0;
        gbl.gridy = 1;
        loadText.setLineWrap(true);
        loadText.setWrapStyleWord(true);
        loadText.setEditable(false);
        loadText.setRows(10);
        loadText.setColumns(30);
        loadText.setText("Load Passwords from file");
        loadpassword.add(loadText, gbl);
        
        clearboard.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                loadText.setText("");
                load.clearlist();
            }
        });
        loadButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                load.load();
                StringBuilder sb = new StringBuilder();
                for (String password : load.getPasswords())
                {
                    sb.append(password).append("\n");
                }
                loadText.setText(sb.toString());
            }
        });


        
        tabPanel.addTab("Character Password",chars);
        tabPanel.addTab("Words Password",words);
        tabPanel.addTab("UserPawssword",userpasswword);
        tabPanel.addTab("Load Password",loadpassword);
        frame.add(tabPanel);
        frame.setVisible(true);
    }
}