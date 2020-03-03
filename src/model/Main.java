package src.model;
import java.util.*;
public class Main{
  public static void main(String[] args){
    Grille g = new Grille (3,3);
    State etat=new State(g);
    etat.affiche();
    System.out.println("Coups possibles: "+etat.getVoisins());
    etat=etat.play(6);
    etat.affiche();
    System.out.println("Coups possibles: "+etat.getVoisins());

    etat.saveState().entrySet().forEach(entry->{
    System.out.println(entry.getKey() + " " + entry.getValue());
 });
  }

}
