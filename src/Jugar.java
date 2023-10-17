import clases.Ventana;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import principal.Principal;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author saust
 */
public class Jugar extends javax.swing.JPanel {    
    MenuPrincipal framePadre;
    
    /**
     * Creates new form jugar
     */
    public Jugar(MenuPrincipal x) {
        framePadre=x;
        initComponents();
        //setBackground(new Color(0, 0, 0, 0));
    }                                                                                                                               

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp = new javax.swing.JLabel();
        pve = new javax.swing.JLabel();
        pvp = new javax.swing.JLabel();
        brillo1 = new javax.swing.JLabel();
        brillo2 = new javax.swing.JLabel();
        brillo3 = new javax.swing.JLabel();
        brillo4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/jp.png"))); // NOI18N
        jp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpMouseClicked(evt);
            }
        });
        add(jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, 700));

        pve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pve.png"))); // NOI18N
        add(pve, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, -2, -1, 700));

        pvp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pvp.png"))); // NOI18N
        add(pvp, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, -2, -1, 700));

        brillo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/brillo.png"))); // NOI18N
        add(brillo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 90, 90, 110));

        brillo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/brillo.png"))); // NOI18N
        add(brillo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 90, 110));

        brillo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/brillo.png"))); // NOI18N
        add(brillo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 90, 110));

        brillo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/brillo.png"))); // NOI18N
        add(brillo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 500, 90, 110));
    }// </editor-fold>//GEN-END:initComponents

    private void jpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpMouseClicked
        
    //#Borra el Frame anterior
        framePadre.dispose();
    
        
    //#Dos maneras exactamente iguales de ejecutar la clase Principal:
    //(1)
        Principal principal = new Principal();        
    //(2)
        /*String[] args = null;
        Principal.main(args);*/
    }//GEN-LAST:event_jpMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brillo1;
    private javax.swing.JLabel brillo2;
    private javax.swing.JLabel brillo3;
    private javax.swing.JLabel brillo4;
    private javax.swing.JLabel jp;
    private javax.swing.JLabel pve;
    private javax.swing.JLabel pvp;
    // End of variables declaration//GEN-END:variables
}
