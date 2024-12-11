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
    private GrilleDeJeu board ;
    //GrilleDeJeu board = new GrilleDeJeu() ;
    int nbVies = 1 ;
    String Niveau ;
    Scanner sc = new Scanner(System.in);
    
    
    public void initialiserPartie(){
        board.placerBombesAleatoirement();
        
    } //Fin de la méthode initialiser Partie 
    
    public void TourDeJeu(int ligne , int colonne){
        board.matricesCellule[ligne][colonne].revelerCellule() ; //Il révèle la cellule de son choix
        if (board.matricesCellule[ligne][colonne].getPresenceBombe()){ 
            nbVies -= 1 ; //S'il révèle une bombe il perd une vie 
        }
    } //Fin méthode TourDeJeu 
    
    public boolean  verifierVictoire(){
        if ( board.toutesCellulesRevelees()){ //Vérification si toutes les cases ont été révélées 
            System.out.println("Vous avez gagné");
            return  true ;
        }
        return false ;
    } //Fin méthode verifierVictoire
    
   
    public void demarrerPartie(){
        System.out.println("Quel mode voulez-vous ?") ;
        System.out.println("Facile , Moyen , Difficile") ;
        Niveau = sc.nextLine() ; //Le joueur rentre le niveau voulu
        if (Niveau == "Facile" || Niveau == "facile"){
            nbVies = 5 ;
            board.setNbLignes(6) ;
            board.setNbColonnes(6);
            board.setNbBombes(12);
            board.matricesCellule = new Cellule[6][6] ;
        }
        if (Niveau == "Moyen" || Niveau == "moyen"){
            nbVies = 3 ;
            board.setNbLignes(10) ;
            board.setNbColonnes(10);
            board.setNbBombes(50);
            board.matricesCellule = new Cellule[10][10] ;
        }
        else{
            nbVies  = 1 ;
            board.setNbLignes(15) ;
            board.setNbColonnes(15);
            board.setNbBombes(125);
            board.matricesCellule= new Cellule[15][15] ;
        }
        
        initialiserPartie() ; //On initialise le boardgame
        while (nbVies > 0){ //Boucle de jeu
            if (verifierVictoire()){
                 break ;
            }
            else{
                   System.out.println("Quelle case souhaitez-vous dévoiler ?");
                   System.out.println("Ligne : ? Colonne : ?");
                   TourDeJeu(sc.nextInt(), sc.nextInt()) ; //Le joueur joue
                   
            }
        } //Fin du while
        
    } //Fin de la méthode demarrerPartie
    
} //Fin de la classe Partie
