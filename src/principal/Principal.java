/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import clases.Ventana;
import javax.swing.JFrame;

/**
 *
 * @author saust
 */
public class Principal {
    static String juego;
    static String modo;
    
    public Principal(String juego, String modo){
        this.juego=juego;
        this.modo=modo;
        main(new String[]{});
    }
    
    public static void main(String[] args) {
        Ventana ventana = new Ventana(juego,modo);        
    }
    
}
