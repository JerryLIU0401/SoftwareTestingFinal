package org.example;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    MainFrame mainFrame = new MainFrame();
    mainFrame.frameInit();
    mainFrame.setVisible(true);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}