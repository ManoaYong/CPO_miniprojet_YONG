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
    
    Random r = new Random() ;
    
    Cellule[][] matricesCellule ; //Tableau contenant les cellules
    private int nbLignes ; //Nombre de ligne dans la grille 
    private int nbColonnes ; //Nombre de colonne dans la grille
    private int nbBombes ; //Nombre total de bombes placées dans la grille

    public int getNbLines() { //accesseur 
        return nbLignes;
    }

    public int getNbColonnes() { //accesseur
        return nbColonnes;
    }

    public int getNbBombes() { //accesseur
        return nbBombes;
    }
    
    public void placerBombesAleatoirement(){
        int i = 0 ;
        while(i < nbBombes){
            int x = r.nextInt(nbLignes) - 1 ;
            int y = r.nextInt(nbColonnes) - 1 ;
            if (matricesCellule[x][y].getPresenceBombe() == false ){
                matricesCellule[x][y].placerBombe() ;
                i++ ; //Incrémente le nombre de bombe placées
            }
            else{
            }
        }
    }
    
    public void calculerBombesAdjacentes(){
        for (int i = 0 ; i < nbLignes ; i++){
            for (int j = 0 ; j < nbColonnes ; j++){ //double boucle pour parcourir le tableau
                int cpt = 0 ; //Compteur de bombes adjacentes qui va s'incrémenter
                if (matricesCellule[i][j].getPresenceBombe() == false){
                    
                    if (i == 0 &&  j == 0){ //Coin supérieur gauche
                        if(matricesCellule[i+1][j].getPresenceBombe() == true){
                            cpt += 1 ;
                        }
                        if (matricesCellule[i][j+1].getPresenceBombe() == true){
                            cpt += 1 ;
                        }
                        if (matricesCellule[i+1][j+1].getPresenceBombe() == true){
                            cpt += 1 ;
                        }
                    }
                    
                    if (i == 0 && j == nbColonnes - 1){ //Coin supérieur droit
                        if (matricesCellule[i+1][j].getPresenceBombe() == true){
                            cpt += 1 ;
                        }
                        if (matricesCellule[i][j-1].getPresenceBombe() == true){
                            cpt += 1 ;
                        }
                        if (matricesCellule[i+1][j-1].getPresenceBombe() == true){
                            cpt += 1 ;
                        }
                    }
                    
                    if (i == nbLignes - 1 && j == 0){ //Coin inférieur gauche
                        if (matricesCellule[i-1][j].getPresenceBombe() == true){
                            cpt += 1 ;
                        }
                        if (matricesCellule[i][j+1].getPresenceBombe() == true){
                            cpt += 1 ;
                        }
                        if (matricesCellule[i-1][j+1].getPresenceBombe() == true){
                            cpt += 1 ;
                        }
                    }
                    
                    if (i == nbLignes - 1 && j == nbColonnes - 1 ){ //Coin inférieur droit
                        if (matricesCellule[i-1][j].getPresenceBombe() == true){
                            cpt += 1 ;
                        }
                        if (matricesCellule[i][j-1].getPresenceBombe() == true){
                            cpt += 1 ;
                        }
                        if (matricesCellule[i-1][j-1].getPresenceBombe() == true){
                            cpt += 1 ;
                        }
                    }//Fin pour les coins
                    
                }   
            }
        }
        
    }
    
}
