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
public class Hilo extends Thread{
    TableroJuego lamina;
    
    public Hilo(TableroJuego lamina){
        this.lamina=lamina;
    }
    
    @Override
    public void run(){
        while(!Pelota.finJuego){
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
            lamina.repaint();
        }
    }
}
