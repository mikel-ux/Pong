/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arkanoid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author saust
 */
public class Bloque {   

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
    public int x,y;
    public int ANCHO=10, ALTO=50;
    public String modo;
    public boolean aparecer;
    public Color color;    // Color del bloque
    public boolean visible=true; // Indica si el bloque es visible o destruido
    
    public Bloque(int x, int y, int ancho, int alto, Color color, String juego) {
        this.x = x;
        this.y = y;
        this.ANCHO = ancho;
        this.ALTO = alto;
        this.color = color;
    }

    public Rectangle2D getBloque(){      
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
    }
    
    public void dibujar(Graphics g, int index) {
        if (visible) {
            g.setColor(color);
            g.fillRect(x, y, ANCHO, ALTO);            
        }
    }
    
    public void choque(boolean colisionBloque){        
        if(colisionBloque){
            this.destruir();
        }
        
    }
    
    
    public void destruir() {
        this.visible = false;
    }

    public boolean getVisible() {
        return this.visible;
    }   
    
    
    public boolean colisionBloque(boolean colisionBloque){
        
        if(colisionBloque){
            this.setVisible(false);
            return false;
        }
        return true;
    }
    
}
