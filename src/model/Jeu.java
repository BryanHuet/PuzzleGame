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

    //On mélange le jeu lors de sa première instance.
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
  public int getDifficulty(){
    return this.difficulty;
  }
  public HashMap<Integer,ArrayList<Integer>> getSaveJeu(){
    return this.saveJeu;
  }

//setters
  public void setGrille(Grille grille){
    this.grille=grille;
  }
  public void setDifficulty(int diff){
    this.difficulty=diff;
  }

  public void affiche(){
    //affiche la grille
    this.grille.affiche();
  }

  /**
   * On cherche a savoir si le jeu est fini; On parcourt donc l'emplacement de chaque case pour verifier si valeur
   * match avec une nouvelle grille non mélangée.
   *  @return true si le jeu est fini, false sinon.
   */
  public boolean isFinished(){
    //On cherche a savoir si le jeu est fini; On parcourt donc l'emplacement
    //de chaque case pour verifier sa valeur, on s'aide d'une nouvelle grille.
    Grille temp = new Grille(this.grille.getLargeur(),this.grille.getHauteur());
    for(int i = 0;i<grille.getLargeur();i++){
      for(int j = 0;j<grille.getHauteur();j++){
        if(temp.getGrille()[i][j] != this.grille.getGrille()[i][j]){
          return false;
        }
      }
    }
    return true;
  }
  /**
   * On sauvegarde la position de chaque case
   * @return HashMap où chaque case est associée à une position
   */
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

  /**
   * On cherche les voisins de la case  0
   * @return ArrayList contenant les cases voisines de la case 0
   */
  public ArrayList<Integer> getVoisins(){
    ArrayList<Integer> coord0 = this.saveJeu.get(0);
    ArrayList<Integer> voisins= new ArrayList<>();
    for (int i=0;i<this.grille.getSize();i++){
      if(this.saveJeu.get(i).get(0).equals(coord0.get(0))){
        if (this.saveJeu.get(i).get(1)==coord0.get(1)+1 || this.saveJeu.get(i).get(1)==coord0.get(1)-1){
          voisins.add(i);
        }
      }
      if(this.saveJeu.get(i).get(1).equals(coord0.get(1))){
        if(this.saveJeu.get(i).get(0)==coord0.get(0)+1 || this.saveJeu.get(i).get(0)==coord0.get(0)-1){
          voisins.add(i);
        }
      }
    }
    return voisins;
  }

  public Jeu play(int coup){
    //Doit return un jeu où la case 0 est à l'emplacement de la case coup (et inversement)
    if (! this.getVoisins().contains(coup)){
      System.out.println("impossible");
      return this;
    }
    ArrayList<Integer>coord0=this.saveJeu.get(0);
    ArrayList<Integer>coordCoup=this.saveJeu.get(coup);
    Grille newGrille=new Grille(this.grille.getLargeur(),this.grille.getHauteur());
    for (int i=0;i<this.grille.getSize();i++){
      newGrille.setGrille(this.saveJeu.get(i).get(0),this.saveJeu.get(i).get(1),i);
    }

    newGrille.setGrille(coord0.get(0),coord0.get(1),coup);
    newGrille.setGrille(coordCoup.get(0),coordCoup.get(1),0);
    return new Jeu(newGrille,this.difficulty);
  }

  public void shuffle(int difficulty){
    //fonction qui joue x(=difficulty) coups;
    Random rand = new Random();
    Jeu n = new Jeu(this.grille,this.difficulty);
    if (isFinished()) {
      for (int i = 0; i < difficulty; i++) {
        int choix = rand.nextInt(n.getVoisins().size());
        n = n.play(n.getVoisins().get(choix));
      }
    }
  this.setGrille(n.getGrille());
  }

  public void coup(int coup){
    //play le coup et met a jour l'etat present
    this.grille=this.play(coup).getGrille();
    this.saveJeu=this.play(coup).getSaveJeu();
    fireChangement();
  }


  public void reset(){
    //on reset le jeu
    this.grille=new Grille(this.grille.getLargeur(),this.grille.getHauteur());
    this.saveJeu = new HashMap<>();
    this.shuffle(this.difficulty);
    this.saveJeu = this.saveJeu();
    fireChangement();
  }

}
