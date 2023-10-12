/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.awt.event.*;
/**
 *
 * @author saust
 */
public class EventoTeclado extends KeyAdapter{
    
    static boolean w,s,up,down;
    static boolean a,d,left,right;
    
    @Override
    public void keyPressed(KeyEvent e){
        int id = e.getExtendedKeyCode();

        if(id == KeyEvent.VK_LEFT){
            left=true;
        }
        if(id == KeyEvent.VK_RIGHT){
            right=true;
        }
          
        if(id == KeyEvent.VK_A){
            a=true;
        }
        if(id == KeyEvent.VK_D){
            d=true;
        }         
    }
    
    //Se suelta la tecla
    @Override
    public void keyReleased(KeyEvent e){
        int id = e.getKeyCode();
        
        if(id == KeyEvent.VK_LEFT){
            left=false;
        }
        if(id == KeyEvent.VK_RIGHT){
            right=false;
        }
          
        if(id == KeyEvent.VK_A){
            a=false;
        }
        if(id == KeyEvent.VK_D){
            d=false;
        }   
        
    }
    
}
