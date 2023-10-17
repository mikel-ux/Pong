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
    private int x, y;
    static int ANCHO=10, ALTO=50;
    
    public Raqueta(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    public Rectangle2D getRaqueta(){
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
    }
    
    public void moverR1(Rectangle limites){
        if(EventoTeclado.w == true && y>limites.getMinY()){
            y--;
        }
        if(EventoTeclado.s == true && y<limites.getMaxY()-this.ALTO){
            y++;
        }
        
        /*if(EventoTeclado.up == true){
            y--;
        }
        if(EventoTeclado.down == true){
            y++;
        }*/
    }
    
    public void moverR2(Rectangle limites){        
        if(EventoTeclado.up == true && y>limites.getMinY()){
            y--;
        }
        if(EventoTeclado.down == true && y<limites.getMaxY()-this.ALTO){
            y++;
        }
    }
}
