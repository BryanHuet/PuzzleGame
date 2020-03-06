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

  private BufferedImage imLoad;
  private HashMap<Integer,BufferedImage> crop;
  private Jeu jeu;

  public Img(Jeu jeu, String path){
    this.jeu=jeu;
    try {
    			this.imLoad = ImageIO.read(new File(path));
    		}
    		catch(IOException e) {
    			e.printStackTrace();
    		}

    this.crop=new HashMap<>();
    this.cropImage();

  }

    public HashMap<Integer,BufferedImage> getImgCrop(){
        return this.crop;
    }

    private void cropImage(){
      int x=1;
      int dimx=this.imLoad.getHeight()/this.jeu.getGrille().getHauteur();
      int dimy=this.imLoad.getWidth()/this.jeu.getGrille().getLargeur();

      for (int i=0;i<this.jeu.getGrille().getLargeur();i++){
        for(int j=0;j<this.jeu.getGrille().getHauteur();j++){
          if (x==this.jeu.getGrille().getHauteur()*this.jeu.getGrille().getLargeur()){
            break;
          }
          BufferedImage im = this.imLoad.getSubimage(j*dimx,i*dimy,dimx,dimy);
          this.crop.put(x,im);
          x=x+1;
        }
      }
    }


}
