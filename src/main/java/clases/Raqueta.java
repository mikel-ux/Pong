/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author saust
 */
public class Raqueta {
    int gameMode = 1;
    private int x,y;
    static int ANCHO=50, ALTO=14;    
    
    public Raqueta(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    public Rectangle2D getRaqueta(){
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
    }
    
    public void moverR1(Rectangle limites){
        
        if(gameMode==1){
            if(EventoTeclado.left && x>limites.getMinX()){
                x--;
            }
            if(EventoTeclado.right && x<(limites.getMaxX()-Raqueta.ANCHO)){
                x++;
            }
            
            
            if(EventoTeclado.a && x>limites.getMinX()){
                x--;
            }
            if(EventoTeclado.d && x<(limites.getMaxX()-Raqueta.ANCHO)){
                x++;
            }
        }

        
        
        
        
    }
}
