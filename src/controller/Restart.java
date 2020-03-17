package src.controller;
import javax.swing.*;
import java.util.*;
import src.model.*;
import java.awt.event.*;
import src.view.*;

public class Restart extends JButton implements ActionListener{

  private Jeu jeu;
  private Vue vue;
  private ArrayList<Field> entries;


  public Restart(Jeu jeu, Vue vue){
    super("Restart");
    this.vue=vue;
    this.jeu=jeu;
    this.addActionListener(this);
    this.setVisible(true);
    this.entries=new ArrayList<>();
  }

  public void addEntries(Field field){
    this.entries.add(field);
  }

  public void actionPerformed(ActionEvent e){
    if (! this.entries.isEmpty()){
      for(Field field: this.entries){
        if (! field.getNumber().isEmpty()){
          if(field.getIsDifficult()){
            this.jeu.setDifficulty(field.getNumber().get(0));
          }else{
            this.jeu.setGrille(new Grille(field.getNumber().get(0),field.getNumber().get(1)));
            this.vue.getIm().cropImage();
          }
        }
      }
    }
    this.jeu.reset();
    }


}
