package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rebound extends JFrame {
  private Container cp;

  int playernumber = 0;
  String playerteam = "";
  PlayerData playerData;

  private JPanel jpnN = new JPanel(new GridLayout(1, 3, 1, 1));
  private Label teamAndPlayer = new Label();
  private Label title = new Label("Rebound");
  private Label blank = new Label();

  private JPanel jpnC = new JPanel(new GridLayout(1, 2, 1, 1));
  private Label point = new Label("Offense/Defense : ");
  private JComboBox<String> jcbpoint = new JComboBox<>(new String[]{"Offense", "Defense"});

  private JPanel jpnS = new JPanel(new GridLayout(1, 4, 1, 1));
  private Label blank1 = new Label();
  private Label blank2 = new Label();
  private JButton jbnCancel = new JButton("Cancel");
  private JButton jbnSubmit = new JButton("Submit");

  public Rebound(String team, int num) {
    playernumber = num;
    playerteam = team;
    playerData = Mainpart.getPlayer(team, num);
    init();
  }

  private void init() {
    cp = this.getContentPane();
    cp.setLayout(new BorderLayout(3, 3));
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setBounds(400, 50, 800, 400);

    teamAndPlayer.setText("Team : " + playerteam + " Player : " + playernumber);
    title.setText("Rebound : " + playerData.totalRb());
    jpnN.add(teamAndPlayer);
    jpnN.add(title);
    jpnN.add(blank);

    cp.add(jpnN, BorderLayout.NORTH);

    jpnC.add(point);
    jpnC.add(jcbpoint);

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
        Rebound.this.dispose();
      }
    });

    //頁面跳轉至主畫面
    jbnSubmit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (jcbpoint.getSelectedItem().toString().equals("Offense")) {
          playerData.addOrb();
        } else {
          playerData.addDrb();
        }
        Main.mainpart.setVisible(true);
        Rebound.this.dispose();
      }
    });
  }
}

