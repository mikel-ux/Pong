/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package clases;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author saust
 */
public class Intento extends javax.swing.JFrame {

    private JLabel brillo;
    private JLabel brillo1;
    private JLabel config;
    private JLabel jugar;
    private JLabel logo;
    private JLabel reglas;
    private JLabel titulo;
    private JLabel usuarios;
    
    
    public static void main(String[] args){
        Intento intento = new Intento();
    }
    
    /**
     * Creates new form Menu
     */
    public Intento(){
        
        config = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        jugar = new javax.swing.JLabel();
        reglas = new javax.swing.JLabel();
        usuarios = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        brillo = new javax.swing.JLabel();
        brillo1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        config.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        config.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/config.png"))); // NOI18N
        add(config, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 281, 590, -1));

        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/titulo.png"))); // NOI18N
        titulo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 189, 89), 1, true));
        add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 14, 700, 169));

        jugar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/jugar.png"))); // NOI18N
        add(jugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 211, 688, -1));

        reglas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reglas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/reglas.png"))); // NOI18N
        add(reglas, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 347, 688, -1));

        usuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/usuario.png"))); // NOI18N
        add(usuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 416, 688, -1));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/skullGamingLogo-sinFondo.png"))); // NOI18N
        logo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        logo.setMaximumSize(new java.awt.Dimension(100, 100));
        logo.setMinimumSize(new java.awt.Dimension(100, 100));
        add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, -1, -1));

        brillo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        brillo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/brillo.png"))); // NOI18N
        add(brillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 14, 169, 169));

        brillo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        brillo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/brillo.png"))); // NOI18N
        add(brillo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 14, 169, 169));
        
    }
    
    

                                     
}
