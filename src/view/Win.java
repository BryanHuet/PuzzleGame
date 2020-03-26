package src.view;
import javax.swing.*;
import java.awt.*;
import src.model.*;
import src.controller.*;

public class Win extends JPanel{
  private JButton restart;


  public Win(Jeu jeu, Vue vue){
    super();
    this.setLayout(new FlowLayout(FlowLayout.CENTER,25,300));
    this.setBackground(Color.GRAY);
    this.restart = new Restart(jeu, vue);
    this.add(this.restart);
  }


  public void visible(Boolean bool){
    this.setVisible(bool);
    this.restart.setVisible(bool);
  }
}
