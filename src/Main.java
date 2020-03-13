package src;
import src.model.*;
import src.controller.*;
import src.view.*;
import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
public class Main{
  public static void main(String[] args){


    new JeuGUI(new Jeu(new Grille(3,3),1));
    //new MenuGUI(new Jeu(new Grille(3,3),1));




}
}
