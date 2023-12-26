package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
  //  private JFrame frame;
  private JButton enterBtn;
  private JLabel resultLabel;
  private JTextField inputText;
  private JPanel panel;
//  private Player player;

  public MainFrame() {

  }

  public void frameInit() {
//    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.enterBtn = new JButton("Enter");
    this.resultLabel = new JLabel("Result: ");
    this.inputText = new JTextField("");
    this.panel = new JPanel();

    inputText.setSize(100, 20);
    enterBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Player player = new Player();
        player.setFta(1.0d);
        player.setFtm(Double.parseDouble(inputText.getText()));
        resultLabel.setText(Double.toString(player.ft()));
      }
    });

    panel.add(inputText);
    panel.add(enterBtn);
    panel.add(resultLabel);

    this.add(panel);
    this.setSize(300, 300);
  }

}
