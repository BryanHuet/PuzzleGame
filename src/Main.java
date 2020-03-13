package src;
import src.model.*;
import src.controller.*;
import src.view.*;
import java.util.*;
public class Main{
  public static void main(String[] args){


    //new JeuGUI(new Jeu(new Grille(3,3),1));
    new MenuGUI(new Jeu(new Grille(3,3),1));
    String a="10,15";
    System.out.println(a.split(",")[1]);
  }
}
