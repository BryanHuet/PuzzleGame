package src.controller;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Field extends JTextField implements MouseListener,KeyListener{
  private String subject;
  private Boolean isDifficult;

  public Field(String subject,Boolean isDifficult){
    super(subject,15);
    this.subject=subject;
    this.isDifficult=isDifficult;
    this.setFont(new Font("SansSerif",Font.ITALIC,15));
    this.setForeground(Color.GRAY);
    this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    this.setPreferredSize(new Dimension(30,30));
    this.setHorizontalAlignment(JTextField.CENTER);
    addMouseListener(this);
    addKeyListener(this);
  }

  public Boolean getIsDifficult(){
    return this.isDifficult;
  }

  public ArrayList<Integer> getNumber(){
    ArrayList<Integer> numbers = new ArrayList<>();
    if (isDifficult){
      try{
        numbers.add(Integer.parseInt(this.getText()));
      }
      catch(Exception e){}
    }else{
      try{
        String[] getNM = this.getText().split(",");
        numbers.add(Integer.parseInt(getNM[0]));
        numbers.add(Integer.parseInt(getNM[1]));
      }
      catch(Exception e){}
    }
    return numbers;
  }





  //Implementation de MouseListener
    public void mouseClicked(MouseEvent e) {
      if (this.getText().equals(this.subject)){
        this.setText("");
        this.setFont(new Font("Verdana",Font.PLAIN,15));
        this.setForeground(Color.BLACK);
      }
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e){}

    //Implementation de KeyListener

    public void keyPressed(KeyEvent e){
      if (this.getText().equals(this.subject)){
        this.setText("");
        this.setFont(new Font("Verdana",Font.PLAIN,15));
        this.setForeground(Color.BLACK);
      }
    }
    public void keyReleased(KeyEvent e){
      if (this.getText().equals("")){
        this.setText(this.subject);
        this.setFont(new Font("SansSerif",Font.ITALIC,15));
        this.setForeground(Color.GRAY);
      }


      try{
        if(this.isDifficult){
          this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          Integer.parseInt(this.getText());
        }else{
          this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          String[] getNM = this.getText().split(",");
          Integer.parseInt(getNM[0]);
          Integer.parseInt(getNM[1]);
        }
      }
      catch(Exception en){
        this.setBorder(BorderFactory.createLineBorder(Color.RED));
      }
    }
    public void keyTyped(KeyEvent e){}




}
