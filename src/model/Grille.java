package src.model;

public class Grille{
  private int largeur;
  private int hauteur;
  private int[][] grille;

  public Grille(int largeur,int hauteur){
    this.largeur=largeur;
    this.hauteur=hauteur;
    this.grille=this.construct();
  }

//getters
  public int getLargeur(){
    return this.largeur;
  }
  public int getHauteur(){
    return this.hauteur;
  }
  public int[][] getGrille(){
    return this.grille;
  }

  public int getSize(){
    return this.largeur*this.hauteur;
  }

//setter
  public void setGrille(int i,int j,int val){
    this.grille[i][j]=val;
  }

//methodes
  public int[][] construct(){
    //return un tableau 2D, on placera 0 en fin
    //on empeche la creation de grille insoluble
    if((getSize() == 0) || (getSize()==1)){
      this.largeur=2;
      this.hauteur=2;
    }
    int[][] g= new int[this.largeur][this.hauteur];
    int cmpt=1;
    for(int i=0;i<this.largeur;i++){
      for(int j=0;j<this.hauteur;j++){
        g[i][j]=cmpt;
        cmpt++;
      }
    }
    g[this.largeur-1][this.hauteur-1]=0;
    return g;
  }


  public void affiche(){
    //affiche la grille
    System.out.println();
    for(int i=0;i<this.largeur;i++){
      for(int j=0;j<this.hauteur;j++){
        System.out.print(this.grille[i][j]+" ");
      }
      System.out.println();
    }
  }



}
