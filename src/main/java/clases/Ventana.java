/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import javax.swing.JFrame;

/**
 *
 * @author Alumno
 */
public class Ventana extends JFrame{
    static final int ANCHO=650, ALTO=700;
    
    private TableroJuego lamina;
    private Hilo hilo;
    
    public Ventana(){
        setTitle("Pong");
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(null);
        setResizable(false);
        lamina = new TableroJuego();
        add(lamina);
        
        addKeyListener(new EventoTeclado());
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        hilo = new Hilo(lamina);
        hilo.start();
    //  lamina.iterarJuego();
    }
}
