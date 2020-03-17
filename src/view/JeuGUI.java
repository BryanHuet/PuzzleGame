package src.view;
import javax.swing.*;
import java.awt.*;
import src.model.*;

public class JeuGUI extends JFrame implements EcouteurModele{
  private Jeu jeu;
  private Win win;

  public JeuGUI(Jeu jeu){
    super();
    this.jeu=jeu;
    this.jeu.ajoutEcouteur(this);
    Img im = new Img(this.jeu, "src/img/lena.png");
    Vue vue = new Vue(this.jeu, im);
    //this.vue= new Img(jeu);
    this.setTitle("15-Puzzle");
    this.setVisible(true);
    this.setLayout(new BorderLayout());
    this.add(vue,BorderLayout.CENTER);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(true);
    this.setJMenuBar(new Menu(this.jeu, vue));
    this.setSize(800,800);

    this.setLocationRelativeTo(null);
    this.win=new Win(this.jeu, vue);

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
