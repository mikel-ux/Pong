/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arkanoid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author saust
 */
public class Bloque {

    public static int getX() {
        return x;
    }

    public static void setX(int x) {
        Bloque.x = x;
    }

    public static int getY() {
        return y;
    }

    public static void setY(int y) {
        Bloque.y = y;
    }

    public static int getANCHO() {
        return ANCHO;
    }

    public static void setANCHO(int ANCHO) {
        Bloque.ANCHO = ANCHO;
    }

    public static int getALTO() {
        return ALTO;
    }

    public static void setALTO(int ALTO) {
        Bloque.ALTO = ALTO;
    }

    public static String getModo() {
        return modo;
    }

    public static void setModo(String modo) {
        Bloque.modo = modo;
    }

    public static boolean isAparecer() {
        return aparecer;
    }

    public static void setAparecer(boolean aparecer) {
        Bloque.aparecer = aparecer;
    }

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
    
    
    public static int x,y;
    public static int ANCHO=10, ALTO=50;
    public static String modo;
    public static boolean aparecer;
    public static Color color;    // Color del bloque
    public static boolean visible; // Indica si el bloque es visible o destruido
    
    public Bloque(int x, int y, int ancho, int alto, Color color, String juego) {
        this.x = x;
        this.y = y;
        this.ANCHO = ancho;
        this.ALTO = alto;
        this.color = color;
        this.visible = true;
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
    
}
