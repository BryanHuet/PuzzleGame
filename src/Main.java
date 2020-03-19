package src;
import src.model.*;
import src.view.*;

public class Main{
  public static void main(String[] args){
    new JeuGUI(new Jeu(new Grille(3,3),1));


}
}
