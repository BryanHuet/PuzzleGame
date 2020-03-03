package src.view;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import src.model.*;

public class Vue extends JPanel{

  public final static int DIM = 200;
  private Jeu jeu;

  public Vue(Jeu jeu){
    this.jeu=jeu;
    this.setBackground(Color.GRAY);

  }


  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    Font myFont = new Font ("Courier New", 1, 50);
    g.setFont(myFont);
    for(int i=0;i<this.jeu.getGrille().getLargeur();i++){
      for (int j=0;j<this.jeu.getGrille().getHauteur();j++){
        g.drawRect(i*DIM+50,j*DIM+50,DIM,DIM);
        g.drawRect(i*DIM+49,j*DIM+49,DIM,DIM);
        if (this.jeu.getGrille().getGrille()[j][i]!=0){
          g.drawString(""+this.jeu.getGrille().getGrille()[j][i],(i*DIM+50)+100,(j*DIM+50)+100);
        }
    }

    }
  }

}
