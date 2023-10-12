/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author Alumno
 */
public class Ventana extends JFrame{
    static final int ANCHO=700, ALTO=700;

//______________________________________________________________________
    //menú principal:
    private Menu menu;
    private Inicio inicio;
    private Intento intento;
//______________________________________________________________________
    

//______________________________________________________________________    
    //Juego:
    private TableroJuego lamina;
    private Hilo hilo;
//______________________________________________________________________
    
    public Ventana(){
        setTitle("Pong");
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(null);
        setResizable(false);
        

//Diferentes maneras de poner un menú en el juego:
//      #1 
//        lamina = new TableroJuego();
//        add(lamina);
        
//      #2
//        inicio= new Inicio();
//        add(inicio);
        
//      #3
        menu = new Menu();
        add(menu);

//      #4
//        intento = new Intento();
//        add(intento);
       
    
        
        
        addKeyListener(new EventoTeclado());
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        hilo = new Hilo(lamina);
        hilo.start();
      //lamina.iterarJuego();
    }
}
