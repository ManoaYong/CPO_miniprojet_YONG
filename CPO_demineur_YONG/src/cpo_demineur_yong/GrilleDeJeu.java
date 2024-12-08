/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpo_demineur_yong;

import java.util.Random;

/**
 *
 * @author manoa
 */
public class GrilleDeJeu {

    Random r = new Random();

    Cellule[][] matricesCellule; //Tableau contenant les cellules
    private int nbLignes; //Nombre de ligne dans la grille 
    private int nbColonnes; //Nombre de colonne dans la grille
    private int nbBombes; //Nombre total de bombes placées dans la grille

    public int getNbLines() { //accesseur 
        return nbLignes;
    }

    public int getNbColonnes() { //accesseur
        return nbColonnes;
    }

    public int getNbBombes() { //accesseur
        return nbBombes;
    }

    public void placerBombesAleatoirement() {
        int i = 0;
        while (i < nbBombes) {
            int x = r.nextInt(nbLignes) - 1;
            int y = r.nextInt(nbColonnes) - 1;
            if (matricesCellule[x][y].getPresenceBombe() == false) {
                matricesCellule[x][y].placerBombe();
                i++; //Incrémente le nombre de bombe placées
            } else {
            }
        }
    }

    public void calculerBombesAdjacentes() { //Méthide de calculedes bombes adjacentes
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) { //double boucle pour parcourir le tableau
                int cpt = 0; //Compteur de bombes adjacentes qui va s'incrémenter
                if (matricesCellule[i][j].getPresenceBombe() == false) {

                    if (i + 1 < nbLignes && matricesCellule[i + 1][j].getPresenceBombe() == true) {
                        cpt++; //Pour vérifier si on est bien dans la grille //En bas
                    }
                    if (i - 1 >= 0 && i < nbLignes && j >= 0 && j < nbColonnes && matricesCellule[i - 1][j].getPresenceBombe() == true) {
                        cpt++; //En haut
                    }
                    if (i - 1 >= 0 && i < nbLignes && j >= 0 && j + 1 < nbColonnes && matricesCellule[i - 1][j + 1].getPresenceBombe() == true) {
                        cpt++; //En haut à droite
                    }
                    if (i - 1 >= 0 && i < nbLignes && j - 1 >= 0 && j < nbColonnes && matricesCellule[i - 1][j - 1].getPresenceBombe() == true) {
                        cpt++;//En haut à gauche
                    }
                    if (i >= 0 && i < nbLignes && j >= 0 && j + 1 < nbColonnes && matricesCellule[i][j + 1].getPresenceBombe() == true) {
                        cpt++; //A droite
                    }
                    if (i >= 0 && i < nbLignes && j >= 0 && j - 1 < nbColonnes && matricesCellule[i][j - 1].getPresenceBombe() == true) {
                        cpt++; //A gauche
                    }
                    if (i + 1 >= 0 && i < nbLignes && j >= 0 && j + 1 < nbColonnes && matricesCellule[i + 1][j + 1].getPresenceBombe() == true) {
                        cpt++; //En bas à droite
                    }
                    if (i + 1 >= 0 && i < nbLignes && j - 1 >= 0 && j < nbColonnes && matricesCellule[i + 1][j - 1].getPresenceBombe() == true) {
                        cpt++; //En bas à gauche
                    }
                    /*
                    if (i == 0 && j == 0) { //Coin supérieur gauche
                        if (matricesCellule[i + 1][j].getPresenceBombe() == true) {
                            cpt += 1;
                        }
                        if (matricesCellule[i][j + 1].getPresenceBombe() == true) {
                            cpt += 1;
                        }
                        if (matricesCellule[i + 1][j + 1].getPresenceBombe() == true) {
                            cpt += 1;
                        }
                    }//Fin coin supérieur gauche

                    if (i == 0 && j == nbColonnes - 1) { //Coin supérieur droit
                        if (matricesCellule[i + 1][j].getPresenceBombe() == true) {
                            cpt += 1;
                        }
                        if (matricesCellule[i][j - 1].getPresenceBombe() == true) {
                            cpt += 1;
                        }
                        if (matricesCellule[i + 1][j - 1].getPresenceBombe() == true) {
                            cpt += 1;
                        }
                    }//Fin coin supérieur droit

                    if (i == nbLignes - 1 && j == 0) { //Coin inférieur gauche
                        if (matricesCellule[i - 1][j].getPresenceBombe() == true) {
                            cpt += 1;
                        }
                        if (matricesCellule[i][j + 1].getPresenceBombe() == true) {
                            cpt += 1;
                        }
                        if (matricesCellule[i - 1][j + 1].getPresenceBombe() == true) {
                            cpt += 1;
                        }
                    }//Fin coin inférieur gauche

                    if (i == nbLignes - 1 && j == nbColonnes - 1) { //Coin inférieur droit
                        if (matricesCellule[i - 1][j].getPresenceBombe() == true) {
                            cpt += 1;
                        }
                        if (matricesCellule[i][j - 1].getPresenceBombe() == true) {
                            cpt += 1;
                        }
                        if (matricesCellule[i - 1][j - 1].getPresenceBombe() == true) {
                            cpt += 1;
                        }
                    }//Fin coin inférieur droit

                    //Fin pour les coins
                    else { //Pour le reste des cases
                        if (matricesCellule[i + 1][j].getPresenceBombe() == true) { //En bas
                            cpt += 1;
                        }
                        if (matricesCellule[i][j + 1].getPresenceBombe() == true) { //A droite
                            cpt += 1;
                        }
                        if (matricesCellule[i + 1][j + 1].getPresenceBombe() == true) { //En bas à droite
                            cpt += 1;
                        }
                        if (matricesCellule[i - 1][j].getPresenceBombe() == true) { //En  haut
                            cpt += 1;
                        }
                        if (matricesCellule[i][j - 1].getPresenceBombe() == true) { //A gauche
                            cpt += 1;
                        }
                        if (matricesCellule[i - 1][j - 1].getPresenceBombe() == true) { //En haut à gauche
                            cpt += 1;
                        }
                        if (matricesCellule[i-1][j+1].getPresenceBombe() == true){ //En haut à droite
                            cpt += 1 ;
                        }
                        if (matricesCellule[i+1][j-1].getPresenceBombe() == true){ //En bas à gauche
                            cpt += 1 ;
                        }
                    }//Pour les cellules qui ne sont pas sur les bordures
                     */

                    if (i >= 0 && i < nbLignes && j >= 0 && j < nbColonnes) {//Pour vérifier si on est bien dans la grille

                    }
                    matricesCellule[i][j].setNbBombesAdjacentes(cpt);
                    //Affecte le nombre de bombe adjacentes
                }
            }
        }
    }//Fin de la méthode calculerBombesAdjacentes

    public void revelerCellule(int ligne, int colonne) {
        if (matricesCellule[ligne][colonne].isDevoilee()) { //On vérifie si la case est déjà vérifiée
            return;
        }
        matricesCellule[ligne][colonne].revelerCellule(); //On révèle la cellule
        if (matricesCellule[ligne][colonne].getPresenceBombe()) {
            
            return; //Si il y une bombe on arrête
        }
        if (matricesCellule[ligne][colonne].getNbBombesAdjacentes() == 0) { //Si il n'y a pas de bombes autour
            for (int i = ligne - 1 ; i < ligne + 1 ; i++){
                for (int j = colonne - 1 ; j < colonne + 1 ; j++){
                    if (i == 0 && j == 0){
                        continue ;
                    }
                    int voisinX = ligne + i ;
                    int voisinY = colonne + j ;
                    if(voisinX >= 0 && voisinY >=0 && voisinX < nbLignes && voisinY < nbColonnes){
                        revelerCellule(voisinX , voisinY) ;
                    }
                }
            }
        }
    }//Fin méthode revelerCellule 

    public boolean getPresenceBombe(int i, int j) { //Getter pour savoir si il y a une bombe
        return matricesCellule[i][j].getPresenceBombe() ;
    }

    public boolean toutesCellulesRevelees() { //Méthode pour savoir si toutes les bombes sont révélées
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (!matricesCellule[i][j].isDevoilee()) {
                    return false;
                }
            }
        }//Fin des boucles
        return true ;
    }

    @Override
    public String toString() {
        for (int i = 0 ; i < matricesCellule.length ; i++){
            return matricesCellule[i][1].toString() ;
        }
        return "GrilleDeJeu{" + "matricesCellule=" + matricesCellule + '}';
    }
    
    

}
