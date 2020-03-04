package src.view;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import src.model.*;
import src.controller.*;

public class Vue extends JPanel{

  public final static int DIM = 200; //doit etre divisible par 10;
  private Jeu jeu;
  public HashSet<Case> ecouteur;

  public Vue(Jeu jeu){
    this.jeu=jeu;
    this.setBackground(Color.GRAY);
    this.setLayout(new GridLayout(this.jeu.getGrille().getLargeur(),this.jeu.getGrille().getHauteur(),DIM/10,DIM/10));
    this.ecouteur=new HashSet<>();
    for(int i=0;i<this.jeu.getGrille().getLargeur();i++){
      for (int j=0;j<this.jeu.getGrille().getHauteur();j++){
        if (this.jeu.getGrille().getGrille()[i][j]!=0){
          Case newCase = new Case(this.jeu.getGrille().getGrille()[i][j]+"",this.jeu);
          this.add(newCase);
          this.ecouteur.add(newCase);
      }else{
        this.add(new Case("",this.jeu));
        }
      }
    }
  }


}
