package src.view;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import src.model.*;
import src.view.*;
import src.controller.*;
import java.awt.event.*;

public class JeuGUI extends JFrame implements EcouteurModele{
  private Vue vue;
  private Jeu jeu;

  public JeuGUI(Jeu jeu){
    this.jeu=jeu;
    this.jeu.ajoutEcouteur(this);
    Img im = new Img(jeu,"src/img/cat.jpg");
    this.vue = new Vue(jeu,im);
    //this.vue= new Img(jeu);
    this.setTitle("15-Puzzle");
    this.setVisible(true);
    this.setLayout(new BorderLayout());
    this.add(this.vue,BorderLayout.CENTER);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(true);
    this.pack();
    this.setSize(900,900);
    System.out.println(this.getSize());

  }

  public void modeleMisAJour(Object source){
    System.out.println("ok");
    if(this.jeu.isFinished()){
      Win win = new Win(this.jeu);
      this.add(win,BorderLayout.EAST);
    }
  }
}
