/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;

/**
 *
 * @author ManiPC
 */
public class ThreadState extends javax.swing.JPanel {

    /**
     * Creates new form ThreadState
     */
    public ThreadState(String name) {
        initComponents();
        lbName.setText(name);
        
    }
    public void setToWait(){
        lbName.setBackground(Color.red);
    }
    public void setToRun(){
        lbName.setBackground(Color.green);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbName = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout(1, 1));

        lbName.setText("jLabel1");
        lbName.setOpaque(true);
        add(lbName);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbName;
    // End of variables declaration//GEN-END:variables
}
