package src.view;
import javax.swing.*;
import java.awt.*;
import src.model.*;
import src.controller.*;
import java.awt.event.*;
import javax.swing.JMenuBar;

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
          if(! MenuGUI.menuOn) {
            MenuGUI.menuOn = true;
            new MenuGUI(Menu.this.jeu, Menu.this.vue);
          }
        }
    });
    this.add(menu);



    JButton delIm = new JButton("Remove image");
    delIm.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        Menu.this.vue.setIm(null);
        Menu.this.jeu.fireChangement();
      }
    });
    this.add(delIm);

  }
}
