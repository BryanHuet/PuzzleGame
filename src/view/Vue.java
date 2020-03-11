package src.view;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import src.model.*;
import src.controller.*;

public class Vue extends JPanel implements EcouteurModele{

  private int DIM; //doit etre divisible par 10;
  private Jeu jeu;
  private Img im;

  public Vue(Jeu jeu,int dim,Img im){
    super();
    this.jeu=jeu;
    this.DIM=dim;
    this.im=im;
    this.jeu.ajoutEcouteur(this);
    this.setBackground(Color.GRAY);
    this.setLayout(new GridBagLayout());
    setVisible(true);
    setup();
  }

  public void setup(){

    GridBagConstraints c = new GridBagConstraints();
    for(int i=0;i<this.jeu.getGrille().getLargeur();i++){
      for (int j=0;j<this.jeu.getGrille().getHauteur();j++){
        if (this.jeu.getGrille().getGrille()[i][j]!=0){
          //c.weightx=0;
          //c.weighty=0;
          c.ipady=DIM;
          c.ipadx=DIM;
          c.gridx=this.jeu.getSaveJeu().get(this.jeu.getGrille().getGrille()[i][j]).get(1);
          c.gridy=this.jeu.getSaveJeu().get(this.jeu.getGrille().getGrille()[i][j]).get(0);
          this.add(new Case(this.jeu.getGrille().getGrille()[i][j]+"",this.jeu,this.im,DIM),c);

      }else{
        c.gridx=j;
        c.gridy=i;
        c.ipady=DIM;
        c.ipadx=DIM;
        this.add(new Case("",this.jeu,this.im,DIM),c);
        }
      }
    }
    for (Component co: this.getComponents()){
      co.requestFocus();
    }
  }

  public void modeleMisAJour(Object source){
    for (Component c: this.getComponents()){
      this.remove(c);
    }
    this.setup();
    this.repaint();
    this.revalidate();
  }
}
