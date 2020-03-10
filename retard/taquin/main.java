package taquin;
import taquin.model.*;

public class main{
	public static void main(String [] args){
		Grille grille = new Grille(3,3);
		grille.melanger(10);
		grille.afficher();
	}
}