/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmisd;

/**
 *
 * @author Escuela
 */
public class Stats extends javax.swing.JPanel {

    /**
     * Creates new form Stats
     */
    public Stats() {
        initComponents();
    }
    public void ChangeText(String score){
        String text = jLabel2.getText()+score;
        if (text == "") {
            text = "No Scores";
        }
        jLabel2.setText(text);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(395, 250));
        setPreferredSize(new java.awt.Dimension(400, 250));
        setLayout(new java.awt.GridLayout(3, 1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ScoreBoard");
        add(jLabel1);
        add(jLabel2);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Para volver a intentar presiona \"R\"");
        jPanel1.add(jLabel4, java.awt.BorderLayout.CENTER);

        jLabel5.setText("Instrucciones: Presiona los botones en el orden en el que se iluminan");
        jPanel1.add(jLabel5, java.awt.BorderLayout.PAGE_START);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
