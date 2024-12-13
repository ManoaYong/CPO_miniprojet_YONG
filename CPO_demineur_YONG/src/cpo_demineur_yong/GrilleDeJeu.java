/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpo_demineur_yong;

import java.util.ArrayList;
import java.util.Arrays;
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

    public int getNbLines() { //accesseur pour le nombre de lignes
        return nbLignes;
    }

    public int getNbColonnes() { //accesseur pour le nombre de colonnes
        return nbColonnes;
    }

    public int getNbBombes() { //accesseur pour le nombre de bombes totales
        return nbBombes;
    }

    public void setNbLignes(int nbLignes) { //Setter pour le nombre de lignes
        this.nbLignes = nbLignes;
    }

    public void setNbColonnes(int nbColonnes) { //Setter pour le nopmbre de colonnes
        this.nbColonnes = nbColonnes;
    }

    public void setNbBombes(int nbBombes) { //Setter pour le nombre de bombes totales
        this.nbBombes = nbBombes;
    }

    public void placerBombesAleatoirement() {
        int i = 0;
        while (i < nbBombes) {
            int x = r.nextInt(nbLignes - 1) ;
            int y = r.nextInt(nbColonnes - 1) ;
            if (matricesCellule[x][y].getPresenceBombe() == false) {
                matricesCellule[x][y].placerBombe();
                i++; //Incrémente le nombre de bombe placées
            } else {
            }
        }
    }

    public void calculerBombesAdjacentes() { //Méthode de calculedes bombes adjacentes
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
                    if (i >= 0 && i < nbLignes && j - 1 >= 0 && j - 1 < nbColonnes && matricesCellule[i][j - 1].getPresenceBombe() == true) {
                        cpt++; //A gauche
                    }
                    if ( i + 1 < nbLignes && j + 1 < nbColonnes && matricesCellule[i + 1][j + 1].getPresenceBombe() == true) {
                        cpt++; //En bas à droite
                    }
                    if ( i + 1 < nbLignes && j - 1 >= 0 && matricesCellule[i + 1][j - 1].getPresenceBombe() == true) {
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

                    //if (i >= 0 && i < nbLignes && j >= 0 && j < nbColonnes) {//Pour vérifier si on est bien dans la grille

                    //}
                    matricesCellule[i][j].setNbBombesAdjacentes(cpt);
                    //Affecte le nombre de bombe adjacentes
                }
            }
        }
    }//Fin de la méthode calculerBombesAdjacentes
    

    /*public void revelerCellule(int ligne, int colonne) {
        if (matricesCellule[ligne - 1][colonne - 1].isDevoilee()) { //On vérifie si la case est déjà vérifiée
            return;
        }
        matricesCellule[ligne - 1][colonne - 1].revelerCellule(); //On révèle la cellule
        if (matricesCellule[ligne - 1][colonne - 1].getPresenceBombe()) {
            
            return; //Si il y une bombe on arrête
        }
        if (matricesCellule[ligne - 1][colonne - 1].getNbBombesAdjacentes() == 0) { //Si il n'y a pas de bombes autour
            for (int i = - 1 ; i <= 1  ; i++){
                for (int j = - 1 ; j <= 1  ; j++){
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
    }//Fin de la méthode revelerCellule  
    */
    
    public void revelerCellule(int ligne, int colonne) {
        // 1️⃣ Vérification des bornes de la grille (éviter l'IndexOutOfBoundsException)
        if (ligne - 1 < 0 || ligne - 1 >= nbLignes || colonne - 1 < 0 || colonne - 1 >= nbColonnes || matricesCellule[ligne][colonne].isDevoilee() == true) {
            return ;
        }
        matricesCellule[ligne ][colonne ].revelerCellule() ;

        if (matricesCellule[ligne ][colonne ].getPresenceBombe() || matricesCellule[ligne ][colonne ].getNbBombesAdjacentes() > 0) {
            return ;
        }

        for (int i = -1 ; i <= 1 ; i++) {
            for (int j = -1 ; j <= 1 ; j++) {
                if (i == 0 && j == 0) {
                    continue ;
                }
                revelerCellule(ligne  + i, colonne  + j);
            }
        } //Fin de la double boucle
    } //Fin de la méthode revelerCellule 
    

    public boolean getPresenceBombe(int i, int j) { //Getter pour savoir si il y a une bombe
        return matricesCellule[i][j].getPresenceBombe() ;
    }

    public boolean toutesCellulesRevelees() { //Méthode pour savoir si toutes les bombes sont révélées
        int cpt = 0 ;
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (matricesCellule[i][j].isDevoilee()) {
                    cpt += 1;
                }
            }
        }//Fin des boucles
        if (cpt == matricesCellule.length * matricesCellule.length - nbBombes){
            return true ;
        }
        else {
            return false ;
        }
    } //Fin de la méthode toutesCellulesRevelees   

    @Override
    public String toString() {
        
        String tmp = "" ;
        for (int i = 0 ; i < matricesCellule.length ; i ++){
            if ( i != 0 ){
                tmp += "\n" ;
            }
            for (int j = 0 ; j < matricesCellule.length ; j++){
                tmp += matricesCellule[i][j] ;
            }
        }//Fin de la double boucle
        return tmp ;
        
    
    } //Fin de la méthode toString
 public String triche() {
        
        String tmp = "" ;
        for (int i = 0 ; i < matricesCellule.length ; i ++){
            if ( i != 0 ){
                tmp += "\n" ;
            }
            for (int j = 0 ; j < matricesCellule.length ; j++){
                tmp += matricesCellule[i][j].triche() ;
            }
        }//Fin de la double boucle
        return tmp ;
        
    
    }
} //Fin de la classe GrilleDeJeu  

