package org.example;

import javax.swing.*;

public class Main {
  public static Mainpart mainpart; //= new Mainpart();
  public static Login login; //= new Login();
  public static void main(String[] args) {
    Main.mainpart = new Mainpart();
    Main.login = new Login();
    Main.login.setVisible(true);
  }
}