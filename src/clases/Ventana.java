/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import arkanoid.Nivel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author saust
 */
public class Ventana extends JFrame {

        
//Obtiene el Toolkit del sistema
        static Toolkit toolkit = Toolkit.getDefaultToolkit();

//Obtiene la dimensión de la pantalla
        static Dimension screenSize = toolkit.getScreenSize();

// Obtiene el ancho y alto de la pantalla
        static int screenWidth = (int) screenSize.getWidth();
        static int screenHeight = (int) screenSize.getHeight();
        static int ANCHO = screenWidth, ALTO = screenHeight; 
//Antiguos valores para el ANCHO y el ALTO de nuestro JFRAME:
//    static int ANCHO = 1000, ALTO = 700;

    private TableroJuego lamina;
    private Hilo hilo;
    private Nivel nivelPrimigenio;
    
    static String juego;
    static String modo;
    
    public Ventana(String juego, String modo){        
        
        this.juego=juego;
        this.modo=modo;
        
        setTitle(juego +" - "+modo);
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(null);
        setResizable(false);                        
        
        lamina = new TableroJuego(juego, modo, 5, 5, nivelPrimigenio);
        add(lamina);
        addKeyListener(new EventoTeclado());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hilo = new Hilo(lamina, nivelPrimigenio);        
        hilo.start();                
    }
}
