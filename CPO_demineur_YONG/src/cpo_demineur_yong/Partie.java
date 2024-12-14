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
    private GrilleDeJeu board  = new GrilleDeJeu() ;
    int nbVies = 1 ;
    String Niveau ;
    Scanner sc = new Scanner(System.in);
    
    
    public void initialiserPartie(){
        board.placerBombesAleatoirement();
        board.calculerBombesAdjacentes();
        
    } //Fin de la méthode initialiser Partie 
    
    public void TourDeJeu(int ligne , int colonne){
        //board.matricesCellule[ligne][colonne].revelerCellule() ; //Il révèle la cellule de son choix
        board.revelerCellule(ligne, colonne); 
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
        if ("Facile".equals(Niveau) || "facile".equals(Niveau)){
            nbVies = 1 ;
            board.setNbLignes(6) ;
            board.setNbColonnes(6);
            board.setNbBombes(5);
            board.matricesCellule = new Cellule[6][6] ; //Initialisation de la mémoire 
            for (int i = 0 ; i < 6 ; i++){
                for (int j = 0 ; j < 6 ; j++){
                    board.matricesCellule[i][j] = new Cellule() ;
                }
            } //Fin de la double boucle
        }
        else if ("Moyen".equals(Niveau) || "moyen".equals(Niveau)){
            nbVies = 1 ;
            board.setNbLignes(10) ;
            board.setNbColonnes(10);
            board.setNbBombes(10);
            board.matricesCellule = new Cellule[10][10] ;
            for (int i = 0 ; i < 10 ; i++){
                for (int j = 0 ; j < 10 ; j++){
                    board.matricesCellule[i][j] = new Cellule() ;
                }
            } //Fin de la double boucle
        }
        else{
            nbVies  = 1 ;
            board.setNbLignes(15) ;
            board.setNbColonnes(15);
            board.setNbBombes(30);
            board.matricesCellule= new Cellule[15][15] ;
            for (int i = 0 ; i < 15 ; i++){
                for (int j = 0 ; j < 15 ; j++){
                    board.matricesCellule[i][j] = new Cellule() ;
                }
            } //Fin de la double boucle
        }
        
        initialiserPartie() ; //On initialise le boardgame
        while (nbVies > 0){ //Boucle de jeu
            if ( nbVies == 1){
                System.out.println("Plus qu'une vie") ;
            }
            if (verifierVictoire()){
                System.out.println("Vous avez gagne") ;
                 break ;
            }
            else{
                   System.out.println("Quelle case souhaitez-vous devoiler ?");
                   //System.out.println("123456789") ;
                   System.out.println(board);
                   System.out.println(" la triche :::::");
                   System.out.println(board.triche());
                   
                   System.out.println("Ligne : ? Colonne : ?");
                   TourDeJeu(sc.nextInt() - 1 , sc.nextInt() - 1) ; //Le joueur joue
                   System.out.println("New turn") ;
                   
            }
        } //Fin du while
        if (!verifierVictoire()){
            System.out.println("Vous avez perdu ");
        }
        
    } //Fin de la méthode demarrerPartie
    
} //Fin de la classe Partie

