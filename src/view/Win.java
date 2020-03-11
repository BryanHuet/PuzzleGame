package src.view;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import src.model.*;
import src.controller.*;

public class Win extends JPanel{
  private Jeu jeu;
  private JButton restart;
  //private JTextField difficulty;


  public Win(Jeu jeu){
    super();
    this.jeu=jeu;
    this.setBackground(Color.GRAY);
    //this.difficulty=new JTextField("setDifficulty",15);
    //this.add(this.difficulty);
    this.restart = new Restart(this.jeu);
    this.add(this.restart);
  }

    
  public void visible(Boolean bool){
    this.setVisible(bool);
    this.restart.setVisible(bool);
  }

/*
  private void setDifficulty(){
    int diff=Integer.parseInt(this.difficulty.getText());
    this.jeu.setDifficulty(diff);
  }
*/

}
