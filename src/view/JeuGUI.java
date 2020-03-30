package src.view;
import javax.swing.*;
import java.awt.*;
import src.model.*;

public class JeuGUI extends JFrame implements EcouteurModele{
  private Jeu jeu;
  private Win win;

  public JeuGUI(Jeu jeu){
    super();


    Img im = new Img(jeu, "dist/img/lena.png");
    Vue vue = new Vue(jeu,im);

    this.jeu=jeu;
    this.jeu.ajoutEcouteur(this);
    this.win=new Win(jeu, vue);
    //this.vue= new Img(jeu);
    this.setTitle("n-Puzzle");

    this.setLayout(new BorderLayout());
    this.add(vue,BorderLayout.CENTER);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(true);
    this.setJMenuBar(new Menu(this.jeu, vue));
    this.setSize(800,800);

    this.setLocationRelativeTo(null);

    this.setVisible(true);
  }

  public void modeleMisAJour(Object source){
    if(this.jeu.isFinished()){
      this.win.visible(true);
      this.add(this.win,BorderLayout.EAST);
    }else{
      this.win.visible(false);
    }
  }
}
