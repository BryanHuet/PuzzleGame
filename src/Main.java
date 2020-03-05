package src;
import src.model.*;
import src.controller.*;
import src.view.*;
import java.util.*;
public class Main{
  public static void main(String[] args){

    new JeuGUI(new Jeu(new Grille(3,3),50));
  }
}
