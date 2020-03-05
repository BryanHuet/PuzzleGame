package src.view;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import src.model.*;
import src.controller.*;

import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Img extends JPanel{

  BufferedImage cat;
  public Img(){
    try {
    			this.cat = ImageIO.read(new File("src/view/img/cat.jpg"));
    		}
    		catch(IOException exc) {
    			exc.printStackTrace();
    		}
  }


    @Override
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      BufferedImage im = this.cat.getSubimage(0,0,500,500);
      g.drawImage(im,0,0,900,900,this);
    }




}
