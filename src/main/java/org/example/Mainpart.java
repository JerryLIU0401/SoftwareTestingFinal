package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Mainpart extends JFrame {
  int AP1 = 1;
  int AP2 = 2;
  int AP3 = 3;
  int AP4 = 4;
  int AP5 = 5;

  int BP1 = 1;
  int BP2 = 2;
  int BP3 = 3;
  int BP4 = 4;
  int BP5 = 5;

  String teamA = "A";
  String teamB = "B";

  private Container cp;
  private JPanel jpnAll = new JPanel(new GridLayout(1, 2, 1, 1));
  private JPanel jpnA = new JPanel(new GridLayout(2, 3, 1, 1));
  private JPanel jpnB = new JPanel(new GridLayout(2, 3, 1, 1));
  private JPanel jpnS = new JPanel(new GridLayout(1, 5, 1, 1));
  private Label time = new Label("Time : ");
  private Label pauseA = new Label("Pause A : ");
  private Label pauseB = new Label("Pause B : ");
  private Label scoreA = new Label("Score A : ");
  private Label scoreB = new Label("Score B : ");


  private JButton jbtnA1 = new JButton("1");
  private JButton jbtnA2 = new JButton("2");
  private JButton jbtnA3 = new JButton("3");
  private JButton jbtnA4 = new JButton("4");
  private JButton jbtnA5 = new JButton("5");
  private JButton jbtnATeam = new JButton("Team A Record");
  private JButton jbtnB1 = new JButton("1");
  private JButton jbtnB2 = new JButton("2");
  private JButton jbtnB3 = new JButton("3");
  private JButton jbtnB4 = new JButton("4");
  private JButton jbtnB5 = new JButton("5");
  private JButton jbtnBTeam = new JButton("Team B Record");
  private JMenuBar jmb = new JMenuBar();

  private JMenu jmStart = new JMenu("Start");
  private JMenuItem jmiStart = new JMenuItem("Start");

  private JMenu jmResult = new JMenu("Result");
  private JMenuItem jmiResult = new JMenuItem("Result");

  public PlayerData player;
  public static ArrayList<PlayerData> playerDataA = new ArrayList<>();
  public static ArrayList<PlayerData> playerDataB = new ArrayList<>();

  public int getAP1() {
    return AP1;
  }

  public void setAP1(int AP1) {
    this.AP1 = AP1;
  }

  public int getAP2() {
    return AP2;
  }

  public void setAP2(int AP2) {
    this.AP2 = AP2;
  }

  public int getAP3() {
    return AP3;
  }

  public void setAP3(int AP3) {
    this.AP3 = AP3;
  }

  public int getAP4() {
    return AP4;
  }

  public void setAP4(int AP4) {
    this.AP4 = AP4;
  }

  public int getAP5() {
    return AP5;
  }

  public void setAP5(int AP5) {
    this.AP5 = AP5;
  }

  public int getBP1() {
    return BP1;
  }

  public void setBP1(int BP1) {
    this.BP1 = BP1;
  }

  public int getBP2() {
    return BP2;
  }

  public void setBP2(int BP2) {
    this.BP2 = BP2;
  }

  public int getBP3() {
    return BP3;
  }

  public void setBP3(int BP3) {
    this.BP3 = BP3;
  }

  public int getBP4() {
    return BP4;
  }

  public void setBP4(int BP4) {
    this.BP4 = BP4;
  }

  public int getBP5() {
    return BP5;
  }

  public void setBP5(int BP5) {
    this.BP5 = BP5;
  }

  public static PlayerData getPlayer(String team, int playernumber) {
    if (team.equals("A")) {
      for (PlayerData p : playerDataA) {
        if (p.getId() == playernumber) {
          return p;
        }
      }
    } else {
      for (PlayerData p : playerDataB) {
        if (p.getId() == playernumber) {
          return p;
        }
      }
    }
    return null;
  }

  public void setPlayer() {
    AP1 = playerDataA.get(0).getId();
    AP2 = playerDataA.get(1).getId();
    AP3 = playerDataA.get(2).getId();
    AP4 = playerDataA.get(3).getId();
    AP5 = playerDataA.get(4).getId();

    BP1 = playerDataB.get(0).getId();
    BP2 = playerDataB.get(1).getId();
    BP3 = playerDataB.get(2).getId();
    BP4 = playerDataB.get(3).getId();
    BP5 = playerDataB.get(4).getId();

    jbtnA1.setText(Integer.toString(AP1));
    jbtnA2.setText(Integer.toString(AP2));
    jbtnA3.setText(Integer.toString(AP3));
    jbtnA4.setText(Integer.toString(AP4));
    jbtnA5.setText(Integer.toString(AP5));

    jbtnB1.setText(Integer.toString(BP1));
    jbtnB2.setText(Integer.toString(BP2));
    jbtnB3.setText(Integer.toString(BP3));
    jbtnB4.setText(Integer.toString(BP4));
    jbtnB5.setText(Integer.toString(BP5));

  }

  public void change(int n, int change, String t) {
    if (t.equals("A")) {
      if (n == AP1) {
        AP1 = change;
        jbtnA1.setText(Integer.toString(AP1));
      } else if (n == AP2) {
        AP2 = change;
        jbtnA2.setText(Integer.toString(AP2));
      } else if (n == AP3) {
        AP3 = change;
        jbtnA3.setText(Integer.toString(AP3));
      } else if (n == AP4) {
        AP4 = change;
        jbtnA4.setText(Integer.toString(AP4));
      } else if (n == AP5) {
        AP5 = change;
        jbtnA5.setText(Integer.toString(AP5));
      }
    } else {
      if (n == BP1) {
        BP1 = change;
        jbtnB1.setText(Integer.toString(BP1));
      } else if (n == BP2) {
        BP2 = change;
        jbtnB2.setText(Integer.toString(BP2));
      } else if (n == BP3) {
        BP3 = change;
        jbtnB3.setText(Integer.toString(BP3));
      } else if (n == BP4) {
        BP4 = change;
        jbtnB4.setText(Integer.toString(BP4));
      } else if (n == BP5) {
        BP5 = change;
        jbtnB5.setText(Integer.toString(BP5));
      }
    }
  }

  public Mainpart() {
    init();
  }

  private void init() {
    cp = this.getContentPane();
    cp.setLayout(new BorderLayout(3, 3));
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setBounds(400, 50, 800, 400);
    this.setJMenuBar(jmb);
//        this.setPlayer();
    jpnA.setBackground(new Color(208, 68, 81));
    jpnB.setBackground(new Color(0, 83, 210));
    jmb.add(jmStart);
//    jmb.add(jmResult);

    jmStart.add(jmiStart);

    jmResult.add(jmiResult);

    jpnA.add(jbtnA1);
    jpnA.add(jbtnA2);
    jpnA.add(jbtnA3);
    jpnA.add(jbtnA4);
    jpnA.add(jbtnA5);
    jpnA.add(jbtnATeam);

    jpnB.add(jbtnB1);
    jpnB.add(jbtnB2);
    jpnB.add(jbtnB3);
    jpnB.add(jbtnB4);
    jpnB.add(jbtnB5);
    jpnB.add(jbtnBTeam);

    jpnAll.add(jpnA);
    jpnAll.add(jpnB);

    jpnS.add(pauseA);
    jpnS.add(scoreA);
    jpnS.add(time);
    jpnS.add(scoreB);
    jpnS.add(pauseB);

    cp.add(jpnS, BorderLayout.SOUTH);
    cp.add(jpnAll, BorderLayout.CENTER);

    //頁面跳轉至設定畫面
    jmiStart.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Login login = new Login();
        login.setVisible(true);
        Mainpart.this.setVisible(false);
      }
    });

