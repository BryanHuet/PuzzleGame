package src.controller;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import src.model.*;
import src.view.*;

public class Win extends JPanel{
  private Jeu jeu;
  private JButton restart;
  private Vue vue;
  private JTextField difficulty;


  public Win(Jeu jeu,Vue vue){
    super();
    this.jeu=jeu;
    this.vue=vue;
    this.setBackground(Color.GRAY);


    this.difficulty=new JTextField("setDifficulty",15);
    this.add(this.difficulty);

    this.restart=new JButton("restart");
    this.add(this.restart);





    this.restart.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        setDifficulty();
        Win.this.jeu.reset();
        Win.this.setVisible(false);
        Win.this.vue.setVisible(true);
        }
      });
  }


  private void setDifficulty(){
    int diff=Integer.parseInt(this.difficulty.getText());
    this.jeu.setDifficulty(diff);
  }


}
