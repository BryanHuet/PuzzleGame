package src.controller;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import src.model.*;
import java.awt.event.*;
import java.awt.image.*;
import src.view.*;

public class MenuGUI extends JFrame{

  private Jeu jeu;
  private Vue vue;
  private Restart res;
  private Field difficulty;
  private Field setGrille;
  private JButton setIm;

  public MenuGUI(Jeu jeu,Vue vue){
    super();
    this.jeu=jeu;
    this.vue=vue;
    this.setResizable(false);
    this.setLayout(new FlowLayout(FlowLayout.CENTER,50,30));
    this.setTitle("Personnalisation");

    this.res=new Restart(this.jeu,this.vue);
    this.difficulty=new Field("Difficulté",true);
    this.setGrille=new Field("taille grille \"n,m\"",false);
    this.setIm=new JButton("Charger image");
    this.setIm.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
          JFileChooser fileChooser = new JFileChooser(new File("."));
          PrintWriter sortie;
          File fichier=new File(".");

          if (fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
              fichier = fileChooser.getSelectedFile();
              try{
              sortie = new PrintWriter(new FileWriter(fichier.getPath(),true));
              sortie.close();
            }catch(Exception e2){}
          }
          if(! fichier.getPath().equals(".")){
            MenuGUI.this.vue.setIm(new Img(MenuGUI.this.jeu,fichier.getPath()));
          }
        }
    });
    this.res.addEntries(this.difficulty);
    this.res.addEntries(this.setGrille);

    this.add(this.setIm);
    this.add(this.difficulty);
    this.add(this.setGrille);
    this.add(this.res);
    this.setVisible(true);
    this.setSize(300,300);
    this.setLocationRelativeTo(null);
    this.setBackground(Color.GRAY);
  }



}
