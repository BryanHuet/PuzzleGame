package taquin.view;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Object;

import taquin.*;

public class VueGrille extends JPanel{


	GridLayout grid = new GridLayout(3,3,3,4);

	Grille grille = new Grille();
		
	public VueGrille(){
		
		
		this.setLayout(grid);


        


	
       // Boucle permettant de creer les cases
        for (int i =0; i<9; i++){ 
                JLabel label1 = new JLabel();  // Commentaire dans la box
                label1.setMaximumSize(new Dimension(30,50)); // Taille des cases
                label1.setOpaque( true ); // Background du label
                label1.setBackground( Color.GRAY ); // couleur du background du label
                label1.setForeground( Color.BLACK ); // couleur du texte
        
                JButton box = new JButton(" "+ grille.this.grille[i][j]);  // Creation de la box
                
                this.add(box); // Ajout des case sur la grille

               

            }
        



         this.setVisible(true); //permet que la fenetre soit visible

    }


	}
