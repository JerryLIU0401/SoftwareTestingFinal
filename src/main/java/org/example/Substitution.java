package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Substitution extends JFrame {
  private Container cp;
  String[] op;
  int playernumber = 0;
  String playerteam = "";
  int[] playerlist;
  PlayerData playerData;
  private JPanel jpnN = new JPanel(new GridLayout(1, 3, 1, 1));
  private Label teamAndPlayer = new Label();
  private Label title = new Label("Substitution");
  private Label blank = new Label();

  private JPanel jpnC = new JPanel(new GridLayout(1, 2, 1, 1));
  private Label substitution = new Label("Player : ");
  private JComboBox<String> jcbsubstitution;

  private JPanel jpnS = new JPanel(new GridLayout(1, 4, 1, 1));
  private Label blank1 = new Label();
  private Label blank2 = new Label();
  private JButton jbnCancel = new JButton("Cancel");
  private JButton jbnSubmit = new JButton("Submit");

  public void getInGamePlayer() {
    boolean inGame = false;
//    for (PlayerData p : Mainpart.playerDataA) {
//      if (p.getId() == playernumber) {
//        playerData = p;
//      }
//    }
    if (playerteam.equals("A")) {
      String[] str = new String[Mainpart.playerDataA.size()];
      int i = 0;
      for (PlayerData p : Mainpart.playerDataA) {
        inGame = false;
        for (int n : playerlist) {
          if (p.getId() == n) {
            inGame = true;
            break;
          }
        }
        if (playernumber == p.getId()) {
          inGame = true;
        }
        if (!inGame) {
          str[i] = Integer.toString(p.getId());
//          System.out.println(str[i]);
          i++;
        }
      }
      op = str;
    } else {
      String[] str = new String[Mainpart.playerDataB.size()];
      int i = 0;
      for (PlayerData p : Mainpart.playerDataB) {
        inGame = false;
        for (int n : playerlist) {
          if (p.getId() == n) {
            inGame = true;
            break;
          }
        }
        if (playernumber == p.getId()) {
          inGame = true;
        }
        if (!inGame) {
          str[i] = Integer.toString(p.getId());
          i++;
        }
      }
      op = str;
    }
//    System.out.println(Arrays.toString(op));
  }

  public Substitution(String team, int num, int[] list) {
    playernumber = num;
    playerteam = team;
    playerlist = list;
    init();
  }

  private void init() {
    getInGamePlayer();
    jcbsubstitution = new JComboBox<>(op);
    cp = this.getContentPane();
    cp.setLayout(new BorderLayout(3, 3));
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setBounds(400, 50, 800, 400);

    teamAndPlayer.setText("Team : " + playerteam + " Player : " + playernumber);
    jpnN.add(teamAndPlayer);
    jpnN.add(title);
    jpnN.add(blank);

    cp.add(jpnN, BorderLayout.NORTH);

    jpnC.add(substitution);
    jpnC.add(jcbsubstitution);

    cp.add(jpnC, BorderLayout.CENTER);

    jpnS.add(blank1);
    jpnS.add(blank2);
    jpnS.add(jbnCancel);
    jpnS.add(jbnSubmit);

    cp.add(jpnS, BorderLayout.SOUTH);

    //頁面跳轉至主畫面
    jbnCancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Main.mainpart.setVisible(true);
        Substitution.this.dispose();
      }
    });

    //頁面跳轉至主畫面
    jbnSubmit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (jcbsubstitution.getSelectedItem() == null) {
          JOptionPane.showMessageDialog(new JFrame(), "選擇不得為空", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
          String s = jcbsubstitution.getSelectedItem().toString();
          Main.mainpart.change(playernumber, Integer.parseInt(s), playerteam);
          Main.mainpart.setVisible(true);
          Substitution.this.dispose();
        }
      }
    });
  }

}
