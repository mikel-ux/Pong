/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Graphics;
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

    /*    
//Obtiene el Toolkit del sistema
        Toolkit toolkit = Toolkit.getDefaultToolkit();

//Obtiene la dimensión de la pantalla
        Dimension screenSize = toolkit.getScreenSize();

// Obtiene el ancho y alto de la pantalla
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
     */

    static int ANCHO = 1000, ALTO = 700;

    private TableroJuego lamina;
    private Hilo hilo;

    public Ventana() {        
        lamina = new TableroJuego();        
    }

    /*    public Ventana(){        
        //Esta línea sirve para colocar una Imagen de Fondo
        //this.setContentPane(new Ventana.ImagenFondo());
        
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
    }*/
    //Clase opcional
    /*public class ImagenFondo extends JPanel{
        public void paint(Graphics g){
            ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/ciudadNeon1.png"));
            g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }*/
    // Clase opcional
    public class ImagenFondo extends JPanel {

        public ImagenFondo() {
            setOpaque(false); // Establece el JPanel como transparente
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/ciudadNeon1.png"));
            g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    

}
