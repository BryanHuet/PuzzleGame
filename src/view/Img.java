package src.view;

import javax.swing.*;
import java.util.*;
import src.model.*;

import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Img extends JPanel{

  private BufferedImage imLoad;
  private HashMap<Integer,BufferedImage> crop;
  private Jeu jeu;

  public Img(Jeu jeu, String path){
    super();
    this.jeu=jeu;
      try {
        this.imLoad = ImageIO.read(new File(path));
    }
    catch(Exception e) {
        this.imLoad=null;
    }
    if (this.imLoad != null) {
      if (this.imLoad.getHeight() != this.imLoad.getWidth()) {
        this.cropCarre();
      }
      this.cropImage();
    }
  }

  public BufferedImage getImLoad() {
    return imLoad;
  }

  public HashMap<Integer,BufferedImage> getImgCrop(){
        return this.crop;
    }

    public void cropImage(){
      this.crop=new HashMap<>();
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

    public void cropCarre(){
      int height=this.imLoad.getHeight();
      int width=this.imLoad.getWidth();
      if(height>width){
        this.imLoad=this.imLoad.getSubimage(0,0,width,width);
      }else{
        this.imLoad=this.imLoad.getSubimage(0,0,height,height);
      }

    }


}
