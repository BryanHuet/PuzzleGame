package taquin.model;

public class Jeu{
	
	Grille grille;

	public Jeu(Grille grille){
		this.grille = grille;
	}

	//Méthodes

	public void action(int val){ //Retrouve la case contenant val et le déplace vers 0 si c'est possible
		for(int i = 0;i<this.grille.l();i++){
			for(int j = 0;j<this.grille.c();j++){
				if(this.grille.getGrille()[i][j]==val){
					try{
						if(this.grille.getGrille()[i-1][j]==0){
							this.grille.replace(i-1,j,i,j);
							return;
						}
					}catch(ArrayIndexOutOfBoundsException e){
						if(this.grille.getGrille()[i+1][j]==0){
							this.grille.replace(i+1,j,i,j);
							return;
						}
					}
					try{
						if(this.grille.getGrille()[i][j-1]==0){
							this.grille.replace(i,j-1,i,j);
							return;
						}
					}catch(ArrayIndexOutOfBoundsException e){
						if(this.grille.getGrille()[i][j+1]==0){
							this.grille.replace(i,j+1,i,j);
							return;
						}
					}
				}
			}
		}
	}
}