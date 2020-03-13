package src.view;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import src.model.*;
import src.view.*;
import src.controller.*;
import java.awt.event.*;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{

  private Jeu jeu;

  public Menu(Jeu jeu){
    super();
    this.jeu=jeu;
    this.setBackground(Color.GRAY);
    JButton menu = new JButton("Personnalisation");
    menu.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
          new MenuGUI(Menu.this.jeu);
        }
    });
    this.add(menu);



    JMenu menu2 = new JMenu("?");
    this.add(menu2);

  }
}
