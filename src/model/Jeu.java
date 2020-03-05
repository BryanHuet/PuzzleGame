package src.model;
import java.util.*;

public class Jeu extends AbstractModeleEcoutable{
  private Grille grille;
  private HashMap<Integer,ArrayList<Integer>> saveJeu;
  public static boolean etat0=true;
  private int difficulty;

  public Jeu(Grille grille,int difficulty){
    super();
    this.grille=grille;
    this.difficulty=difficulty;
    this.ecouteurs=new ArrayList<>();

    if (etat0){
      etat0=false;
      shuffle(this.difficulty);
    }

    this.saveJeu=this.saveJeu();
  }

//getters
  public Grille getGrille(){
    return this.grille;
  }
  public HashMap<Integer,ArrayList<Integer>> getSaveJeu(){
    return this.saveJeu;
  }

//setters
  public void setGrille(Grille grille){
    this.grille=grille;
  }

  public void affiche(){
    //affiche la grille
    this.grille.affiche();
  }

  public boolean isFinished(){
    //On cherche a savoir si le jeu est fini; On parcourt donc l'emplacement
    //de chaque case pour verifier sa valeur;
    int x=1;
    for (int i=0;i<this.grille.getLargeur();i++){
      for(int j=0;j<this.grille.getHauteur();j++){
        if (x==this.grille.getLargeur()*this.grille.getHauteur()){
          return true;
        }
        ArrayList<Integer> coordx = this.getSaveJeu().get(x);
        if (coordx.get(0)!=i){
          return false;
        }
        if (coordx.get(1)!=j){
            return false;
          }
        x=x+1;
        }
      }
    return true;
}

  public HashMap<Integer,ArrayList<Integer>> saveJeu(){
    //stock dans une hashMap la position de chaque case;
    HashMap<Integer,ArrayList<Integer>> save = new HashMap<>();
    for(int i=0;i<this.grille.getLargeur();i++){
      for (int j=0;j<this.grille.getHauteur();j++){
        ArrayList<Integer> coord = new ArrayList<>();
        coord.add(i);
        coord.add(j);
        save.put(this.grille.getGrille()[i][j],coord);
      }
    }
    return save;
  }


  public ArrayList<Integer> getVoisins(){
    //On stock dans une liste les voisins de la case 0 (correspond a la case vide)
    ArrayList<Integer> coord0 = this.saveJeu.get(0);
    ArrayList<Integer> voisins= new ArrayList<>();
    for (int i=0;i<(this.grille.getLargeur()*this.grille.getHauteur());i++){
      if(this.saveJeu.get(i).get(0)==coord0.get(0)){
        if (this.saveJeu.get(i).get(1)==coord0.get(1)+1 || this.saveJeu.get(i).get(1)==coord0.get(1)-1){
          voisins.add(i);
        }
      }
      if(this.saveJeu.get(i).get(1)==coord0.get(1)){
        if(this.saveJeu.get(i).get(0)==coord0.get(0)+1 || this.saveJeu.get(i).get(0)==coord0.get(0)-1){
          voisins.add(i);
        }
      }
    }
    return voisins;
  }

  public Jeu play(int coup){
    //On intervertit la place de la case 0 et la case coup;
    if (! this.getVoisins().contains(coup)){
      System.out.println("impossible");
      return this;
    }
    ArrayList<Integer>coord0=this.saveJeu.get(0);
    ArrayList<Integer>coordCoup=this.saveJeu.get(coup);
    Grille newGrille=new Grille(this.grille.getLargeur(),this.grille.getHauteur());
    for (int i=0;i<(this.grille.getLargeur()*this.grille.getHauteur());i++){
      newGrille.setGrille(this.saveJeu.get(i).get(0),this.saveJeu.get(i).get(1),i);
    }

    newGrille.setGrille(coord0.get(0),coord0.get(1),coup);
    newGrille.setGrille(coordCoup.get(0),coordCoup.get(1),0);
    Jeu newJeu = new Jeu(newGrille,this.difficulty);
    return newJeu;
  }

  public void shuffle(int difficulty){
    //fonction qui joue x(=difficulty) coups si et seulement si etat0=true;
    Random rand = new Random();
    Jeu n = new Jeu(this.grille,this.difficulty);
    for (int i=0; i<difficulty;i++){
      int choix=rand.nextInt(n.getVoisins().size());
      n=n.play(n.getVoisins().get(choix));
    }
  this.setGrille(n.getGrille());
  }

  public void coup(int coup){
    //joue un coup;
    this.grille=this.play(coup).getGrille();
    this.saveJeu=this.play(coup).getSaveJeu();
    fireChangement();
  }

}
