package src.controller;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import src.model.*;
import src.view.*;
import java.awt.event.*;

public class JeuGUI extends JFrame{
  private Img vue;
  private Jeu jeu;


  public JeuGUI(Jeu jeu){
    this.jeu=jeu;
    //this.vue = new Vue(jeu);
    this.vue= new Img();
    this.setTitle("15-Puzzle");
    this.setVisible(true);
    this.setLayout(new BorderLayout());
    this.add(this.vue,BorderLayout.CENTER);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(true);
    this.pack();
    this.setSize(900,900);
  }
}
