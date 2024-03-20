/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JOptionPane;
import model.StudentData;
import util.DbCon;

/**
 *
 * @author imran
 */
public class PaymentInfo extends javax.swing.JFrame {

    /**
     * Creates new form PaymentInfo
     */
    private Sixoptions sixoptions;
    public PaymentInfo(Sixoptions sixoptions) {
        setUndecorated(true);
        initComponents();
        this.sixoptions=sixoptions;
        this.setLocationRelativeTo(null);
        
    }

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtClass = new javax.swing.JTextField();
        txtRoll = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(60, 92, 72));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Download Payment info");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 240, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 80));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Class:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 190, 80, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Roll:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, 30));

        txtClass.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtClass.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClassActionPerformed(evt);
            }
        });
        jPanel4.add(txtClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 180, 40));

        txtRoll.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtRoll.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtRoll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRollActionPerformed(evt);
            }
        });
        jPanel4.add(txtRoll, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 180, 40));

        btnNext.setBackground(new java.awt.Color(51, 178, 73));
        btnNext.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jPanel4.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 90, 40));

        btnBack.setBackground(new java.awt.Color(0, 153, 51));
        btnBack.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel4.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, 110, 40));

        jPanel3.setBackground(new java.awt.Color(229, 252, 245));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 420, 240));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/paymentinfopage.png"))); // NOI18N
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 540));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 970, 540));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClassActionPerformed

    private void txtRollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRollActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRollActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        
        if(txtRoll.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Field cannot Be Empty");
            return;
        }
        else if(txtClass.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Field Cannot Be Empty");
            return;
        }
        
        
        int roll=Integer.parseInt(txtRoll.getText());
        int stdClass=Integer.parseInt(txtClass.getText());
        DbCon con=new DbCon();
        StudentData studentData=con.getStudentData(roll, stdClass);
//        
//        DownloadPayment downloadPayment=new DownloadPayment(traineeId,batchId);
//        downloadPayment.setVisible(true);
        //this.dispose();
        if (studentData != null) {
            
           
        
        DownloadPayment downloadPayment=new DownloadPayment(roll, stdClass);
        downloadPayment.setVisible(true);
        // Update the UI components with the retrieved student data.
        txtRoll.setText(""+studentData.getRoll());
        txtClass.setText(""+studentData.getStdClass());
        // Update other UI components with corresponding data.
    } else {
        // Handle the case where no matching data is found in the database.
        // You can show a message or take appropriate action.
        
            JOptionPane.showMessageDialog(rootPane, "No data found");
            
    }
        
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
        sixoptions.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(PaymentInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Sixoptions sixoptions=new Sixoptions();
                PaymentInfo paymentInfo=new PaymentInfo(sixoptions);
                paymentInfo.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtClass;
    private javax.swing.JTextField txtRoll;
    // End of variables declaration//GEN-END:variables
}
