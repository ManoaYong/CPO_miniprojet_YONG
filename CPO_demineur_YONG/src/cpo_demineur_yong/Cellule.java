/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpo_demineur_yong;

/**
 *
 * @author manoa
 */
public class Cellule {
    private boolean presenceBombe ;
    private boolean devoilee ;
    private int nbBombesAdjacentes ;
    
    public boolean getPresenceBombe(){
        
        return presenceBombe ;
    }
    
    public int getNbBombesAdjacentes(){
        return nbBombesAdjacentes ;
    }
    
    public  void placerBombe(){
        presenceBombe = true ;
    }
    
    public void revelerCellule(){
        devoilee = true ;
        
    }
    
    public int setNbBombesAdjacentes(int x){
        return x ;
    }

    @Override
    public String toString() {
        if (devoilee == false){
            return "?" ;
        }
        else{
            if (presenceBombe == true){
                return "B" ; 
            }
            else if(nbBombesAdjacentes > 0){
                return nbBombesAdjacentes +"" ;
            }
            else{
                return " " ;
            }
        //return "Cellule{" + "nbBombesAdjacentes=" + nbBombesAdjacentes + '}';
        }
    }
    
}
