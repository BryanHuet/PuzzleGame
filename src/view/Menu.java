package src.view;
import javax.swing.*;
import java.awt.*;
import src.model.*;
import src.controller.*;
import java.awt.event.*;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class Menu extends JMenuBar{

  private Jeu jeu;
  private Vue vue;

  public Menu(Jeu jeu,Vue vue){
    super();
    this.jeu=jeu;
    this.vue=vue;
    this.setBackground(Color.GRAY);
    JButton menu = new JButton("Personnalisation");
    menu.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
          new MenuGUI(Menu.this.jeu,Menu.this.vue);
        }
    });
    this.add(menu);



    JMenu menu2 = new JMenu("?");
    this.add(menu2);

  }
}
