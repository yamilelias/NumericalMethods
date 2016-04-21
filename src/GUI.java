/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yamil Elías
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newtonMethod = new javax.swing.JButton();
        GaussMethod = new javax.swing.JButton();
        PolynomialMethod = new javax.swing.JButton();
        hornerMethod = new javax.swing.JButton();
        newtonMultivariableMethod = new javax.swing.JButton();
        titleLabel1 = new javax.swing.JLabel();
        matrixMethod = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        newtonMethod.setText("Newton");
        newtonMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newtonMethodActionPerformed(evt);
            }
        });

        GaussMethod.setText("Gauss");
        GaussMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GaussMethodActionPerformed(evt);
            }
        });

        PolynomialMethod.setText("Polynomial");
        PolynomialMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PolynomialMethodActionPerformed(evt);
            }
        });

        hornerMethod.setText("Horner");
        hornerMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hornerMethodActionPerformed(evt);
            }
        });

        newtonMultivariableMethod.setText("Newton Multivariable");
        newtonMultivariableMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newtonMultivariableMethodActionPerformed(evt);
            }
        });

        titleLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        titleLabel1.setText("Metodos numericos");

        matrixMethod.setText("Matrices");
        matrixMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matrixMethodActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newtonMethod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PolynomialMethod, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(GaussMethod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(hornerMethod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newtonMultivariableMethod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(matrixMethod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addComponent(titleLabel1)
                    .addContainerGap(65, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GaussMethod, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newtonMultivariableMethod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hornerMethod)
                    .addComponent(PolynomialMethod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newtonMethod)
                    .addComponent(matrixMethod))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(titleLabel1)
                    .addContainerGap(137, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newtonMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newtonMethodActionPerformed
        GUINewtonMethod newton = new GUINewtonMethod();
        newton.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_newtonMethodActionPerformed

    private void GaussMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GaussMethodActionPerformed
        // TODO add your handling code here:
        
        GUIGaussMethod gauss = new GUIGaussMethod();
        gauss.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_GaussMethodActionPerformed

    private void PolynomialMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PolynomialMethodActionPerformed
        GUIPolyMethod poly = new GUIPolyMethod();
        poly.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_PolynomialMethodActionPerformed

    private void hornerMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hornerMethodActionPerformed
        GUIHornerMethod horner = new GUIHornerMethod();
        horner.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_hornerMethodActionPerformed

    private void newtonMultivariableMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newtonMultivariableMethodActionPerformed
        GUINewtonMultivariableMethod newtonMulti = new GUINewtonMultivariableMethod();
        newtonMulti.hideElements(); // This is to hide the functions in the Newton Raphson Multivariable Application
        newtonMulti.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_newtonMultivariableMethodActionPerformed

    private void matrixMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matrixMethodActionPerformed
        this.setVisible(false);
        GUIMatrixMethod matrix = new GUIMatrixMethod();
    }//GEN-LAST:event_matrixMethodActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GaussMethod;
    private javax.swing.JButton PolynomialMethod;
    private javax.swing.JButton hornerMethod;
    private javax.swing.JButton matrixMethod;
    private javax.swing.JButton newtonMethod;
    private javax.swing.JButton newtonMultivariableMethod;
    private javax.swing.JLabel titleLabel1;
    // End of variables declaration//GEN-END:variables
}
