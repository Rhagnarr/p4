package fr.uha.ensisa.puissance4.jeu.algosIA;

import fr.uha.ensisa.puissance4.data.Grille;
import fr.uha.ensisa.puissance4.data.Humain;
import fr.uha.ensisa.puissance4.data.Joueur;
import fr.uha.ensisa.puissance4.util.Constantes;


/**
	Classe implémentant l'algorithme Minimax
*/
public class Minimax extends Algorithm {

	public static final int MAX_NOTE = Integer.MAX_VALUE;

	public static final int MIN_NOTE = Integer.MIN_VALUE;

	public Minimax(int levelIA, Grille grilleDepart, Joueur joueurActuel, int tour) {
		super(levelIA, grilleDepart, joueurActuel, tour);
		
	}

	@Override
	public int choisirCoup() {
		double meilleurcoup = -1000;
		int pos =-1;
		for (int i =0; i< Constantes.NB_COLONNES;i++){
			this.grilleDepart.ajouterCoup(i,symboleMax);
			if (grilleDepart.evaluer(symboleMax)> meilleurcoup) {
				meilleurcoup= grilleDepart.evaluer(symboleMax);
				pos =i;

			}
			grilleDepart.RetirerCoup(i);
			if (meilleurcoup<Constantes.NB_COLONNES && meilleurcoup >=0)
				return (int) meilleurcoup;
		}


		return pos;
	}
	
	

	
	
	

}
