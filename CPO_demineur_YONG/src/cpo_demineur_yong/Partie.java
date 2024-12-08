/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpo_demineur_yong;

import java.util.Scanner;

/**
 *
 * @author manoa
 */
public class Partie {
    
    GrilleDeJeu board ;
    int nbVies = 1 ;
    Scanner sc = new Scanner(System.in);
    
    
    public void initialiserPartie(){
        board.placerBombesAleatoirement();
        
    } //Fin de la méthode initialiser Partie 
    
    public void TourDeJeu(int ligne , int colonne){
        board.matricesCellule[ligne][colonne].revelerCellule() ;
        if (board.matricesCellule[ligne][colonne].getPresenceBombe()){
            nbVies -= 1 ;
        }
    } //Fin méthode TourDeJeu 
    
    public void  verifierVictoire(){
        if ( board.toutesCellulesRevelees()){ //Vérification si toutes les cases ont été révélées 
            System.out.println("Vous avez gagné");
        }
    } //Fin méthode verifierVictoire
    
    public void demarrerPartie(){
        System.out.println("Quel mode voulez-vous ?") ;
        System.out.println("Faile , Moyen , Difficile") ;
    }
    
}
