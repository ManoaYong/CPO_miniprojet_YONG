/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpo_demineur_yong;

/**
 *
 * @author manoa
 */
public class GrilleDeJeu {
    
    Cellule[][] matricesCellule ;
    private int nbLignes ; //Nombre de ligne dans la grille 
    private int nbColonnes ; //Nombre de colonne dans la grille
    private int nbBombes ; //Nombre total de bombes placées dans la grille

    public int getNbLines() {
        return nbLignes;
    }

    public int getNbColonnes() {
        return nbColonnes;
    }

    public int getNbBombes() {
        return nbBombes;
    }
    
    
}
