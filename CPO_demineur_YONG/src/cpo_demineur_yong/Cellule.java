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
    private boolean presenceBombe ; //booléen pour savoir s'il y a une bombe sur la case
    private boolean devoilee ; //Si la cellule est dévoilée ou non 
    private int nbBombesAdjacentes ; //Le nombre de bombes adjacentes
    
    public boolean getPresenceBombe(){
        
        return presenceBombe ;
    }
    
    public int getNbBombesAdjacentes(){
        return nbBombesAdjacentes ;
    }
    
    public  void placerBombe(){
        presenceBombe = true ;
    }

    public boolean isDevoilee() {
        return devoilee;
    }
    
    public void revelerCellule(){
        devoilee = true ;
        
    }
    
    
    public void setNbBombesAdjacentes(int x){
        nbBombesAdjacentes= x ;
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
