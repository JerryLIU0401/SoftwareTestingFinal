package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Point extends JFrame {
  private Container cp;

  int playernumber = 0;
  int[] playerlist;
  String playerteam = "";
  private PlayerData playerData;

  private JPanel jpnN = new JPanel(new GridLayout(1, 3, 1, 1));
  private Label teamAndPlayer = new Label();
  private Label title = new Label("Point");
  private Label blank = new Label();

  private JPanel jpnC = new JPanel(new GridLayout(3, 2, 1, 1));
  private Label point = new Label("Point : ");
  private JComboBox<String> jcbpoint = new JComboBox<>(new String[]{"1", "2", "3"});
  private Label AST = new Label("AST : ");
  private JComboBox<String> jcbAST = new JComboBox<>();
  private Label State = new Label("State : ");
  private JComboBox<String> jcbState = new JComboBox<>(new String[]{"Get", "Fail"});

  private JPanel jpnS = new JPanel(new GridLayout(1, 4, 1, 1));
  private Label blank1 = new Label();
  private Label blank2 = new Label();
  private JButton jbnCancel = new JButton("Cancel");
  private JButton jbnSubmit = new JButton("Submit");

  public Point(String team, int[] list, int p) {
    playerteam = team;
    playerlist = list;
    playernumber = p;
    playerData = Mainpart.getPlayer(team, p);
    init();
  }

  private void init() {
    cp = this.getContentPane();
    cp.setLayout(new BorderLayout(3, 3));
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setBounds(400, 50, 800, 400);

    jcbAST.addItem("X");
    for (int i = 0; i < playerlist.length; i++) {
      jcbAST.addItem(Integer.toString(playerlist[i]));
    }

    teamAndPlayer.setText("Team : " + playerteam + " Player : " + playernumber);
    point.setText("Point : " + playerData.getPoints());
    jpnN.add(teamAndPlayer);
    jpnN.add(title);
    jpnN.add(blank);

    cp.add(jpnN, BorderLayout.NORTH);

    jpnC.add(point);
    jpnC.add(jcbpoint);
    jpnC.add(AST);
    jpnC.add(jcbAST);
    jpnC.add(State);
    jpnC.add(jcbState);

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
        Point.this.dispose();
      }
    });

    //頁面跳轉至主畫面
    jbnSubmit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        double score = Double.parseDouble(jcbpoint.getSelectedItem().toString());
        if (score == 3) {
          playerData.addTpm();
        } else if (score == 2) {
          playerData.addFgm();
        } else {
          playerData.addFtm();
        }
        if (jcbState.getSelectedItem().toString().equals("Get")) {
          playerData.setPoints(playerData.getPoints() + score);
          if (score == 3) {
            playerData.addTpa();
          } else if (score == 2) {
            playerData.addFga();
          } else {
            playerData.addFta();
          }
//          if (!jcbAST.getSelectedItem().toString().equals("X")) {
//            Save.setData(playerteam, playernumber, playerData);
//          }
          Save.setData(playerteam, playernumber, playerData);
        }
        Main.mainpart.setVisible(true);
        Point.this.dispose();
      }
    });
  }

}
