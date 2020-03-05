package src.view;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import src.model.*;
import java.awt.event.*;

public class Case extends JPanel implements MouseListener{
  private String subject;
  private Jeu jeu;

  public Case(String subject,Jeu jeu){
    this.jeu=jeu;
    this.subject=subject;
    this.setBackground(Color.GRAY);
    addMouseListener(this);
  }


  @Override
  public void paintComponent(Graphics g){
    //On dessine l'apparence d'une case
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    Font myFont = new Font ("Courier New", 1, 50);
    g.setFont(myFont);
    if (this.subject!=""){
    g.drawRect(0,0,this.getWidth(),this.getHeight());
    g.drawRect(0,0,this.getWidth()-1,this.getHeight()-1);
    g.drawString(this.subject,this.getWidth()/2,this.getHeight()/2);
    }
  }

//Implementation de MouseListener


  public void mouseEntered(MouseEvent e) {
    //Event qui permet de modifier la couleur de fond, lorsque la souris passe
    //sur un case qui permet de jouer un coup 
    if(!this.jeu.isFinished()){
      if(this.subject != ""){
      int i = Integer.parseInt(this.subject);
        if (this.jeu.getVoisins().contains(i)){
          this.setBackground(Color.GREEN);
        }
      }
    }
  }

  public void mouseExited(MouseEvent e) {
    this.setBackground(Color.GRAY);
  }

  public void mouseClicked(MouseEvent e) {
    // Lors du click on recup le sujet de la case, et on applique le coup sur
    // le jeu
    if(!this.jeu.isFinished()){
      if(this.subject != ""){
      int i = Integer.parseInt(this.subject);
      if (this.jeu.getVoisins().contains(i)){
        this.jeu.coup(i);
        }
      }
    }
  }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e){}


}
