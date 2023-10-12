/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 *
 * @author Alumno
 */
public class Inicio extends JPanel{
    
    private JLabel cerrarSesion;
    private JLabel configuracion;
    private JLabel fotoUsuario;
    private JLabel jugar;
    private JLabel reglas;
    private JLabel titulo;
    private JLabel usuario;
    private JButton boton;
    
    public Inicio(){
        
        boton = new javax.swing.JButton();
        boton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        boton.setForeground(new java.awt.Color(255, 255, 255));
        boton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        boton.setText("Reglas");
        boton.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        
        
        
        
        titulo = new javax.swing.JLabel();
        configuracion = new javax.swing.JLabel();
        reglas = new javax.swing.JLabel();
        jugar = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        cerrarSesion = new javax.swing.JLabel();
        fotoUsuario = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Pong");
        titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        configuracion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        configuracion.setForeground(new java.awt.Color(255, 255, 255));
        configuracion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        configuracion.setText("Configuraciones");

        reglas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        reglas.setForeground(new java.awt.Color(255, 255, 255));
        reglas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reglas.setText("Reglas");
        reglas.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        jugar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jugar.setForeground(new java.awt.Color(255, 255, 255));
        jugar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugar.setText("Jugar");
        jugar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //jugarMouseClicked(evt);
            }
        });

        usuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        usuario.setForeground(new java.awt.Color(255, 255, 255));
        usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usuario.setText("U");
        usuario.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        cerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        cerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cerrarSesion.setText("--");
        cerrarSesion.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        fotoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fotoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        fotoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fotoUsuario.setText("--");
        fotoUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        
        //jugar.setBounds(20, 20, 50, 50);
        //add(jugar);
        
        //boton.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
        //add(boton);
        titulo.setBounds(400, 400, 40, 20);
        add(titulo);
        
        
        //add(configuracion);
        //add(reglas);
        //add(usuario);
        
        
    }
    
}
