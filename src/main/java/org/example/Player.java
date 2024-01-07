package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player extends Mainpart {
    int playernumber = 0;
    int[] playerlist;
    String playerteam = "";
    private PlayerData playerData;
    private Container cp;
    private JPanel jpnN = new JPanel(new GridLayout(1,3,1,1));
    private Label team = new Label("A");
    private Label player = new Label("1");
    private Label blank = new Label();

    private JPanel jpnC = new JPanel(new GridLayout(2,3,1,1));
    private JButton jbtnPoint = new JButton("得分 Point");
    private JButton jbtnTraveling = new JButton("失誤 Traveling");
    private JButton jbtnFoul = new JButton("犯規 Foul");
    private JButton jbtnSteel = new JButton("抄截 Steel");
    private JButton jbtnRebound = new JButton("籃板 Rebound");
    private JButton jbtnSubstitution = new JButton("換人 Substitution");

    private JPanel jpnS = new JPanel(new GridLayout(1,3,1,1));
    private Label blank1 = new Label();
    private Label blank2 = new Label();
    private JButton jbtnCancel = new JButton("Cancel");

    public Player(String team, int[] list, PlayerData p){
//        playernumber = num;
        playerteam = team;
        playerlist = list;
        playerData = p;
        init();
    }

    private void init() {
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(400,50,800,400);

        team.setText("Team : " + playerteam);
        player.setText("Player : " + playernumber);

        jpnN.add(team);
        jpnN.add(player);
        jpnN.add(blank);

        cp.add(jpnN,BorderLayout.NORTH);

        jpnC.add(jbtnPoint);
        jpnC.add(jbtnTraveling);
        jpnC.add(jbtnFoul);
        jpnC.add(jbtnSteel);
        jpnC.add(jbtnRebound);
        jpnC.add(jbtnSubstitution);

        cp.add(jpnC,BorderLayout.CENTER);

        jpnS.add(blank1);
        jpnS.add(blank2);
        jpnS.add(jbtnCancel);

        cp.add(jpnS,BorderLayout.SOUTH);

        //頁面跳轉至主畫面
        jbtnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mainpart.setVisible(true);
                Player.this.dispose();
            }
        });

        //得分
        jbtnPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point point = new Point(playerteam, playerlist, playernumber);
                point.setVisible(true);
                Player.this.dispose();
            }
        });

        //失誤
        jbtnTraveling.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Traveling traveling = new Traveling(playerteam, playernumber);
                traveling.setVisible(true);
                Player.this.dispose();
            }
        });

        //犯規
        jbtnFoul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Foul foul = new Foul(playerteam, playernumber);
                foul.setVisible(true);
                Player.this.dispose();
            }
        });

        //抄截
        jbtnSteel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Steel steel = new Steel(playerteam, playernumber);
                steel.setVisible(true);
                Player.this.dispose();
            }
        });

        //籃板
        jbtnRebound.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rebound rebound = new Rebound(playerteam, playernumber);
                rebound.setVisible(true);
                Player.this.dispose();
            }
        });

        //換人
        jbtnSubstitution.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Substitution substitution = new Substitution(playerteam, playernumber);
                substitution.setVisible(true);
                Player.this.dispose();
            }
        });

    }

};