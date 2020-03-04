package src.model;
import java.util.*;

public abstract class AbstractModeleEcoutable implements ModeleEcoutable{
  private List<EcouteurModele> ecouteurs;

  public void ajoutEcouteur(EcouteurModele e){};
  public void retraitEcouteur(EcouteurModele e){};
  public void fireChangement(){
    for(EcouteurModele e: ecouteurs){
      e.modeleMisAJour(this);
    }
  };


}
