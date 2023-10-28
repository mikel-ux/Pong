/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arkanoid;

/**
 *
 * @author saust
 */
public class Nivel {
    public int numeroNivel=1;
    public int cantidadBloques=10;
    public int velocidadHilo=5;

    public Nivel(int cantidadBloques) {        
        this.cantidadBloques = cantidadBloques;        
    }

    public int getNumeroNivel() {
        return numeroNivel;
    }

    public int getCantidadBloques() {
        return cantidadBloques;
    }

    public int getVelocidadHilo() {
        return velocidadHilo;
    }

    public void aumentarNivel() {
        numeroNivel++;
        // Ajusta la cantidad de bloques y la velocidad del hilo para el siguiente nivel.
        cantidadBloques += 10; // Puedes ajustar esta cantidad según tus necesidades.
        if(velocidadHilo>0){
            velocidadHilo+= 5;
        }
    }
}
