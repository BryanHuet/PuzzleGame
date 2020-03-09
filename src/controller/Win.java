package src.controller;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import src.model.*;
import src.controller.*;

public class Win extends JPanel{
  private Jeu jeu;
  private JButton restart;


  public Win(Jeu jeu){
    this.jeu=jeu;
    this.restart=new JButton("restart");
    this.add(this.restart,BorderLayout.CENTER);
    this.setVisible(true);
    this.setBackground(Color.GREEN);

    this.restart.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        System.out.println("res");
        Win.this.jeu.reset();
        }
      });



  }


}
