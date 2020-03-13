package src.controller;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import src.model.*;
import java.awt.event.*;
import java.awt.image.*;
import src.view.*;

public class MenuGUI extends JFrame{

  private Jeu jeu;
  private Restart res;
  private Field difficulty;
  private Field setGrille;

  public MenuGUI(Jeu jeu){
    super();
    this.jeu=jeu;
    //this.setResizable(true);
    this.setLayout(new FlowLayout(FlowLayout.CENTER,100,50));
    this.setTitle("Personnalisation");

    this.res=new Restart(this.jeu);
    this.difficulty=new Field("Difficulté",true);
    this.setGrille=new Field("taille grille \"n,m\"",false);


    this.res.addEntries(this.difficulty);
    this.res.addEntries(this.setGrille);
    this.add(this.difficulty);
    this.add(this.setGrille);
    this.add(this.res);
    this.setVisible(true);
    this.setSize(300,300);
    this.setLocationRelativeTo(null);
    this.setBackground(Color.GRAY);
  }



}
