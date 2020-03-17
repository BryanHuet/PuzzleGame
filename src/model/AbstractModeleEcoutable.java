package src.model;
import java.util.*;

public abstract class AbstractModeleEcoutable implements ModeleEcoutable{
  public List<EcouteurModele> ecouteurs;

  public void ajoutEcouteur(EcouteurModele e){
    this.ecouteurs.add(e);
  }
  public void retraitEcouteur(EcouteurModele e){}
  public void fireChangement(){
    for(EcouteurModele e: ecouteurs){
      e.modeleMisAJour(this);
    }
  }


}
