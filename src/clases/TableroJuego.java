/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

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
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.JFrame;
import org.netbeans.lib.awtextra.AbsoluteLayout;
/**
 *
 * @author saust
 */

public class TableroJuego extends JFrame{
    static int ANCHO=1000, ALTO=700;
    
    Pelota pelota = new Pelota(0,0);
    private Hilo hilo;
    
    static int XposicionRaqueta1 = 10;
    static int YposicionRaqueta1 = (ALTO/2)-(Raqueta.ALTO/2);
    Raqueta r1 = new Raqueta(XposicionRaqueta1, YposicionRaqueta1);
    
    //Ventana.ANCHO es 1000, pero el ancho final del JFrame termina siendo 984.
    //por lo que restamos 16 ---> (Ventana.ANCHO-16) = (1000-16) = 984
    //si la raqueta nace desde la cordenada X en 984, no sería visible, pues estaría justo al límite derecho del JFrame
    //para que sea visible le restamos el ancho de la raqueta que es 10, por eso se resta el 10.
    //Y finalmente, para que tenga una distancia de 10 pixeles con el JFrame, se le vuelve a restar 10. 
    static int XposicionRaqueta2 = (ANCHO-16-Raqueta.ANCHO-10);
    static int YposicionRaqueta2 = (ALTO/2)-(Raqueta.ALTO/2);
    //TEMPORALMENTE COMENTADO
    //Raqueta r2 = new Raqueta( XposicionRaqueta2, YposicionRaqueta2);
    
    
    public TableroJuego(){
        setTitle("Pong");
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(null);
        setResizable(false);
        addKeyListener(new EventoTeclado());
        setVisible(true);
        //Esta línea sirve para colocar una Imagen de Fondo
        this.add(new ImagenFondo());
        //
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hilo = new Hilo(this);
        hilo.start();                
    }
    
    
    
    public void dibujar(Graphics2D g){
        g.fill(pelota.getPelota());  
        g.fill(r1.getRaqueta());
        //g.fill(r2.getRaqueta());
    }
    public void actualizar(){
        Rectangle limites = new Rectangle(0, 0, 1000, 700);
        //MODO DOS JUGADORES -->  pelota.mover(getBounds(), colision(r1.getRaqueta()), colision(r2.getRaqueta()) );
        pelota.mover( limites, colision(r1.getRaqueta()), false );
        r1.moverR1(getBounds());        
        
        //el método "getBound()" devuelve esto: [x=183,y=10,width=1000,height=700]
        
        //r2.moverR2(getBounds());
    }
    
    private boolean colision(Rectangle2D r){
        return pelota.getPelota().intersects(r);        
    }
    
    private void dibujarPuntaje(Graphics2D g){
        
        Graphics2D g1=g, g2=g, vidas=g;
        
        Font puntaje = new Font("Arial", Font.BOLD, 30);
        g.setFont(puntaje);
        
        g1.drawString("Puntos: "+Integer.toString(pelota.getScore1()), (float)getBounds().getCenterX() + 100, 30);
        //g2.drawString(Integer.toString(pelota.getScore2()), (float)getBounds().getCenterX() + 25, 30);
        vidas.drawString("Vidas: "+Integer.toString(pelota.getVidas1()), (float)getBounds().getCenterX()-100, 30);
        if(pelota.vidas1==0){
            g.drawString("PERDISTE", (float)getBounds().getCenterX(), (float)getBounds().getCenterY());
            Pelota.finJuego=true;
        }
    }
    
    
    
    //Clase opcional
    public class ImagenFondo extends JPanel{
        public void paint(Graphics g){            
            //esto es opcional            
            ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/ciudadNeon1.png"));
            g.drawImage(fondo.getImage(), 0, 0, ANCHO, ALTO, this);                        
            setOpaque(false);
            super.paint(g);
        }
        
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            g2.setColor(Color.black);
            dibujarPuntaje(g2);
            dibujar(g2);
            actualizar();
        }
    }
}

/*public class TableroJuego extends JPanel{
    Pelota pelota = new Pelota(0,0);
    
    
    static int XposicionRaqueta1 = 10;
    static int YposicionRaqueta1 = (Ventana.ALTO/2)-(Raqueta.ALTO/2);
    Raqueta r1 = new Raqueta(XposicionRaqueta1, YposicionRaqueta1);
    
    //Ventana.ANCHO es 1000, pero el ancho final del JFrame termina siendo 984.
    //por lo que restamos 16 ---> (Ventana.ANCHO-16) = (1000-16) = 984
    //si la raqueta nace desde la cordenada X en 984, no sería visible, pues estaría justo al límite derecho del JFrame
    //para que sea visible le restamos el ancho de la raqueta que es 10, por eso se resta el 10.
    //Y finalmente, para que tenga una distancia de 10 pixeles con el JFrame, se le vuelve a restar 10. 
    static int XposicionRaqueta2 = (Ventana.ANCHO-16-Raqueta.ANCHO-10);
    static int YposicionRaqueta2 = (Ventana.ALTO/2)-(Raqueta.ALTO/2);
    //TEMPORALMENTE COMENTADO
    //Raqueta r2 = new Raqueta( XposicionRaqueta2, YposicionRaqueta2);
    
    
    public TableroJuego(){
        //esto es opcional
        //setLayout(null);
        
        //Esta línea sirve para colocar una Imagen de Fondo
        this.add(new ImagenFondo());
        
        //this.setOpaque(false);
        
        //esto define el color de fondo sin imagen
        setBackground(Color.black);                
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        dibujarPuntaje(g2);
        dibujar(g2);
        actualizar();
    }
    
    public void dibujar(Graphics2D g){
        g.fill(pelota.getPelota());  
        g.fill(r1.getRaqueta());
        //g.fill(r2.getRaqueta());
    }
    public void actualizar(){
        //MODO DOS JUGADORES -->  pelota.mover(getBounds(), colision(r1.getRaqueta()), colision(r2.getRaqueta()) );
        pelota.mover(getBounds(), colision(r1.getRaqueta()), false );
        r1.moverR1(getBounds());
        //r2.moverR2(getBounds());
    }
    
    private boolean colision(Rectangle2D r){
        return pelota.getPelota().intersects(r);        
    }
    
    private void dibujarPuntaje(Graphics2D g){
        
        Graphics2D g1=g, g2=g, vidas=g;
        
        Font puntaje = new Font("Arial", Font.BOLD, 30);
        g.setFont(puntaje);
        
        g1.drawString("Puntos: "+Integer.toString(pelota.getScore1()), (float)getBounds().getCenterX() + 100, 30);
        //g2.drawString(Integer.toString(pelota.getScore2()), (float)getBounds().getCenterX() + 25, 30);
        vidas.drawString("Vidas: "+Integer.toString(pelota.getVidas1()), (float)getBounds().getCenterX()-200, 30);
        if(pelota.vidas1==0){
            g.drawString("PERDISTE", (float)getBounds().getCenterX(), (float)getBounds().getCenterY());
            Pelota.finJuego=true;
        }
    }
    
    
    
    //Clase opcional
    public class ImagenFondo extends JPanel{
        public void paint(Graphics g){            
            //esto es opcional            
            ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/ciudadNeon1.png"));
            g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);                        
            setOpaque(false);
            super.paint(g);
        }
    }
}*/
