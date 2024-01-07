package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Record extends JFrame {
    private Container cp;
    String playerteam = "";

    private JPanel jpnN = new JPanel(new GridLayout(1,3,1,1));
    private Label team = new Label();
    private Label blank1 = new Label();
    private Label blank2 = new Label();

    private JPanel jpnC = new JPanel(new GridLayout(1,6,1,1));
    private Label item = new Label("2 point");
    private Label player = new Label("1");
    private Label state = new Label("Fail");
    private Label time = new Label("00:00");
    private JButton jbnDelete = new JButton("Delete");
    private JButton jbnChange = new JButton("Change");

    private JPanel jpnS = new JPanel(new GridLayout(1,4,1,1));
    private Label blank3 = new Label();
    private Label blank4 = new Label();
    private JButton jbnCancel = new JButton("Cancel");
    private JButton jbnSubmit = new JButton("Submit");

    public Record(String team){
        playerteam = team;
        init();
    }

    private void init() {
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(400,50,800,400);

        team.setText("Team : " + playerteam);
        jpnN.add(team);
        jpnN.add(blank1);
        jpnN.add(blank2);

        cp.add(jpnN, BorderLayout.NORTH);

        jpnC.add(item);
        jpnC.add(player);
        jpnC.add(state);
        jpnC.add(time);
        jpnC.add(jbnDelete);
        jpnC.add(jbnChange);

        cp.add(jpnC, BorderLayout.CENTER);

        jpnS.add(blank3);
        jpnS.add(blank4);
        jpnS.add(jbnCancel);
        jpnS.add(jbnSubmit);

        cp.add(jpnS, BorderLayout.SOUTH);

        //頁面跳轉至主畫面
        jbnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mainpart mainpart = new Mainpart();
                mainpart.setVisible(true);
                Record.this.setVisible(false);
            }
        });

        //頁面跳轉至主畫面
        jbnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mainpart mainpart = new Mainpart();
                mainpart.setVisible(true);
                Record.this.setVisible(false);
            }
        });
    }

}
