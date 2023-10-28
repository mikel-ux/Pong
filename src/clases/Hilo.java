/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import arkanoid.Nivel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saust
 */
public class Hilo extends Thread {
    private TableroJuego lamina;
    private Nivel nivel;  // Agregamos una referencia al objeto Nivel

    public Hilo(TableroJuego lamina, Nivel nivel) {
        this.lamina = lamina;
        this.nivel = nivel;
    }

    @Override
    public void run() {
        while (!Pelota.finJuego) {
            lamina.repaint();

            // Dormir según la velocidad del nivel actual
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
}