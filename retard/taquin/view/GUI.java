package taquin.view;


import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Object;



public class GUI extends JFrame {

    //Dimension de la grille (20x20,hgap,vgap) 
    GridLayout grid = new GridLayout(3,3,3,4);
    //Creation de la fenetre (frame)
    JFrame frame = new JFrame();

    JPanel panel = new JPanel();

    
    //C
    // La fenetre
    public GUI(){

        



        frame.setTitle("Solveur"); // Titre de la Fenetre
        frame.setSize(1500,1000); // Taille de la fenetre (Longueur, Hauteur)
        frame.setMinimumSize(new Dimension(1286,829)); // Taille Minimum de la fenetre

        

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Lorsque on clique sur fermer, la fenetre se ferme
        
        frame.setResizable(true); // Permet de resize la fenetre

        frame.setLayout(new BorderLayout()); // Fonction qui permet de choisir la position elements N,W,E,S
                
    
         JPanel panel = new JPanel();
        frame.add(panel,BorderLayout.CENTER); // Panel de la grille centré
            panel.setLayout(grid);
    
        //Creation du Panel du Menu
        
        // Boucle permettant de creer les cases
        for (int i =0; i<9; i++){ 
                JLabel label1 = new JLabel();  // Commentaire dans la box
                label1.setMaximumSize(new Dimension(30,50)); // Taille des cases
                label1.setOpaque( true ); // Background du label
                label1.setBackground( Color.GRAY ); // couleur du background du label
                label1.setForeground( Color.BLACK ); // couleur du texte
        
                JButton box = new JButton("non");  // Creation de la box
                
                panel.add(box); // Ajout des case sur la grille

               

            }
        
         frame.setVisible(true); //permet que la fenetre soit visible

    }
}