//    jmiResult.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        Result result = new Result();
//        result.setVisible(true);
//        Mainpart.this.setVisible(false);
//      }
//    });

    jbtnA1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Player player = new Player(teamA, new int[]{AP2, AP3, AP4, AP5}, AP1);
        player.setVisible(true);
        Mainpart.this.setVisible(false);
      }
    });

    jbtnA2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Player player = new Player(teamA, new int[]{AP1, AP3, AP4, AP5}, AP2);
        player.setVisible(true);
        Mainpart.this.setVisible(false);
      }
    });

    jbtnA3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Player player = new Player(teamA, new int[]{AP1, AP2, AP4, AP5}, AP3);
        player.setVisible(true);
        Mainpart.this.setVisible(false);
      }
    });

    jbtnA4.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Player player = new Player(teamA, new int[]{AP1, AP2, AP3, AP5}, AP4);
        player.setVisible(true);
        Mainpart.this.setVisible(false);
      }
    });

    jbtnA5.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Player player = new Player(teamA, new int[]{AP1, AP2, AP3, AP4}, AP5);
        player.setVisible(true);
        Mainpart.this.setVisible(false);
      }
    });

    jbtnB1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Player player = new Player(teamB, new int[]{BP2, BP3, BP4, BP5}, BP1);
        player.setVisible(true);
        Mainpart.this.setVisible(false);
      }
    });

    jbtnB2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Player player = new Player(teamB, new int[]{BP1, BP3, BP4, BP5}, BP2);
        player.setVisible(true);
        Mainpart.this.setVisible(false);
      }
    });

    jbtnB3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Player player = new Player(teamB, new int[]{BP1, BP2, BP4, BP5}, BP3);
        player.setVisible(true);
        Mainpart.this.setVisible(false);
      }
    });

    jbtnB4.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Player player = new Player(teamB, new int[]{BP1, BP2, BP3, BP5}, BP4);
        player.setVisible(true);
        Mainpart.this.setVisible(false);
      }
    });

    jbtnB5.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Player player = new Player(teamB, new int[]{BP1, BP2, BP3, BP4}, BP5);
        player.setVisible(true);
        Mainpart.this.setVisible(false);
      }
    });

    jbtnATeam.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
//        String s = playerDataA.toString();
//        System.out.println(s);
        Result result = new Result(teamA);
        result.setVisible(true);
        Mainpart.this.setVisible(false);
      }
    });

    jbtnBTeam.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Result result = new Result(teamB);
        result.setVisible(true);
        Mainpart.this.setVisible(false);
      }
    });

  }

};