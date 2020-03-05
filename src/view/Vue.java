package src.view;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import src.model.*;
import src.controller.*;

public class Vue extends JPanel implements EcouteurModele{

  public final static int DIM = 200; //doit etre divisible par 10;
  private Jeu jeu;

  public Vue(Jeu jeu){
    this.jeu=jeu;
    this.jeu.ajoutEcouteur(this);
    this.setBackground(Color.GRAY);
    this.setLayout(new GridBagLayout());
    setup();

  }


    public void setup(){

      GridBagConstraints c = new GridBagConstraints();
    for(int i=0;i<this.jeu.getGrille().getLargeur();i++){
      for (int j=0;j<this.jeu.getGrille().getHauteur();j++){
        if (this.jeu.getGrille().getGrille()[i][j]!=0){
          c.weightx=0.5;
          c.weighty=0.5;
          c.ipady=DIM;
          c.ipadx=DIM;
          c.gridx=this.jeu.getSaveJeu().get(this.jeu.getGrille().getGrille()[i][j]).get(1);
          c.gridy=this.jeu.getSaveJeu().get(this.jeu.getGrille().getGrille()[i][j]).get(0);
           this.add(new Case(this.jeu.getGrille().getGrille()[i][j]+"",this.jeu),c);

      }else{
        c.weightx=0.5;
        c.weighty=0.5;
        c.gridx=i;
        c.gridy=j;
        c.ipady=DIM;
        c.ipadx=DIM;
        this.add(new Case("",this.jeu));
        }
      }
    }
  }

  public void modeleMisAJour(Object source){
    System.out.println("hello");
    this.jeu.getSaveJeu().entrySet().forEach(entry -> {
      System.out.println(entry.getKey()+ " " + entry.getValue());
    });
    for (Component c: this.getComponents()){
      this.remove(c);
    }
    this.setup();
    this.repaint();
    this.revalidate();
  }
}
