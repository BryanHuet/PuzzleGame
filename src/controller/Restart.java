package src.controller;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import src.model.*;
import java.awt.event.*;
import java.awt.image.*;
import src.view.*;

public class Restart extends JButton implements ActionListener{

  private Jeu jeu;

  public Restart(Jeu jeu){
    super("Restart");
    this.jeu=jeu;
    this.addActionListener(this);
    this.setVisible(true);
  }


  public void actionPerformed(ActionEvent e){
    this.jeu.reset();
    }


}
