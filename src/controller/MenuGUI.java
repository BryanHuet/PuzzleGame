package src.controller;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import src.model.*;
import java.awt.event.*;
import src.view.*;

public class MenuGUI extends JFrame{

  private Jeu jeu;
  private Vue vue;
  public static boolean menuOn = false;

  public MenuGUI(Jeu jeu,Vue vue){
    super();
    this.jeu=jeu;
    this.vue=vue;
    this.setResizable(false);
    this.setLayout(new FlowLayout(FlowLayout.CENTER,50,30));
    this.setTitle("Personnalisation");

    Restart res = new Restart(this.jeu, this.vue);
    Field difficulty = new Field("Difficulté", true);
    Field setGrille = new Field("taille grille \"n,m\"", false);
    JButton setIm = new JButton("Charger image");
    setIm.addActionListener(e -> {

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
    });

    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        menuOn=false;
      }
    });


    res.addEntries(difficulty);
    res.addEntries(setGrille);

    this.add(setIm);
    this.add(difficulty);
    this.add(setGrille);
    this.add(res);
    this.setVisible(true);
    this.setSize(300,300);
    this.setLocationRelativeTo(null);
    this.setBackground(Color.GRAY);
  }



}
