package src.view;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import src.model.*;

public class Vue extends JPanel{

  public final static int DIM = 200;
  private Jeu jeu;

  public Vue(Jeu jeu){
    this.jeu=jeu;
    this.setBackground(Color.GRAY);
    this.setLayout(new GridLayout(this.jeu.getGrille().getLargeur(),this.jeu.getGrille().getHauteur()));

    for(int i=0;i<this.jeu.getGrille().getLargeur();i++){
      for (int j=0;j<this.jeu.getGrille().getHauteur();j++){
        if (this.jeu.getGrille().getGrille()[i][j]!=0){
        this.add(new Case(200,this.jeu.getGrille().getGrille()[i][j]+"",this.jeu));
      }else{
        this.add(new Case(200,"",this.jeu));
        }
      }
    }

  }
}
