/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cpo_demineur_yong;

/**
 *
 * @author manoa
 */
public class CPO_demineur_YONG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Cellule wouaf = new Cellule() ;
        wouaf.revelerCellule() ;
        wouaf.placerBombe() ;
        System.out.println(wouaf);
        
        Cellule coq ;
        coq = new Cellule() ;
        
        GrilleDeJeu grille ;
        grille = new GrilleDeJeu() ;
        grille.matricesCellule[0][0] = wouaf ;
        
        
        System.out.println("yyhygvuhbyuhj");
        System.out.println(grille);
        //System.out.println(grille.toString()) ;
        
    }
    
}
