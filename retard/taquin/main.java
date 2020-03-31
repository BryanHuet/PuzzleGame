package taquin;
import taquin.model.*;
import taquin.view.*;
//import taquin.controller.*;

public class main{
	public static void main(String [] args){

		Grille grille = new Grille(3,3);

		new Vue(grille);

		Jeu jeu = new Jeu(grille);
		//grille.melanger(10);
	 	grille.afficher();
	 	jeu.action(5);
	 	jeu.action(5);

	}
}