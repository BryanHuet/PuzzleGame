package taquin.model;

public class Jeu{
	
	Grille grille;

	public Jeu(Grille grille){
		this.grille = grille;
	}

	//Méthodes

	public void action(int val){ //Retrouve la case contenant val et le déplace vers 8 si c'est possible
		for(int i = 0;i<this.grille.l();i++){
			for(int j = 0;j<this.grille.c();j++){
				if(this.grille.getGrille()[i][j]==val){
					try{
						if(this.grille.getGrille()[i-1][j]==8){
							this.grille.replace(i-1,j,i,j);
							grille.afficher();
							if(isFinished()){
								System.out.println("Victoire");
							}else{
								System.out.println("La partie n'est pas encore terminée");
							}
							return;
						}
						System.out.println("o");
					}catch(ArrayIndexOutOfBoundsException e){
						System.out.println("x");
					}

					try{
						if(this.grille.getGrille()[i+1][j]==8){
							this.grille.replace(i+1,j,i,j);
							grille.afficher();
							if(isFinished()){
								System.out.println("Victoire");
							}else{
								System.out.println("La partie n'est pas encore terminée");
							}
							return;
						}
						System.out.println("o");
					}catch(ArrayIndexOutOfBoundsException e){
						System.out.println("x");
					}

					try{
						if(this.grille.getGrille()[i][j-1]==8){
							this.grille.replace(i,j-1,i,j);
							grille.afficher();
							if(isFinished()){
								System.out.println("Victoire");
							}else{
								System.out.println("La partie n'est pas encore terminée");
							}
							return;
						}
						System.out.println("o");
					}catch(ArrayIndexOutOfBoundsException e){
						System.out.println("x");
					}

					try{
						if(this.grille.getGrille()[i][j+1]==8){
							this.grille.replace(i,j+1,i,j);
							grille.afficher();				
							if(isFinished()){
								System.out.println("Victoire");
							}else{
								System.out.println("La partie n'est pas encore terminée");
							}
							return;
						}
						System.out.println("o");
					}catch(ArrayIndexOutOfBoundsException e){
						System.out.println("x");
					}
				}
			}
		}
	}

	public boolean isFinished(){
		Grille etat1 = new Grille(grille.l(),grille.c());
		for(int i = 0;i<grille.l();i++){
			for(int j = 0;j<grille.c();j++){
				if(etat1.getGrille()[i][j] != this.grille.getGrille()[i][j]){
					return false;
				}
			}
		}
		return true;
	}
}