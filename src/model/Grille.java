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


  public int getLargeur(){
    return this.largeur;
  }
  public int getHauteur(){
    return this.hauteur;
  }
  public int[][] getGrille(){
    return this.grille;
  }

  public void setGrille(int i,int j,int val){
    this.grille[i][j]=val;
  }

  public int[][] construct(){
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
    for(int i=0;i<this.largeur;i++){
      for(int j=0;j<this.hauteur;j++){
        System.out.print(this.grille[i][j]+" ");
      }
      System.out.println();
    }
  }

}
