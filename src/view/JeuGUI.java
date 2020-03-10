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
    super();
    this.jeu=jeu;
    this.jeu.ajoutEcouteur(this);
    Img im = new Img(jeu,"src/img/lena.png");
    this.vue = new Vue(jeu,im);
    //this.vue= new Img(jeu);
    this.setTitle("15-Puzzle");
    this.setVisible(true);
    this.setLayout(new BorderLayout());
    this.add(this.vue,BorderLayout.CENTER);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(true);
    this.pack();
    //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setSize(1000,1000);

  }

  public void modeleMisAJour(Object source){
    Win win = new Win(this.jeu,this.vue);
    if(this.jeu.isFinished()){
      this.add(win,BorderLayout.EAST);
    }

  }
}
