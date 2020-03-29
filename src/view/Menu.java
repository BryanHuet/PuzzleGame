package src.view;
import javax.swing.*;
import java.awt.*;
import src.model.*;
import src.controller.*;
import javax.swing.JMenuBar;

public class Menu extends JMenuBar{

  private Jeu jeu;
  private Vue vue;

  private JButton delIm;
  public static Img img;
  public static boolean im=true;

  public Menu(Jeu jeu,Vue vue){
    super();
    this.jeu=jeu;
    this.vue=vue;
    img = this.vue.getIm();
    this.setBackground(Color.GRAY);
    JButton menu = new JButton("Personnalisation");
    menu.addActionListener(e -> {
      if(! MenuGUI.menuOn) {
        MenuGUI.menuOn = true;
        new MenuGUI(Menu.this.jeu, Menu.this.vue);
      }
    });
    this.add(menu);



    this.delIm= new JButton("Image : on");
    delIm.addActionListener(e -> {
      Menu.im= !Menu.im;
      if(Menu.this.vue.getIm() != null){
        Menu.img=Menu.this.vue.getIm();
      }
      if(Menu.im){
        Menu.this.delIm.setText("Image : on");
        Menu.this.vue.setIm(Menu.img);
      }else{
        Menu.this.delIm.setText("Image : off");
        Menu.this.vue.setIm(null);
      }
      Menu.this.jeu.fireChangement();
    });
    this.add(delIm);

  }
}
