package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Traveling extends JFrame {
  private Container cp;

  int playernumber = 0;
  int[] playerlist;
  String playerteam = "";

  private JPanel jpnN = new JPanel(new GridLayout(1, 3, 1, 1));
  private Label teamAndPlayer = new Label();
  private Label title = new Label("Traveling");
  private Label blank = new Label();

  private JPanel jpnS = new JPanel(new GridLayout(1, 4, 1, 1));
  private Label blank1 = new Label();
  private Label blank2 = new Label();
  private JButton jbnCancel = new JButton("Cancel");
  private JButton jbnSubmit = new JButton("Submit");

  public Traveling(String team, int num) {
    playernumber = num;
    playerteam = team;
    init();
  }

  private void init() {
    cp = this.getContentPane();
    cp.setLayout(new BorderLayout(3, 3));
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setBounds(400, 50, 800, 400);

    teamAndPlayer.setText("Team : " + playerteam + " Player : " + playernumber);
    jpnN.add(teamAndPlayer);
    jpnN.add(title);
    jpnN.add(blank);

    cp.add(jpnN, BorderLayout.NORTH);

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
        Traveling.this.dispose();
      }
    });

    //頁面跳轉至主畫面
    jbnSubmit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (playerteam.equals("A")) {
          Mainpart.playerDataA[playernumber].addTurnovers();
        } else {
          Mainpart.playerDataB[playernumber].addTurnovers();
        }
        Main.mainpart.setVisible(true);
        Traveling.this.dispose();
      }
    });
  }

}
