package src.view;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import src.model.*;
import java.awt.event.*;

public class Case extends JPanel implements MouseListener{
  private int DIM;
  private String subject;
  private Jeu jeu;

  public Case(int DIM,String subject,Jeu jeu){
    this.jeu=jeu;
    this.DIM=DIM;
    this.subject=subject;
    this.setBackground(Color.GRAY);
    addMouseListener(this);

  }


  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    Font myFont = new Font ("Courier New", 1, 50);
    g.setFont(myFont);
    if (this.subject!=""){
    g.drawRect(0,0,this.DIM,this.DIM);
    g.drawRect(0,0,this.DIM-1,this.DIM-1);
    g.drawString(this.subject,this.DIM/2,this.DIM/2);
    }
  }

  public void mousePressed(MouseEvent e) {
}

public void mouseReleased(MouseEvent e) {
}

public void mouseEntered(MouseEvent e) {
  if(this.subject != ""){
  int i = Integer.parseInt(this.subject);
  if (this.jeu.getVoisins().contains(i)){
    this.setBackground(Color.GREEN);
    }
  }
}

public void mouseExited(MouseEvent e) {
  this.setBackground(Color.GRAY);
}

public void mouseClicked(MouseEvent e) {
  if(this.subject != ""){
  int i = Integer.parseInt(this.subject);
  if (this.jeu.getVoisins().contains(i)){

    this.jeu.coup(i);
    this.jeu.affiche();
    }
  }
}

}
