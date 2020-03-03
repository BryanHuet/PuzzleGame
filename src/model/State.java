package src.model;
import java.util.*;

public class State{
  private Grille grille;
  private HashMap<Integer,ArrayList<Integer>> saveState;

  public State(Grille grille){
    this.grille=grille;
    this.saveState=this.saveState();
  }

  public void affiche(){
    this.grille.affiche();
  }

  public HashMap<Integer,ArrayList<Integer>> saveState(){
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


  public HashSet<Integer> getVoisins(){
    ArrayList<Integer> coord0 = this.saveState.get(0);
    int max= coord0.get(0) + coord0.get(1);
    HashSet<Integer> voisins= new HashSet<>();
    for (int i=0;i<(this.grille.getLargeur()*this.grille.getHauteur());i++){
      if(this.saveState.get(i).get(0)==coord0.get(0)){
        if (this.saveState.get(i).get(1)==coord0.get(1)+1 || this.saveState.get(i).get(1)==coord0.get(1)-1){
          voisins.add(i);
        }
      }
      if(this.saveState.get(i).get(1)==coord0.get(1)){
        if(this.saveState.get(i).get(0)==coord0.get(0)+1 || this.saveState.get(i).get(0)==coord0.get(0)-1){
          voisins.add(i);
        }
      }
    }
    return voisins;
  }

  public State play(int coup){
    if (! this.getVoisins().contains(coup)){
      System.out.println("impossible");
      return this;
    }
    ArrayList<Integer>coord0=this.saveState.get(0);
    ArrayList<Integer>coordCoup=this.saveState.get(coup);
    Grille newGrille=new Grille(this.grille.getLargeur(),this.grille.getHauteur());
    for (int i=0;i<(this.grille.getLargeur()*this.grille.getHauteur());i++){
      newGrille.setGrille(this.saveState.get(i).get(0),this.saveState.get(i).get(1),i);
    }

    newGrille.setGrille(coord0.get(0),coord0.get(1),coup);
    newGrille.setGrille(coordCoup.get(0),coordCoup.get(1),0);
    State newState = new State(newGrille);
    return newState;
  }

}
