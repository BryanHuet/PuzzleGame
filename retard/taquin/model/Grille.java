package taquin.model;
import java.util.*;

public class Grille{
	private int l;
	private int c;

	private int[][] grille;

	public Grille(int l, int c){ //Initialise et créée la grille
		this.l = l;
		this.c = c;
		grille = new int[this.l][this.c];
		for(int i=0; i<this.l*this.c; i++){	//2 boucle car tableau a 2 dimension
			int i2 = (int)((i-i%this.l)/this.c);
			int j2 = (int)(i%this.c);
			/*System.out.println(""+i2);
			System.out.println(""+j2);*/	
			this.grille[i2][j2]= i;
		}
	}

	//Getters

	public int[][] getGrille(){
		return this.grille;
	}

	public int l(){
		return this.l;
	}

	public int c(){
		return this.c;
	}

	// Méthodes

	public void afficher(){
		System.out.println();
		for(int i=0; i<l; i++){	//2 boucle car tableau a 2 dimension
			for(int j=0; j<c;j++){
				System.out.print("|" + grille[i][j]);
			}
			System.out.println("|");
		}
		System.out.println();
	}

	public void melanger(int j){ //echange de piece aleatoirement
		Random random = new Random();
		int temp;
		for(int i = 0; i<j; i++){
			int a = random.nextInt(this.l-1);
			int b = random.nextInt(this.c-1);

			int c = random.nextInt(this.l-1);
			int d = random.nextInt(this.c-1);

			temp = this.grille[a][b];
			this.grille[a][b] = this.grille[c][d];
			this.grille[c][d] = temp;
		}
	}

	public void replace(int i, int j, int l, int c){
		int temp = this.grille[i][j];
		this.grille[i][j] = this.grille[l][c];
		this.grille[l][c] = temp;
	}

}