/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saust
 */
//Clase Thread = sirve para aplicaciones multitareas
public class Hilo extends Thread{
    TableroJuego lamina;
    public Hilo(TableroJuego lamina){
        this.lamina = lamina;
    }
    
    @Override
    public void run(){
        while(!Pelota.finJuego){
            
            lamina.repaint();
            
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }            
        }
    }
}
