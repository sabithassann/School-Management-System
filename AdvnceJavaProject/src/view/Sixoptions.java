/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Font;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author imran
 */
public class Sixoptions extends javax.swing.JFrame {

    /**
     * Creates new form Sixoptions
     */
    public Sixoptions() {
        setUndecorated(true);
        initComponents();
        //imageSize();
        setTime();
        setLocationRelativeTo(null);
        
        
        
       

        
    }
    
   Admin admin=new Admin(this);
    
//    public void imageSize(){
//        ImageIcon trackStd=new ImageIcon("C:\\Users\\imran\\Documents\\NetBeansProjects\\Testdesign\\src\\images\\trackstd.png");
//        //txtTrack.setIcon(trackStd);
//        
//        Image img=trackStd.getImage();
//        Image imageScale=img.getScaledInstance(txtTrack.getWidth(), txtTrack.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon scaledIcon=new ImageIcon(imageScale);
//        txtTrack.setIcon(scaledIcon);
//    }
    
    
     NewAdmissionTest newadmission=new NewAdmissionTest(this);
     Profiles profiles=new Profiles(this);
     //Attendence attendence=new Attendence(this);
     Track track=new Track(this);
     PaymentInfo payment=new PaymentInfo(this);
     Dashboard dashboard=new Dashboard(this);
     

    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dateLab = new javax.swing.JLabel();
        timeLab = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtTrack = new javax.swing.JLabel();
        txtAttendence = new javax.swing.JPanel();
        txtAtten = new javax.swing.JLabel();
        p = new javax.swing.JPanel();
        txtAdmission = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        g = new javax.swing.JPanel();
        txtProfiles = new javax.swing.JLabel();
        d = new javax.swing.JPanel();
        txtPayment = new javax.swing.JLabel();
        q = new javax.swing.JPanel();
        txtAdmin = new javax.swing.JLabel();
        btnTrackStd = new javax.swing.JButton();
        btnAttendence = new javax.swing.JButton();
        btnNewAdmission = new javax.swing.JButton();
        btnProfiles = new javax.swing.JButton();
        btnPaymentInfo = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnLogout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(80, 114, 85));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dateLab.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dateLab.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(dateLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 210, 30));

        timeLab.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        timeLab.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(timeLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 210, 30));

        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minus (1).png"))); // NOI18N
        btnMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
        });
        jPanel1.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, 40, 50));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cross.png"))); // NOI18N
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 20, 40, 50));

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Management System");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 110));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 110));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTrack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images1/trackmenu1 (2).png"))); // NOI18N
        jPanel2.add(txtTrack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 140));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 170, 140));

        txtAttendence.setBackground(new java.awt.Color(255, 255, 255));
        txtAttendence.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAtten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images1/attendence (2).png"))); // NOI18N
        txtAttendence.add(txtAtten, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 140));

        getContentPane().add(txtAttendence, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 180, 140));

        p.setBackground(new java.awt.Color(255, 255, 255));
        p.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAdmission.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images1/trackstd1 (2).png"))); // NOI18N
        p.add(txtAdmission, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, 130));

        getContentPane().add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 180, 140));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        g.setBackground(new java.awt.Color(255, 255, 255));
        g.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtProfiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images1/profile (1).png"))); // NOI18N
        g.add(txtProfiles, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 190, 160));

        jPanel8.add(g, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 180, 160));

        d.setBackground(new java.awt.Color(255, 255, 255));
        d.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images1/paymentinfo (1).png"))); // NOI18N
        d.add(txtPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 150));

        jPanel8.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 180, 150));

        q.setBackground(new java.awt.Color(255, 255, 255));
        q.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images1/admin (1).png"))); // NOI18N
        q.add(txtAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 150));

        jPanel8.add(q, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 360, 180, 150));

        btnTrackStd.setBackground(new java.awt.Color(51, 178, 73));
        btnTrackStd.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnTrackStd.setForeground(new java.awt.Color(255, 255, 255));
        btnTrackStd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/event.png"))); // NOI18N
        btnTrackStd.setText("Track Std");
        btnTrackStd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrackStd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTrackStd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrackStdActionPerformed(evt);
            }
        });
        jPanel8.add(btnTrackStd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 140, 40));

        btnAttendence.setBackground(new java.awt.Color(51, 178, 73));
        btnAttendence.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnAttendence.setForeground(new java.awt.Color(255, 255, 255));
        btnAttendence.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/statistics.png"))); // NOI18N
        btnAttendence.setText("Dashboard");
        btnAttendence.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAttendence.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAttendence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttendenceActionPerformed(evt);
            }
        });
        jPanel8.add(btnAttendence, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 150, 40));

        btnNewAdmission.setBackground(new java.awt.Color(51, 178, 73));
        btnNewAdmission.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnNewAdmission.setForeground(new java.awt.Color(255, 255, 255));
        btnNewAdmission.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/list.png"))); // NOI18N
        btnNewAdmission.setText("Admission");
        btnNewAdmission.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewAdmission.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNewAdmission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewAdmissionActionPerformed(evt);
            }
        });
        jPanel8.add(btnNewAdmission, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, 150, 40));

        btnProfiles.setBackground(new java.awt.Color(51, 178, 73));
        btnProfiles.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnProfiles.setForeground(new java.awt.Color(255, 255, 255));
        btnProfiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/job-search.png"))); // NOI18N
        btnProfiles.setText("Profiles");
        btnProfiles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProfiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfilesActionPerformed(evt);
            }
        });
        jPanel8.add(btnProfiles, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 530, 140, 40));

        btnPaymentInfo.setBackground(new java.awt.Color(51, 178, 73));
        btnPaymentInfo.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnPaymentInfo.setForeground(new java.awt.Color(255, 255, 255));
        btnPaymentInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/validating-ticket.png"))); // NOI18N
        btnPaymentInfo.setText("Payment Info");
        btnPaymentInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPaymentInfo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPaymentInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentInfoActionPerformed(evt);
            }
        });
        jPanel8.add(btnPaymentInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 530, -1, 40));

        btnAdmin.setBackground(new java.awt.Color(51, 178, 73));
        btnAdmin.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/administration.png"))); // NOI18N
        btnAdmin.setText("Admin");
        btnAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdmin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        jPanel8.add(btnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 530, 140, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/log-out(1).png"))); // NOI18N
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });
        jPanel3.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 490, 64, 64));

        jPanel8.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1020, 570));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1040, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrackStdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrackStdActionPerformed
        // TODO add your handling code here:
        this.dispose();
        track.setVisible(true);
        
        
       
        
    }//GEN-LAST:event_btnTrackStdActionPerformed

    
    
    
    
      public void setTime(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Sixoptions.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                   java.util.Date date=new java.util.Date();
                   SimpleDateFormat tf=new SimpleDateFormat("h:mm:ss: aa");
                   SimpleDateFormat df=new SimpleDateFormat("EEEE, dd-MM-yyyy");
                   String time=tf.format(date);
                   
                   Font customFont = new Font("Arial", Font.BOLD, 15);
                   
                   timeLab.setFont(customFont);
                   dateLab.setFont(customFont);
                   
                   timeLab.setText(time.split(" ")[0]+" "+time.split(" ")[1]);
                   dateLab.setText(df.format(date));
                }
            }
        }).start();
    }
    
    
    
    private void btnNewAdmissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewAdmissionActionPerformed
        // TODO add your handling code here:
        this.dispose();
        newadmission.setVisible(true);
       
    }//GEN-LAST:event_btnNewAdmissionActionPerformed

    private void btnProfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfilesActionPerformed
        // TODO add your handling code here:
        this.dispose();
        profiles.setVisible(true);
        
    }//GEN-LAST:event_btnProfilesActionPerformed

    private void btnAttendenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttendenceActionPerformed
        // TODO add your handling code here:
        this.dispose();
        dashboard.setVisible(true);
        
    }//GEN-LAST:event_btnAttendenceActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        // TODO add your handling code here:
        this.dispose();
        admin.setVisible(true);
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnPaymentInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentInfoActionPerformed
        // TODO add your handling code here:
        this.dispose();
        payment.setVisible(true);
    }//GEN-LAST:event_btnPaymentInfoActionPerformed

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        // TODO add your handling code here:
        this.dispose();
         Login login=new Login();
        login.setVisible(true);
        
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        // TODO add your handling code here:
        setState(Sixoptions.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

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
            java.util.logging.Logger.getLogger(Sixoptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sixoptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sixoptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sixoptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sixoptions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnAttendence;
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JButton btnNewAdmission;
    private javax.swing.JButton btnPaymentInfo;
    private javax.swing.JButton btnProfiles;
    private javax.swing.JButton btnTrackStd;
    private javax.swing.JPanel d;
    private javax.swing.JLabel dateLab;
    private javax.swing.JPanel g;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel p;
    private javax.swing.JPanel q;
    private javax.swing.JLabel timeLab;
    private javax.swing.JLabel txtAdmin;
    private javax.swing.JLabel txtAdmission;
    private javax.swing.JLabel txtAtten;
    private javax.swing.JPanel txtAttendence;
    private javax.swing.JLabel txtPayment;
    private javax.swing.JLabel txtProfiles;
    private javax.swing.JLabel txtTrack;
    // End of variables declaration//GEN-END:variables
}
