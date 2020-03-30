package src.controller;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import src.model.*;
import java.awt.event.*;
import java.awt.image.*;
import src.view.*;

public class Case extends JPanel implements MouseListener, KeyListener{
  private String subject;
  private Jeu jeu;
  private Img im;
  private int DIM;

  public Case(String subject,Jeu jeu, Img im, int DIM){
    super();
    this.jeu=jeu;
    this.subject=subject;
    this.im=im;
    this.DIM=DIM;
    this.setBackground(Color.GRAY);

    addKeyListener(this);
    addMouseListener(this);
    setFocusable(true);

  }


  @Override
  public void paintComponent(Graphics g){
    //On dessine l'apparence d'une case
    super.paintComponent(g);
    if (! this.subject.equals("")){
      if(this.im != null && this.im.getImLoad() != null) {
        int i = Integer.parseInt(this.subject);
        BufferedImage im2 = im.getImgCrop().get(i);
        g.drawImage(im2, 0, 0, DIM, DIM, this);
      }else {
        g.setColor(Color.WHITE);
        Font myFont = new Font("Courier New", Font.BOLD, DIM / 2);
        g.setFont(myFont);
        g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        g.drawString(this.subject, this.getWidth() / 2, this.getHeight() / 2);
      }
    }
  }


//Implementation de MouseListener

  public void mouseEntered(MouseEvent e) {
    //Event qui permet de modifier la couleur de fond, lorsque la souris passe sur un case
    if(!this.jeu.isFinished()){
      if(! this.subject.equals("")){
      int i = Integer.parseInt(this.subject);
        if (this.jeu.getVoisins().contains(i)){
          this.setBackground(Color.BLACK);
        }
      }
    }
  }

  public void mouseExited(MouseEvent e) {
    this.setBackground(Color.GRAY);
  }

  public void mouseClicked(MouseEvent e) {
    // Lors du click on recupère le sujet de la case, et on applique le coup sur le jeu
    if(!this.jeu.isFinished()){
      if(! this.subject.equals("")){
      int i = Integer.parseInt(this.subject);
      if (this.jeu.getVoisins().contains(i)){
        this.jeu.coup(i);
        }
      }
    }
  }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e){}

//Implementation de KeyListener

    public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e){
      if(!this.jeu.isFinished()){
        int key = e.getKeyCode();
        ArrayList<Integer> coord0= this.jeu.getSaveJeu().get(0);
        ArrayList<Integer> list = new ArrayList<>();

        if (key==KeyEvent.VK_UP){
          list.add(coord0.get(0)-1);
          list.add(coord0.get(1));
          for(Integer v: this.jeu.getVoisins()){
            if(this.jeu.getSaveJeu().get(v).equals(list)){
              this.jeu.coup(v);
              }
            }
          list.clear();
        }
        if (key==KeyEvent.VK_DOWN){
          list.add(coord0.get(0)+1);
          list.add(coord0.get(1));
          for(Integer v: this.jeu.getVoisins()){
            if(this.jeu.getSaveJeu().get(v).equals(list)){
              this.jeu.coup(v);
              }
            }
          list.clear();
        }
        if (key==KeyEvent.VK_LEFT){
          list.add(coord0.get(0));
          list.add(coord0.get(1)-1);
          for(Integer v: this.jeu.getVoisins()){
            if(this.jeu.getSaveJeu().get(v).equals(list)){
              this.jeu.coup(v);
              }
            }
          list.clear();
        }
        if (key==KeyEvent.VK_RIGHT){
          list.add(coord0.get(0));
          list.add(coord0.get(1)+1);
          for(Integer v: this.jeu.getVoisins()){
            if(this.jeu.getSaveJeu().get(v).equals(list)){
              this.jeu.coup(v);
              }
            }
          list.clear();
        }
      }
    }
    public void keyReleased(KeyEvent e){}


}
