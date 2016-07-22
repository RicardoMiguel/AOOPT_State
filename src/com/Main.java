package com;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flying flies");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlyStates m = new FlyStates();
        frame.getContentPane().add(m);
        frame.pack();
        frame.setVisible(true);
        new Thread(m).start();
    }
}
