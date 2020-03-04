package src;
import src.model.*;
import src.controller.*;
import src.view.*;
import java.util.*;
public class Main{
  public static void main(String[] args){
    Grille g = new Grille (3,3);
    Jeu etat=new Jeu(g);

    etat.affiche();

    new JeuGUI(etat);
  }
}
