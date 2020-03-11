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
  private Win win;

  public JeuGUI(Jeu jeu){
    super();
    this.jeu=jeu;
    this.jeu.ajoutEcouteur(this);
    Img im = new Img(jeu,"src/img/lena.png");
    this.vue = new Vue(jeu,200,im);
    //this.vue= new Img(jeu);
    this.setTitle("15-Puzzle");
    this.setVisible(true);
    this.setLayout(new BorderLayout());
    this.add(this.vue,BorderLayout.CENTER);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(true);
    this.setSize(800,800);
    this.setJMenuBar(new Menu(this.jeu));
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.win=new Win(this.jeu);

  }

  public void modeleMisAJour(Object source){
    if(this.jeu.isFinished()){
      this.win.visible(true);
      this.add(this.win,BorderLayout.EAST);
    }else{
      this.win.visible(false);
    }
  }
}
