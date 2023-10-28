/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import arkanoid.Bloque;
import arkanoid.Nivel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import clases.Ventana;
import clases.Raqueta;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author saust
 */
public class TableroJuego extends JPanel {
    
    Pelota pelota = new Pelota(0, 0);        
    
    static int XposicionRaqueta1 = 16;
    static int YposicionRaqueta1 = (Ventana.ALTO / 2) - (Raqueta.ALTO / 2);
    Raqueta r1 = new Raqueta(XposicionRaqueta1, YposicionRaqueta1);
    //Ventana.ANCHO es 1000, pero el ancho final del JFrame termina siendo 984.
    //por lo que restamos 16 ---> (Ventana.ANCHO-16) = (1000-16) = 984
    //si la raqueta nace desde la cordenada X en 984, no sería visible, pues estaría justo al límite derecho del JFrame
    //para que sea visible le restamos el ancho de la raqueta que es 10, por eso se resta el 10.
    //Y finalmente, para que tenga una distancia de 10 pixeles con el JFrame, se le vuelve a restar 10. 
    static int XposicionRaqueta2 = (Ventana.ANCHO - 16 - Raqueta.ANCHO - 10);
    static int YposicionRaqueta2 = (Ventana.ALTO / 2) - (Raqueta.ALTO / 2);    
    Raqueta r2 = new Raqueta(XposicionRaqueta2, YposicionRaqueta2);

    static String juego;
    static String modo;

    //ARRAY de OBJETOS:
    //NOMBRE CLASE + NOMBRE ASIGNADO [] = new + NOMBRE CLASE + [DIMENSION];            
    private Bloque[] bloques; //clase bloques        
    int bloquesRotos=0;
    int cantidadBloques = Ventana.ALTO/50;
    
    //pantalla
    private int width = 800;
    private int height = 600;     
    
    
    Nivel nivelPrimigenio;
    
    public TableroJuego(String juego, String modo, int filas, int columnas, Nivel nivelPrimigenio) {
        this.juego = juego;
        this.modo = modo;
        this.nivelPrimigenio = nivelPrimigenio;
        //esto define el color de fondo sin imagen
        setBackground(new Color(0, 0, 0, 128));        
        //configuracion de bloques
                
        bloques = new Bloque[cantidadBloques];
        int xInicial = (int)((int)Ventana.ANCHO/1.15); // Posición inicial en el eje X        
        int yInicial = 10; // Posición inicial en el eje Y
        int separacionX = 60; // Separación horizontal entre bloques
        int separacionY = 60;
        for (int i = 0; i < bloques.length; i++) {
            bloques[i] = new Bloque(xInicial, yInicial + i * separacionY, 20, 50, Color.RED, juego);
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(0, 0, 0, 120));
        Dimension tamanio = getSize();
        ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/opciones_fondo2.png"));
        g.drawImage(fondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
        
        setOpaque(false);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);

        if (juego.equals("arkanoid")) {
        //Dibujar bloques
            dibujarBloques(g2);
            verificarColisionesConBloques();
            if(hayCeroBloques()){
                nivelPrimigenio.aumentarNivel();
                //JOptionPane.showMessageDialog(this, nivelPrimigenio.getNumeroNivel());
            }
            
        }

        //chocanLadrillos(g2, bloques);
        dibujarPuntaje(g2);
        dibujar(g2);

        actualizar();
    }

    public void dibujar(Graphics2D g) {
        g.fill(pelota.getPelota());
        g.fill(r1.getRaqueta());
        if (modo.equals("pvp") || modo.equals("pve")) {
            g.fill(r2.getRaqueta());
        }

        if (juego.equals("arkanoid")) {
            
        }

    }

    public void dibujarBloques(Graphics2D g) {
        for (Bloque bloque : bloques) {
            if (bloque.visible) {
                g.setColor(Color.WHITE);
                g.fillRect(bloque.x, bloque.y, bloque.ANCHO, bloque.ALTO);
            }
        }
    }
    
    public boolean hayCeroBloques(){
        for (Bloque bloque : bloques) {
            if (!bloque.visible) {
                bloquesRotos++;
                
                if(bloquesRotos==cantidadBloques){                    
                    return true;
                }
                
            }
        }
        return false;
    }

    public void actualizar() {
        //PONG:  -->  
        if (modo.equals("pvp") || modo.equals("pve")) {
            /*MODO DOS JUGADORES*/
            pelota.mover(getBounds(), colision(r1.getRaqueta()), colision(r2.getRaqueta()), false);
            r2.moverR2(getBounds());
        } else {
            /*MODO UN SOLO JUGADOR --> una sola RAQUETA*/
            pelota.mover(getBounds(), colision(r1.getRaqueta()), false, false);
        }

        //ARKANOID:
        if (juego.equals("arkanoid") && modo.equals("normal")) {
            pelota.mover(getBounds(), colision(r1.getRaqueta()), colision(r2.getRaqueta()), verificarColisionesConBloques());

        }
        r1.moverR1(getBounds());
    }

    private boolean colision(Rectangle2D r) {
        return pelota.getPelota().intersects(r);
    }

    public boolean verificarColisionesConBloques() {
        for (Bloque bloque : bloques) {
            if (bloque.visible && colisionBloque(bloque.getBloque())) {
                bloque.destruir();
                bloque.visible=false;
                return true;
            }
        }
        return false;
    }

    private boolean colisionBloque(Rectangle2D bloque) {
        return pelota.getPelota().intersects(bloque);
    }

    private void dibujarPuntaje(Graphics2D g) {

        Graphics2D g1 = g, g2 = g, vidas = g;

        Font puntaje = new Font("Arial", Font.BOLD, 30);
        g.setFont(puntaje);

        g1.drawString("Puntos: " + Integer.toString(pelota.getScore1()), (float) getBounds().getCenterX() + 100, 30);
        //g2.drawString(Integer.toString(pelota.getScore2()), (float)getBounds().getCenterX() + 25, 30);        
        vidas.drawString("Vidas: " + Integer.toString(pelota.getVidas1()), (float) getBounds().getCenterX() - 200, 30);
        if (pelota.vidas1 == 0) {
            g.drawString("PERDISTE", (float) getBounds().getCenterX() - 65, (float) getBounds().getCenterY() - 65);
            Pelota.finJuego = true;
        }
    }

    //Clase opcional
    public class ImagenFondo extends JPanel {

        public void paint(Graphics g) {
            //esto es opcional            
            ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/ciudadNeon1.png"));
            g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
