/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.applet.AudioClip;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import obtenerRecursos.Audio;

/**
 *
 * @author Alumno
 */
public class Pelota {
    private int x;
    private int y;
    private int dx=1, dy=1;
    private final int ANCHO=15, ALTO=15;
    
    private Integer puntaje1=0, puntaje2=0;
    private int vidas1=5;
    public static boolean finJuego=false;
//    Audio audio = new Audio();
//    AudioClip rebote_1 = audio.getAudio("recursos/ping.wav");
//    AudioClip rebote_2 = audio.getAudio("recursos/pong.wav");
//    AudioClip falta = audio.getAudio("recursos/impacto8bit.wav");
    
    public Pelota(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    public Rectangle2D getPelota(){
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
    }
    
    public void mover(Rectangle limites, boolean colisionR1, boolean colisionR2){
        x+=dx;
        y+=dy;
//____________________________________________________________
//____________________________________________________________
        //Rebotes contra las raquetas
        if(colisionR1){
            dy = -dy;
            y=(Ventana.ALTO-Raqueta.ALTO-70);
            puntaje1++;
            
        }
        if(colisionR2){
            dy = -dy;
            //x=Ventana.ANCHO-Raqueta.ANCHO-52;
        }
//____________________________________________________________
//____________________________________________________________
        //Rebotes contra las paredes
        if(x>(limites.getMaxX()-ANCHO)){
            dx = -dx;
            //rebote_2.play();
        }
        if(x<0){
            dx = -dx;
            //rebote_2.play();
        }
//____________________________________________________________
//____________________________________________________________
        //Rebotes contra el piso y el techo
//        if(y>(limites.getMaxY()-ALTO)){
//            dy = -dy;
//        }
        if(y<0){
            //x = (int) limites.getMinX();
            dy = -dy;
            //rebote_2.play();  
        }
        
        //Para cuando la pelota salga del mapa:
        Random random = new Random();
        //double numero = random.nextInt((int)limites.getMaxX());
        if(y>limites.getMaxY()+1){
            vidas1--;
            
            try {
                Thread.sleep(340);
            } catch (InterruptedException ex) {
                System.out.print(ex);
            }
            x=random.nextInt((int)limites.getMaxX());
            y=0;
            //falta.play();
        }
//____________________________________________________________
//____________________________________________________________       
    }
    
    public int getVidas1(){
        return vidas1;
    }
    
    public int getScore1(){
        return puntaje1;
    }
    
    public int getScore2(){
        return puntaje2;
    }
}
