package src.model;
import java.util.*;

public class Jeu extends AbstractModeleEcoutable{
  private Grille grille;
  private HashMap<Integer,ArrayList<Integer>> saveJeu;
  public static boolean etat0=true;

  public Jeu(Grille grille){
    super();
    this.grille=grille;
    this.ecouteurs=new ArrayList<>();
    if (etat0){
      etat0=false;
      shuffle(10);
    }
    this.saveJeu=this.saveJeu();
  }

  public Grille getGrille(){
    return this.grille;
  }
  public HashMap<Integer,ArrayList<Integer>> getSaveJeu(){
    return this.saveJeu;
  }
  public void setGrille(Grille grille){
    this.grille=grille;
  }
  public void affiche(){
    this.grille.affiche();
  }

  public HashMap<Integer,ArrayList<Integer>> saveJeu(){
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
    Jeu newJeu = new Jeu(newGrille);
    return newJeu;
  }

  public void shuffle(int difficulty){
    Random rand = new Random();
    Jeu n = new Jeu(this.grille);
    for (int i=0; i<difficulty;i++){
      int choix=rand.nextInt(n.getVoisins().size());
      n=n.play(n.getVoisins().get(choix));
    }
  this.setGrille(n.getGrille());
  }
  public void coup(int coup){
    this.grille=this.play(coup).getGrille();
    this.saveJeu=this.play(coup).getSaveJeu();
    fireChangement();
  }

}
