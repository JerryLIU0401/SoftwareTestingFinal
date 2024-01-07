package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
  private Container cp;

  String[] op = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
          "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
          "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60",
          "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80",
          "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99"};
  private JPanel jpnAll = new JPanel(new GridLayout(1, 2, 1, 1));

  private JPanel jpnW = new JPanel(new GridLayout(5, 2, 1, 1));
  private Label name = new Label("Name : ");
  private TextField nameinput = new TextField();
  private Label date = new Label("Date : ");
  private TextField dateinput = new TextField();
  private Label place = new Label("Place : ");
  private TextField placeinput = new TextField();
  private Label referce = new Label("Referce : ");
  private TextField referceinput = new TextField();
  private Label umpire = new Label("Umpire : ");
  private Label playerListA = new Label("TeamA : ");
  private Label playerListB = new Label("TeamB : ");
  private JPanel jpnS = new JPanel(new GridLayout(1, 2, 1, 1));
  private TextField umpireinput = new TextField();

  private JPanel jpnE = new JPanel(new GridLayout(5, 1, 1, 1));
  private JComboBox<String> jcbA = new JComboBox<>(op);
  private JButton jbnJoinA = new JButton("Join");
  private JComboBox<String> jcbB = new JComboBox<>(op);
  private JButton jbnJoinB = new JButton("Join");

  private JButton jbnStart = new JButton("Start");

  public Login() {
    init();
  }

  private void init() {
    cp = this.getContentPane();
    cp.setLayout(new BorderLayout(3, 3));
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setBounds(400, 50, 800, 400);

    jpnW.add(name);
    jpnW.add(nameinput);
    jpnW.add(date);
    jpnW.add(dateinput);
    jpnW.add(place);
    jpnW.add(placeinput);
    jpnW.add(referce);
    jpnW.add(referceinput);
    jpnW.add(umpire);
    jpnW.add(umpireinput);

    jpnE.add(jcbA);
    jpnE.add(jbnJoinA);
    jpnE.add(jcbB);
    jpnE.add(jbnJoinB);
    jpnE.add(jbnStart);

    jpnAll.add(jpnW);
    jpnAll.add(jpnE);

    jpnS.add(playerListA);
    jpnS.add(playerListB);

    cp.add(jpnAll, BorderLayout.CENTER);
    cp.add(jpnS, BorderLayout.SOUTH);

    //頁面跳轉至主畫面
    jbnStart.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (Mainpart.playerDataA.size() < 5 || Mainpart.playerDataB.size() < 5) {
          JOptionPane.showMessageDialog(new JFrame(), "兩邊相加人數必須大於10人", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
          Main.mainpart.setVisible(true);
          Main.mainpart.setPlayer();
          Main.login.setVisible(false);
        }
      }
    });

    jbnJoinA.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String s = op[jcbA.getSelectedIndex()];
        PlayerData p = new PlayerData(Integer.parseInt(s));
        if (Save.searchTeamAData(p)) {
          JOptionPane.showMessageDialog(new JFrame(), "已經有這位球員了!!", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
          if (Mainpart.playerDataA.size() == 12) {
            JOptionPane.showMessageDialog(new JFrame(), "已經滿員了!!", "Error", JOptionPane.INFORMATION_MESSAGE);
          } else {
            Mainpart.playerDataA.add(p);
            playerListA.setText(playerListA.getText() + " " + p.getId());
          }
        }
      }
    });

    jbnJoinB.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String s = op[jcbB.getSelectedIndex()];
        PlayerData p = new PlayerData(Integer.parseInt(s));
        if (Save.searchTeamBData(p)) {
          JOptionPane.showMessageDialog(new JFrame(), "已經有這位球員了!!", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
          if (Mainpart.playerDataB.size() == 12) {
            JOptionPane.showMessageDialog(new JFrame(), "已經滿員了!!", "Error", JOptionPane.INFORMATION_MESSAGE);
          } else {
            Mainpart.playerDataB.add(p);
            playerListB.setText(playerListB.getText() + " " + p.getId());
          }
        }
      }
    });
  }

}
