package org.example;

import javax.swing.*;

public class Main {
  public static Mainpart mainpart;
  public static void main(String[] args) {
    Main.mainpart = new Mainpart();
    Login login = new Login();
    login.setVisible(true);
  }
}