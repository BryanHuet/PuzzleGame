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
  private JTextField difficulty;


  public MenuGUI(Jeu jeu){
    super();
    this.jeu=jeu;
    this.setResizable(true);

    this.setLayout(new GridLayout(2,2));

    this.difficulty=new JTextField(15);
    this.add(this.difficulty);
    this.add(new Restart(this.jeu));
    this.setVisible(true);
    this.setSize(100,100);

  }



}
