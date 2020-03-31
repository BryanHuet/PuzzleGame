package taquin.view;


import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Object;
import taquin.model.*;


public class Vue extends JFrame{

    private Grille grille;

	public Vue(Grille grille){
        this.grille = grille;
		 this.setTitle("TAQUIN"); // Titre de la Fenetre
        this.setSize(1500,1000); // Taille de la fenetre (Longueur, Hauteur)
        this.setMinimumSize(new Dimension(1286,829)); // Taille Minimum de la fenetre

        

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Lorsque on clique sur fermer, la fenetre se ferme
        
        this.setResizable(true); // Permet de resize la fenetre

        this.setLayout(new BorderLayout()); // Fonction qui permet de choisir la position elements N,W,E,S
         
        this.add(new VueGrille(grille),BorderLayout.CENTER);
    

         this.setVisible(true); //permet que la fenetre soit visible

	}


}