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
    this.setLayout(new GridLayout(this.jeu.getGrille().getLargeur(),this.jeu.getGrille().getHauteur(),DIM/10,DIM/10));
    setup();

  }


    public void setup(){
    for(int i=0;i<this.jeu.getGrille().getLargeur();i++){
      for (int j=0;j<this.jeu.getGrille().getHauteur();j++){
        if (this.jeu.getGrille().getGrille()[i][j]!=0){
          this.add(new Case(this.jeu.getGrille().getGrille()[i][j]+"",this.jeu));
      }else{
        this.add(new Case("",this.jeu));
        }
      }
    }
  }

  public void modeleMisAJour(Object source){
    System.out.println("hello");
  }
}
