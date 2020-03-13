package src.controller;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import src.model.*;
import java.awt.event.*;
import java.awt.image.*;
import src.view.*;

public class Restart extends JButton implements ActionListener{

  private Jeu jeu;
  private ArrayList<Field> entries;


  public Restart(Jeu jeu){
    super("Restart");
    this.jeu=jeu;
    this.addActionListener(this);
    this.setVisible(true);
    this.entries=new ArrayList<>();
  }

  public void addEntries(Field field){
    this.entries.add(field);
  }
  public void removeEntries(Field field){
    this.entries.remove(field);
  }

  public void actionPerformed(ActionEvent e){
    String recup="";
    System.out.println(recup);
    //this.jeu.setDifficulty(diff);
    this.jeu.reset();
    }


}
