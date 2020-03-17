package taquin;
import taquin.model.*;
import taquin.view.*;
import taquin.controller.*;

public class main{
	public static void main(String [] args){
		new GUI();

		Grille grille = new Grille(3,3);
		grille.melanger(10);
		grille.afficher();
	}
}