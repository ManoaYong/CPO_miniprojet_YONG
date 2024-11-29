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
            for (int j = 0 ; j < nbColonnes ; j++){
                if (i == 0){
                    
                }
            }
        }
        
    }
    
}
