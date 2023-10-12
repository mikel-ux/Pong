/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obtenerRecursos;

import java.applet.AudioClip;
/**
 *
 * @author saust
 */
public class Audio {
    
    public AudioClip getAudio(String direccion){
        return java.applet.Applet.newAudioClip(getClass().getResource(direccion));
    }
}
