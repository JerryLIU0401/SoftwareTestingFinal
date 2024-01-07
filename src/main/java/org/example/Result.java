package org.example;

import org.example.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Result extends JFrame {
  private Container cp;
  String team = "";
  Object[][] data = new Object[12][15];
  String[] columns = {"Player", "PTS", "AST", "ORB", "DRB", "BLK", "ST", "TO", "PF", "TS", "FT", "FG", "TFG", "EFF", "+/-"};
  private JPanel jpnN = new JPanel(new GridLayout(1, 3, 1, 1));
  private Label Lteam = new Label();
  private Label title = new Label("Result");
  private Label blank = new Label();
  private PlayerData[] playerData;

  JTable jt = new JTable(data, columns);

  private JPanel jpnS = new JPanel(new GridLayout(1, 3, 1, 1));
  private Label blank1 = new Label();
  private Label blank2 = new Label();
  private JButton jbnBack = new JButton("Back");

  public Result(String t) {
    team = t;
    init();
  }

  public void setData() {
    if (team.equals("A")){
      playerData = new PlayerData[Mainpart.playerDataA.size()];
      Mainpart.playerDataA.toArray(playerData);
    }else{
      playerData = new PlayerData[Mainpart.playerDataB.size()];
      Mainpart.playerDataB.toArray(playerData);
    }

    for (int i = 0; i < playerData.length; i++) {
      PlayerData p = playerData[i];
      data[i][0] = p.getId();
      data[i][1] = p.getPoints();
      data[i][2] = p.getAssists();
      data[i][3] = p.getOrb();
      data[i][4] = p.getDrb();
      data[i][5] = p.getBlocks();
      data[i][6] = p.getSteals();
      data[i][7] = p.getTurnovers();
      data[i][8] = p.getPf();
      data[i][9] = p.ts();
      data[i][10] = p.ft();
      data[i][11] = p.fg();
      data[i][12] = p.tfg();
      data[i][13] = p.eff();
//                p.setPlusminus(p.getPoints());
      data[i][14] = 0;

    }
  }

  private void init() {
    setData();
    cp = this.getContentPane();
    cp.setLayout(new BorderLayout(3, 3));
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setBounds(400, 50, 800, 400);

    Lteam.setText("Team : " + team);
    jpnN.add(Lteam);
    jpnN.add(title);
    jpnN.add(blank);

    cp.add(jpnN, BorderLayout.NORTH);

    cp.add(new JScrollPane(jt), BorderLayout.CENTER);

    jpnS.add(blank1);
    jpnS.add(blank2);
    jpnS.add(jbnBack);

    cp.add(jpnS, BorderLayout.SOUTH);

    //頁面跳轉至主畫面

    //頁面跳轉至主畫面
    jbnBack.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Main.mainpart.setVisible(true);
        Result.this.dispose();
      }
    });
  }

}
