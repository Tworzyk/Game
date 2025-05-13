package com.chopaki.logic;

import java.swing.*;
import java.awt.*;

public class gui extends JFrame
{
    Gui()
    {
        JFrame frame = new JFrame("Password Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}