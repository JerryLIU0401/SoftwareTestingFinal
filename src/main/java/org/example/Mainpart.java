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
    private JPanel jpnAll = new JPanel(new GridLayout(1,2,1,1));
    private JPanel jpnA = new JPanel(new GridLayout(2,3,1,1));
    private JPanel jpnB = new JPanel(new GridLayout(2,3,1,1));
    private JPanel jpnS = new JPanel(new GridLayout(1,5,1,1));
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

    private void searchPlayer(ArrayList<PlayerData> playerData){

    }
    public Mainpart(){
        init();
    }

    private void init() {
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(400,50,800,400);
        this.setJMenuBar(jmb);
        jpnA.setBackground(new Color(208, 68, 81));
        jpnB.setBackground(new Color(0, 83, 210));
        jmb.add(jmStart);
        jmb.add(jmResult);

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

        cp.add(jpnS,BorderLayout.SOUTH);
        cp.add(jpnAll,BorderLayout.CENTER);

        //頁面跳轉至設定畫面
        jmiStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                login.setVisible(true);
                Mainpart.this.setVisible(false);
            }
        });

        jbtnA1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player player = new Player(teamA, new int[]{AP2, AP3, AP4, AP5}, playerDataA[AP1]);
                player.setVisible(true);
                Mainpart.this.setVisible(false);
            }
        });

        jbtnA2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player player = new Player(teamA, new int[]{AP1, AP3, AP4, AP5}, playerDataA[AP2]);
                player.setVisible(true);
                Mainpart.this.setVisible(false);
            }
        });

        jbtnA3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player player = new Player(teamA, new int[]{AP1, AP2, AP4, AP5}, playerDataA[AP3]);
                player.setVisible(true);
                Mainpart.this.setVisible(false);
            }
        });

        jbtnA4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player player = new Player(teamA, new int[]{AP1, AP2, AP3, AP5}, playerDataA[AP4]);
                player.setVisible(true);
                Mainpart.this.setVisible(false);
            }
        });

        jbtnA5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player player = new Player(teamA, new int[]{AP1, AP2, AP3, AP4}, playerDataA[AP5]);
                player.setVisible(true);
                Mainpart.this.setVisible(false);
            }
        });

        jbtnB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player player = new Player(teamB, new int[]{BP2, BP3, BP4, BP5}, playerDataB[BP1]);
                player.setVisible(true);
                Mainpart.this.setVisible(false);
            }
        });

        jbtnB2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player player = new Player(teamB, new int[]{BP1, BP3, BP4, BP5}, playerDataB[BP2]);
                player.setVisible(true);
                Mainpart.this.setVisible(false);
            }
        });

        jbtnB3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player player = new Player(teamB, new int[]{BP1, BP2, BP4, BP5}, playerDataB[BP3]);
                player.setVisible(true);
                Mainpart.this.setVisible(false);
            }
        });

        jbtnB4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player player = new Player(teamB, new int[]{BP1, BP2, BP3, BP5}, playerDataB[BP4]);
                player.setVisible(true);
                Mainpart.this.setVisible(false);
            }
        });

        jbtnB5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player player = new Player(teamB, new int[]{BP1, BP2, BP3, BP4}, playerDataB[BP5]);
                player.setVisible(true);
                Mainpart.this.setVisible(false);
            }
        });

        jbtnATeam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Record record = new Record(teamA);
                record.setVisible(true);
                Mainpart.this.setVisible(false);
            }
        });

        jbtnBTeam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Record record = new Record(teamB);
                record.setVisible(true);
                Mainpart.this.setVisible(false);
            }
        });

    }

};