/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.StaffData;
import model.TeacherData;
import util.DbCon;

/**
 *
 * @author imran
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    //private TeacherData teacherData;
    
   
    
    private Sixoptions sixoptions;
    
    public Admin(Sixoptions sixoptions) {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        this.sixoptions=sixoptions;
        
       
        //this.teacherData=teacherData;
//        DbCon databaseConnection=new DbCon();
//        Connection connection=databaseConnection.getCon();
        
    }
    
    public TeacherData teacherData=new TeacherData();
    
    public StaffData staffData=new StaffData();

    
    
        public Date DateToSqlDate(java.util.Date utilDate){
        if(utilDate !=null){
            return new Date(utilDate.getTime());
        }
        return null;
    }
        
        
        public void resetTeacher(){
         txtTeacherId.setText("");
        txtTeacherEmail.setText("");
       txtTeacherAge.setText("");
        teacherRadioMale.setSelected(false);
       teacherRadioFemale.setSelected(false);
       teacherDate.setDate(null);
       chooseTeacherPic.setIcon(null);
        }
        
        public void resetStaff(){
            txtStaffId.setText("");
            txtStaffEmail.setText("");
            txtStaffAge.setText("");
            staffRadioMale.setSelected(false);
            staffRadioFemale.setSelected(false);
            staffDate.setDate(null);
            chooseStaffPic.setIcon(null);
        }
        
        
        public void resetRemoveTeacher(){
            profileTeacherAge.setText("");
            profileTeacherDob.setText("");
            profileTeacherEmail.setText("");
            profileTeacherGender.setText("");
            profileTeacherId.setText("");
            profileTeacherPic.setIcon(null);
            txtRemoveTeacherId.setText("");
        }
        
        public void resetRemoveStaff(){
            profileStaffAge.setText("");
            profileStaffDob.setText("");
            profileStaffEmail.setText("");
            profileStaffGender.setText("");
            profileStaffId.setText("");
            profileStaffPic.setIcon(null);
            txtRemoveStaffId.setText("");
            
        }
        
        
        public void resetPassworduserName(){
            txtUsername1.setText("");
            txtOldPassword.setText("");
            txtNewPassword.setText("");
        }
        
        
        
//        for showing data in removeTeacher
        
        
        public TeacherData retrieveTeacherData(String teacherId){
            TeacherData teacherData1=null;
            
            DbCon databaseConnection=new DbCon();
            Connection con=databaseConnection.getCon();
            
            if(con!=null){
                
                try {
                    String query="select * from teacherdata where teacherId=?";
                    PreparedStatement pstmt=con.prepareStatement(query);
                    
                    pstmt.setString(1, teacherId);
                    ResultSet rs=pstmt.executeQuery();
                    
                    if(rs.next()){
                        String teacherId1=rs.getString("teacherId");
                        String email=rs.getString("email");
                        int age=rs.getInt("age");
                        String gender=rs.getString("gender");
                        Date dob=rs.getDate("dob");
                        String teacherPicturePath=rs.getString("teacherPicturePath");
                        
                        
                        teacherData1=new TeacherData(teacherId, email, age, gender, dob, teacherPicturePath);
                    }
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            return teacherData1;
        }
        
        
        
        public StaffData retrieveStaffData(String teacherId){
            StaffData staffData1=null;
            
            DbCon databaseConnection=new DbCon();
            Connection con=databaseConnection.getCon();
            
            if(con!=null){
                
                try {
                    String query="select * from staffdata where staffId=?";
                    PreparedStatement pstmt=con.prepareStatement(query);
                    
                    pstmt.setString(1, teacherId);
                    ResultSet rs=pstmt.executeQuery();
                    
                    if(rs.next()){
                        String teacherId1=rs.getString("staffId");
                        String email=rs.getString("email");
                        int age=rs.getInt("age");
                        String gender=rs.getString("gender");
                        Date dob=rs.getDate("dob");
                        String teacherPicturePath=rs.getString("staffPicturePath");
                        
                        
                        staffData1=new StaffData(email, email, age, gender, dob, teacherPicturePath);
                    }
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            return staffData1;
        }
        
        
        
        //delete teacher data
        
//        public void deleteTeacher(String teacherId){
//            DbCon databaseConnection=new DbCon();
//            Connection con=databaseConnection.getCon();
//            
//            
//            
//        try {
//            String sql="delete from teacherdata where teacherId=?";
//            PreparedStatement preparedStatement=con.prepareStatement(sql);
//            int rowsDeleted=preparedStatement.executeUpdate();
//             if (rowsDeleted > 0) {
//            System.out.println("Teacher data with ID " + teacherId + " deleted successfully.");
//        } else {
//            System.out.println("No teacher data found with ID " + teacherId + ".");
//        }
//             con.close();
//            
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            
//            
//            
//            
//            
//            
//        }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        mainTabPane = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnResetPass1 = new javax.swing.JButton();
        btnMainTabHome = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        btnAddTeacher = new javax.swing.JButton();
        btnAddStaff = new javax.swing.JButton();
        btnRemoveTeacher = new javax.swing.JButton();
        btnRemoveStudent = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        backAddTeacher = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTeacherAge = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTeacherId = new javax.swing.JTextField();
        txtTeacherEmail = new javax.swing.JTextField();
        teacherRadioMale = new javax.swing.JRadioButton();
        teacherRadioFemale = new javax.swing.JRadioButton();
        chooseTeacherPic = new javax.swing.JLabel();
        btnTeacherChoosePic = new javax.swing.JButton();
        btnTeacherAdd = new javax.swing.JButton();
        resetTeacher = new javax.swing.JButton();
        teacherDate = new com.toedter.calendar.JDateChooser();
        jPanel6 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        backAddStaff = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtStaffAge = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtStaffId = new javax.swing.JTextField();
        txtStaffEmail = new javax.swing.JTextField();
        staffRadioMale = new javax.swing.JRadioButton();
        staffRadioFemale = new javax.swing.JRadioButton();
        chooseStaffPic = new javax.swing.JLabel();
        btnStaffChoosePic = new javax.swing.JButton();
        btnStaffAdd = new javax.swing.JButton();
        resetStaff = new javax.swing.JButton();
        staffDate = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        backRemoveTeacher = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtRemoveTeacherId = new javax.swing.JTextField();
        btnRemoveTeacherRemove = new javax.swing.JButton();
        btnRemoveTeacherShow = new javax.swing.JButton();
        showRemoveT = new javax.swing.JPanel();
        profileTeacherPic = new javax.swing.JLabel();
        profileTeacherDob = new javax.swing.JLabel();
        profileTeacherId = new javax.swing.JLabel();
        profileTeacherEmail = new javax.swing.JLabel();
        profileTeacherAge = new javax.swing.JLabel();
        profileTeacherGender = new javax.swing.JLabel();
        btnRemoveTeacherReset = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        backRemoveStudent = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtRemoveStaffId = new javax.swing.JTextField();
        btnRemoveStaffShow = new javax.swing.JButton();
        btnRemoveStaffRemove = new javax.swing.JButton();
        showRemoveS = new javax.swing.JPanel();
        profileStaffPic = new javax.swing.JLabel();
        profileStaffDob = new javax.swing.JLabel();
        profileStaffId = new javax.swing.JLabel();
        profileStaffEmail = new javax.swing.JLabel();
        profileStaffAge = new javax.swing.JLabel();
        profileStaffGender = new javax.swing.JLabel();
        btnRemoveStaffReset = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        backResetPass = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtOldPassword = new javax.swing.JTextField();
        btnResetPasswordNew = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtUsername1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1020, 650));
        setPreferredSize(new java.awt.Dimension(1020, 650));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1020, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(60, 92, 72));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Administrator");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 960, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 60));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnResetPass1.setBackground(new java.awt.Color(255, 204, 0));
        btnResetPass1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnResetPass1.setForeground(new java.awt.Color(51, 51, 51));
        btnResetPass1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset-password(1).png"))); // NOI18N
        btnResetPass1.setText("Reset Password");
        btnResetPass1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResetPass1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnResetPass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetPass1ActionPerformed(evt);
            }
        });
        jPanel7.add(btnResetPass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 420, -1, 50));

        btnMainTabHome.setBackground(new java.awt.Color(204, 255, 204));
        btnMainTabHome.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        btnMainTabHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home.png"))); // NOI18N
        btnMainTabHome.setText("Home");
        btnMainTabHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMainTabHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainTabHomeActionPerformed(evt);
            }
        });
        jPanel7.add(btnMainTabHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 120, 50));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        btnAddTeacher.setBackground(new java.awt.Color(51, 178, 73));
        btnAddTeacher.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnAddTeacher.setForeground(new java.awt.Color(255, 255, 255));
        btnAddTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/teacher.png"))); // NOI18N
        btnAddTeacher.setText("Add Teacher");
        btnAddTeacher.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAddTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTeacherActionPerformed(evt);
            }
        });

        btnAddStaff.setBackground(new java.awt.Color(51, 178, 73));
        btnAddStaff.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnAddStaff.setForeground(new java.awt.Color(255, 255, 255));
        btnAddStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/staff.png"))); // NOI18N
        btnAddStaff.setText("Add Staff");
        btnAddStaff.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAddStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStaffActionPerformed(evt);
            }
        });

        btnRemoveTeacher.setBackground(new java.awt.Color(234, 33, 46));
        btnRemoveTeacher.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnRemoveTeacher.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete_teacher.png"))); // NOI18N
        btnRemoveTeacher.setText("Romove T");
        btnRemoveTeacher.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRemoveTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveTeacherActionPerformed(evt);
            }
        });

        btnRemoveStudent.setBackground(new java.awt.Color(234, 33, 46));
        btnRemoveStudent.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnRemoveStudent.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete_staff.png"))); // NOI18N
        btnRemoveStudent.setText("Remove S");
        btnRemoveStudent.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRemoveStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveStudentActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Arial", 1, 26)); // NOI18N
        jLabel22.setText("Admin Pannel");
        jLabel22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(btnAddTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(btnAddStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(btnRemoveTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(btnRemoveStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        jPanel7.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 540, 300));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/adminnew1020x560.png"))); // NOI18N
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 560));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainTabPane.addTab("menu", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backAddTeacher.setBackground(new java.awt.Color(204, 255, 153));
        backAddTeacher.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        backAddTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/previous.png"))); // NOI18N
        backAddTeacher.setText("Back");
        backAddTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backAddTeacherActionPerformed(evt);
            }
        });
        jPanel11.add(backAddTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 120, 40));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Teacher Registration Form");
        jPanel16.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 300, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Dob:");
        jPanel16.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 60, 20));

        txtTeacherAge.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel16.add(txtTeacherAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 190, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Teacher Id:");
        jPanel16.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 80, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Email:");
        jPanel16.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 60, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Age:");
        jPanel16.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 60, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Gender:");
        jPanel16.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 60, 20));

        txtTeacherId.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel16.add(txtTeacherId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 190, 30));

        txtTeacherEmail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel16.add(txtTeacherEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 190, -1));

        buttonGroup1.add(teacherRadioMale);
        teacherRadioMale.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        teacherRadioMale.setText("Male");
        jPanel16.add(teacherRadioMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, -1, -1));

        buttonGroup1.add(teacherRadioFemale);
        teacherRadioFemale.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        teacherRadioFemale.setText("Female");
        jPanel16.add(teacherRadioFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, -1));

        chooseTeacherPic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel16.add(chooseTeacherPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 110, 100));

        btnTeacherChoosePic.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnTeacherChoosePic.setText("Choose");
        btnTeacherChoosePic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeacherChoosePicActionPerformed(evt);
            }
        });
        jPanel16.add(btnTeacherChoosePic, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, -1, -1));

        btnTeacherAdd.setBackground(new java.awt.Color(204, 255, 204));
        btnTeacherAdd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnTeacherAdd.setText("Add");
        btnTeacherAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTeacherAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeacherAddActionPerformed(evt);
            }
        });
        jPanel16.add(btnTeacherAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 90, 40));

        resetTeacher.setBackground(new java.awt.Color(255, 204, 204));
        resetTeacher.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        resetTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        resetTeacher.setText("Reset");
        resetTeacher.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetTeacher.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        resetTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetTeacherActionPerformed(evt);
            }
        });
        jPanel16.add(resetTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, 100, 40));
        jPanel16.add(teacherDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, -1, -1));

        jPanel11.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 580, 520));

        jPanel5.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 560));

        mainTabPane.addTab("add_T", jPanel5);

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backAddStaff.setBackground(new java.awt.Color(204, 255, 153));
        backAddStaff.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        backAddStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/previous.png"))); // NOI18N
        backAddStaff.setText("Back");
        backAddStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backAddStaffActionPerformed(evt);
            }
        });
        jPanel12.add(backAddStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 120, 40));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Staff Registration Form");
        jPanel17.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 300, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Dob:");
        jPanel17.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 60, 30));
        jPanel17.add(txtStaffAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 190, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Staff Id:");
        jPanel17.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Email:");
        jPanel17.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 60, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Age:");
        jPanel17.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 60, 20));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Gender:");
        jPanel17.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 60, 20));
        jPanel17.add(txtStaffId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 190, -1));
        jPanel17.add(txtStaffEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 190, -1));

        buttonGroup1.add(staffRadioMale);
        staffRadioMale.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        staffRadioMale.setText("Male");
        jPanel17.add(staffRadioMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, -1, -1));

        buttonGroup1.add(staffRadioFemale);
        staffRadioFemale.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        staffRadioFemale.setText("Female");
        jPanel17.add(staffRadioFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, -1));

        chooseStaffPic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel17.add(chooseStaffPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 110, 100));

        btnStaffChoosePic.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnStaffChoosePic.setText("Choose");
        btnStaffChoosePic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffChoosePicActionPerformed(evt);
            }
        });
        jPanel17.add(btnStaffChoosePic, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, -1, -1));

        btnStaffAdd.setBackground(new java.awt.Color(204, 255, 204));
        btnStaffAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnStaffAdd.setText("Add");
        btnStaffAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStaffAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffAddActionPerformed(evt);
            }
        });
        jPanel17.add(btnStaffAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 90, 40));

        resetStaff.setBackground(new java.awt.Color(255, 204, 204));
        resetStaff.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        resetStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        resetStaff.setText("Reset");
        resetStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetStaff.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        resetStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetStaffActionPerformed(evt);
            }
        });
        jPanel17.add(resetStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, 100, 40));
        jPanel17.add(staffDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, -1, -1));

        jPanel12.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 580, 520));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        mainTabPane.addTab("add_S", jPanel6);

        jPanel13.setBackground(new java.awt.Color(239, 239, 239));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backRemoveTeacher.setBackground(new java.awt.Color(204, 255, 153));
        backRemoveTeacher.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        backRemoveTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/previous.png"))); // NOI18N
        backRemoveTeacher.setText("Back");
        backRemoveTeacher.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backRemoveTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backRemoveTeacherActionPerformed(evt);
            }
        });
        jPanel13.add(backRemoveTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 120, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Teacher Id:");
        jPanel13.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 100, 30));
        jPanel13.add(txtRemoveTeacherId, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 220, 30));

        btnRemoveTeacherRemove.setBackground(new java.awt.Color(255, 204, 204));
        btnRemoveTeacherRemove.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnRemoveTeacherRemove.setText("Remove");
        btnRemoveTeacherRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemoveTeacherRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveTeacherRemoveActionPerformed(evt);
            }
        });
        jPanel13.add(btnRemoveTeacherRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 90, 30));

        btnRemoveTeacherShow.setBackground(new java.awt.Color(255, 255, 204));
        btnRemoveTeacherShow.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnRemoveTeacherShow.setText("Show");
        btnRemoveTeacherShow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemoveTeacherShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveTeacherShowActionPerformed(evt);
            }
        });
        jPanel13.add(btnRemoveTeacherShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 90, 30));

        showRemoveT.setBackground(new java.awt.Color(255, 255, 255));
        showRemoveT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        showRemoveT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        showRemoveT.add(profileTeacherPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 120, 110));

        profileTeacherDob.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        showRemoveT.add(profileTeacherDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 300, 30));

        profileTeacherId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        showRemoveT.add(profileTeacherId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 300, 30));

        profileTeacherEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        showRemoveT.add(profileTeacherEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 300, 30));

        profileTeacherAge.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        showRemoveT.add(profileTeacherAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 300, 30));

        profileTeacherGender.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        showRemoveT.add(profileTeacherGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 300, 30));

        jPanel13.add(showRemoveT, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 500, 450));

        btnRemoveTeacherReset.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnRemoveTeacherReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        btnRemoveTeacherReset.setText("Reset");
        btnRemoveTeacherReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemoveTeacherReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveTeacherResetActionPerformed(evt);
            }
        });
        jPanel13.add(btnRemoveTeacherReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 110, 40));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        mainTabPane.addTab("remove_T", jPanel8);

        jPanel14.setBackground(new java.awt.Color(239, 239, 239));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backRemoveStudent.setBackground(new java.awt.Color(204, 255, 153));
        backRemoveStudent.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        backRemoveStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/previous.png"))); // NOI18N
        backRemoveStudent.setText("Back");
        backRemoveStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backRemoveStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backRemoveStudentActionPerformed(evt);
            }
        });
        jPanel14.add(backRemoveStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 120, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel15.setText("Staff Id:");
        jPanel14.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 80, 30));
        jPanel14.add(txtRemoveStaffId, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 220, 30));

        btnRemoveStaffShow.setBackground(new java.awt.Color(255, 255, 204));
        btnRemoveStaffShow.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnRemoveStaffShow.setText("Show");
        btnRemoveStaffShow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemoveStaffShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveStaffShowActionPerformed(evt);
            }
        });
        jPanel14.add(btnRemoveStaffShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 90, 30));

        btnRemoveStaffRemove.setBackground(new java.awt.Color(255, 204, 204));
        btnRemoveStaffRemove.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnRemoveStaffRemove.setText("Remove");
        btnRemoveStaffRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemoveStaffRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveStaffRemoveActionPerformed(evt);
            }
        });
        jPanel14.add(btnRemoveStaffRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 90, 30));

        showRemoveS.setBackground(new java.awt.Color(255, 255, 255));
        showRemoveS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        showRemoveS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        showRemoveS.add(profileStaffPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 120, 110));

        profileStaffDob.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        showRemoveS.add(profileStaffDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 300, 30));

        profileStaffId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        showRemoveS.add(profileStaffId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 300, 30));

        profileStaffEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        showRemoveS.add(profileStaffEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 300, 30));

        profileStaffAge.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        showRemoveS.add(profileStaffAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 300, 30));

        profileStaffGender.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        showRemoveS.add(profileStaffGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 300, 30));

        jPanel14.add(showRemoveS, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 500, 450));

        btnRemoveStaffReset.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnRemoveStaffReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        btnRemoveStaffReset.setText("Reset");
        btnRemoveStaffReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemoveStaffReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveStaffResetActionPerformed(evt);
            }
        });
        jPanel14.add(btnRemoveStaffReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 110, 40));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        mainTabPane.addTab("remove_S", jPanel9);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backResetPass.setBackground(new java.awt.Color(204, 255, 153));
        backResetPass.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        backResetPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/previous.png"))); // NOI18N
        backResetPass.setText("Back");
        backResetPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backResetPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backResetPassActionPerformed(evt);
            }
        });
        jPanel15.add(backResetPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 120, 40));

        jPanel18.setBackground(new java.awt.Color(241, 255, 250));
        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel16.setText("New Password");

        txtNewPassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewPasswordActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel17.setText("Old Password");

        txtOldPassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnResetPasswordNew.setBackground(new java.awt.Color(255, 255, 204));
        btnResetPasswordNew.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btnResetPasswordNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset_pass.png"))); // NOI18N
        btnResetPasswordNew.setText("Reset");
        btnResetPasswordNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResetPasswordNew.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnResetPasswordNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetPasswordNewActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel18.setText("User Name");

        txtUsername1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnResetPasswordNew, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addGap(12, 12, 12)
                .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnResetPasswordNew, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jPanel15.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 360, 420));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel21.setText("Reset Your Password");
        jPanel15.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 210, 40));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/image-1020x560.jpg"))); // NOI18N
        jPanel15.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1020, 560));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainTabPane.addTab("reset_Pass", jPanel10);

        jPanel3.add(mainTabPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1020, 590));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1020, 560));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTeacherActionPerformed
        // TODO add your handling code here:
        mainTabPane.setSelectedIndex(1);
    }//GEN-LAST:event_btnAddTeacherActionPerformed

    private void btnAddStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStaffActionPerformed
        // TODO add your handling code here:
        mainTabPane.setSelectedIndex(2);
    }//GEN-LAST:event_btnAddStaffActionPerformed

    private void btnRemoveTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveTeacherActionPerformed
        // TODO add your handling code here:
        mainTabPane.setSelectedIndex(3);
    }//GEN-LAST:event_btnRemoveTeacherActionPerformed

    private void btnRemoveStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveStudentActionPerformed
        // TODO add your handling code here:
        mainTabPane.setSelectedIndex(4);
    }//GEN-LAST:event_btnRemoveStudentActionPerformed

    private void backAddTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backAddTeacherActionPerformed
        // TODO add your handling code here:
        mainTabPane.setSelectedIndex(0);
    }//GEN-LAST:event_backAddTeacherActionPerformed

    private void backAddStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backAddStaffActionPerformed
        // TODO add your handling code here:
         mainTabPane.setSelectedIndex(0);
    }//GEN-LAST:event_backAddStaffActionPerformed

    private void backRemoveTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backRemoveTeacherActionPerformed
        // TODO add your handling code here:
         mainTabPane.setSelectedIndex(0);
    }//GEN-LAST:event_backRemoveTeacherActionPerformed

    private void backRemoveStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backRemoveStudentActionPerformed
        // TODO add your handling code here:
         mainTabPane.setSelectedIndex(0);
    }//GEN-LAST:event_backRemoveStudentActionPerformed

    private void backResetPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backResetPassActionPerformed
        // TODO add your handling code here:
         mainTabPane.setSelectedIndex(0);
    }//GEN-LAST:event_backResetPassActionPerformed

    private void btnTeacherChoosePicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeacherChoosePicActionPerformed
        // TODO add your handling code here:
        
        JFileChooser fileChooser=new JFileChooser();
           FileNameExtensionFilter fnef=new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
           fileChooser.addChoosableFileFilter(fnef);
           
           int showOpenDialogue=fileChooser.showOpenDialog(null);
           
           if(showOpenDialogue ==JFileChooser.APPROVE_OPTION){
               File selectedImageFile=fileChooser.getSelectedFile();
               String selectedImagePath=selectedImageFile.getAbsolutePath();
               JOptionPane.showMessageDialog(null, selectedImagePath);
               
               //Display the selected image on a jLabel
               
               ImageIcon imageIcon=new ImageIcon(selectedImagePath);
               Image image=imageIcon.getImage().getScaledInstance(chooseTeacherPic.getWidth(), chooseTeacherPic.getHeight(), Image.SCALE_SMOOTH);
               chooseTeacherPic.setIcon(new ImageIcon(image));
               
               teacherData.setTeacherPicturePath(selectedImagePath);
    }//GEN-LAST:event_btnTeacherChoosePicActionPerformed
    }
    
    
    
    
    
    
    private void btnStaffAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffAddActionPerformed
        // TODO add your handling code here:
        
        
        String gender="";
        if(staffRadioMale.isSelected()){
            gender="Male";
        }
        else if(staffRadioFemale.isSelected()){
            gender="Female";
        }
        
        staffData.setStaffId(txtStaffId.getText());
        staffData.setEmail(txtStaffEmail.getText());
        staffData.setAge(Integer.parseInt(txtStaffAge.getText()));
        staffData.setGender(gender);
        staffData.setDob(DateToSqlDate(staffDate.getDate()));
        
        DbCon databaseConnection=new DbCon();
        
        databaseConnection.saveStaffDataToDatabase(staffData);
        
         //resetStaff();
         resetStaff();
        
        JOptionPane.showMessageDialog(mainTabPane, "Staff Succesflly Added");
        
        
        
        
    }//GEN-LAST:event_btnStaffAddActionPerformed

    private void btnTeacherAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeacherAddActionPerformed
        // TODO add your handling code here:
        String gender="";
        if(teacherRadioMale.isSelected()){
            gender="Male";
        }
        else if(teacherRadioFemale.isSelected()){
            gender="Female";
        }
        
        teacherData.setTeacherId(txtTeacherId.getText());
        teacherData.setEmail(txtTeacherEmail.getText());
        teacherData.setAge(Integer.parseInt(txtTeacherAge.getText()));
        teacherData.setGender(gender);
        teacherData.setDob(DateToSqlDate(teacherDate.getDate()));
        
        
        
        
        
        //Track trackMenu=new Track(sixoptions);
        
        
//        DbCon databaseConnection=new DbCon();
//        databaseConnection.saveTeacherDataToDatabase(teacherData);
//        JOptionPane.showMessageDialog(this, "payment Confirmed ","Confirmation",JOptionPane.INFORMATION_MESSAGE);
        
        DbCon databaseConnection=new DbCon();
        
        databaseConnection.saveTeacherDataToDatabase(teacherData);
        Track trackmenu=new Track(sixoptions);
        trackmenu.updateTeacherTable();
        resetTeacher();
        
        JOptionPane.showMessageDialog(mainTabPane, "Teacher Successully Added");
    }//GEN-LAST:event_btnTeacherAddActionPerformed

    private void btnStaffChoosePicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffChoosePicActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser=new JFileChooser();
           FileNameExtensionFilter fnef=new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
           fileChooser.addChoosableFileFilter(fnef);
           
           int showOpenDialogue=fileChooser.showOpenDialog(null);
           
           if(showOpenDialogue ==JFileChooser.APPROVE_OPTION){
               File selectedImageFile=fileChooser.getSelectedFile();
               String selectedImagePath=selectedImageFile.getAbsolutePath();
               JOptionPane.showMessageDialog(null, selectedImagePath);
               
               //Display the selected image on a jLabel
               
               ImageIcon imageIcon=new ImageIcon(selectedImagePath);
               Image image=imageIcon.getImage().getScaledInstance(chooseStaffPic.getWidth(), chooseStaffPic.getHeight(), Image.SCALE_SMOOTH);
               chooseStaffPic.setIcon(new ImageIcon(image));
               
               staffData.setStaffPicturePath(selectedImagePath);
        
    }//GEN-LAST:event_btnStaffChoosePicActionPerformed
    }
    private void resetStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetStaffActionPerformed
        // TODO add your handling code here:
        resetStaff();
    }//GEN-LAST:event_resetStaffActionPerformed

    private void resetTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetTeacherActionPerformed
        // TODO add your handling code here:
        resetTeacher();
    }//GEN-LAST:event_resetTeacherActionPerformed

    private void btnRemoveTeacherShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveTeacherShowActionPerformed
        // TODO add your handling code here:
        
        String teacherId=txtRemoveTeacherId.getText();
        
        TeacherData teacherData=retrieveTeacherData(teacherId);
        
        if(teacherData !=null){
            profileTeacherId.setText("Teacher Id : "+teacherData.getTeacherId());
            profileTeacherEmail.setText("Email : "+teacherData.getEmail());
            profileTeacherAge.setText("Age : "+teacherData.getAge());
            profileTeacherGender.setText("Gender : "+teacherData.getGender());
            profileTeacherDob.setText("Dob : "+teacherData.getDob());
            
            
            
            ImageIcon imageIcon=new ImageIcon(teacherData.getTeacherPicturePath());
            Image image=imageIcon.getImage().getScaledInstance(profileTeacherPic.getWidth(), profileTeacherPic.getHeight(), Image.SCALE_SMOOTH);
            profileTeacherPic.setIcon(new ImageIcon(image));
                    
        }
        else{
            JOptionPane.showMessageDialog(mainTabPane, "No Teacher Data Found");
        }
        
    }//GEN-LAST:event_btnRemoveTeacherShowActionPerformed

    private void btnRemoveTeacherRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveTeacherRemoveActionPerformed
        // TODO add your handling code here:
        
        String teacherIdToDelete=txtRemoveTeacherId.getText();
        if (teacherIdToDelete.isEmpty()) {
        JOptionPane.showMessageDialog(mainTabPane, "Please enter a Teacher ID to delete.");
         }
        else{
        DbCon databaseConnection=new DbCon();
        databaseConnection.deleteTeacher(teacherIdToDelete);
        JOptionPane.showMessageDialog(mainTabPane, "Teacher id "+ teacherIdToDelete+" has been deleted");
        resetRemoveTeacher();
        }
        
    }//GEN-LAST:event_btnRemoveTeacherRemoveActionPerformed

    private void btnRemoveTeacherResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveTeacherResetActionPerformed
        // TODO add your handling code here:
        resetRemoveTeacher();
        
    }//GEN-LAST:event_btnRemoveTeacherResetActionPerformed

    private void btnRemoveStaffShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveStaffShowActionPerformed
        // TODO add your handling code here:
        
        String staffId=txtRemoveStaffId.getText();
        
        StaffData staffData=retrieveStaffData(staffId);
        
        if(staffData !=null){
            profileStaffId.setText("Staff Id : "+staffData.getStaffId());
            profileStaffEmail.setText("Email : "+staffData.getEmail());
            profileStaffAge.setText("Age : "+staffData.getAge());
            profileStaffGender.setText("Gender : "+staffData.getGender());
            profileStaffDob.setText("Dob : "+staffData.getDob());
            
            
            
            ImageIcon imageIcon=new ImageIcon(staffData.getStaffPicturePath());
            Image image=imageIcon.getImage().getScaledInstance(profileStaffPic.getWidth(), profileStaffPic.getHeight(), Image.SCALE_SMOOTH);
            profileStaffPic.setIcon(new ImageIcon(image));
                    
        }
        else{
            JOptionPane.showMessageDialog(mainTabPane, "No Staff Data Found");
        }
    }//GEN-LAST:event_btnRemoveStaffShowActionPerformed

    private void btnRemoveStaffResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveStaffResetActionPerformed
        // TODO add your handling code here:
        
        resetRemoveStaff();
    }//GEN-LAST:event_btnRemoveStaffResetActionPerformed

    private void btnRemoveStaffRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveStaffRemoveActionPerformed
        // TODO add your handling code here:
        
        String StaffIdtoDelete=txtRemoveStaffId.getText();
        if (StaffIdtoDelete.isEmpty()) {
        JOptionPane.showMessageDialog(mainTabPane, "Please enter a staff ID to delete.");
    }
        else{
        DbCon databaseConnection=new DbCon();
        databaseConnection.deleteStaff(StaffIdtoDelete);
        JOptionPane.showMessageDialog(mainTabPane, "Staff id "+ StaffIdtoDelete+" has been deleted");
        resetRemoveStaff();
        }
    }//GEN-LAST:event_btnRemoveStaffRemoveActionPerformed

    private void btnResetPass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPass1ActionPerformed
        // TODO add your handling code here:
        mainTabPane.setSelectedIndex(5);
    }//GEN-LAST:event_btnResetPass1ActionPerformed

    private void btnResetPasswordNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPasswordNewActionPerformed
        // TODO add your handling code here:
        
        if( txtUsername1.getText().isEmpty() || txtOldPassword.getText().isEmpty() || txtNewPassword.getText().isEmpty() ){
            JOptionPane.showMessageDialog(this, "Field cannot Be Empty");
            return;
        }
         
        
        
        String username=txtUsername1.getText();
        String oldPassword=txtOldPassword.getText();
        String newPassword=txtNewPassword.getText();
        
        model.Login login=new model.Login(username, oldPassword);
        
        DbCon dbCon=new DbCon();
         boolean passwordResetSuccessful = dbCon.resetPassword(login, newPassword);
        
      if (passwordResetSuccessful) {
            JOptionPane.showMessageDialog(mainTabPane, "Password Reset Successfull You Are about to LOG OUT");
            resetPassworduserName();
            this.dispose();
            Login loginPage=new Login();
            loginPage.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(mainTabPane, "password Reset Failed");
            resetPassworduserName();
        }
    }//GEN-LAST:event_btnResetPasswordNewActionPerformed

    private void btnMainTabHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainTabHomeActionPerformed
        // TODO add your handling code here:
        this.dispose();
        sixoptions.setVisible(true);
        
    }//GEN-LAST:event_btnMainTabHomeActionPerformed

    private void txtNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewPasswordActionPerformed
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Sixoptions sixoptions=new Sixoptions();
               Admin admin=new Admin(sixoptions);
               admin.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backAddStaff;
    private javax.swing.JButton backAddTeacher;
    private javax.swing.JButton backRemoveStudent;
    private javax.swing.JButton backRemoveTeacher;
    private javax.swing.JButton backResetPass;
    private javax.swing.JButton btnAddStaff;
    private javax.swing.JButton btnAddTeacher;
    private javax.swing.JButton btnMainTabHome;
    private javax.swing.JButton btnRemoveStaffRemove;
    private javax.swing.JButton btnRemoveStaffReset;
    private javax.swing.JButton btnRemoveStaffShow;
    private javax.swing.JButton btnRemoveStudent;
    private javax.swing.JButton btnRemoveTeacher;
    private javax.swing.JButton btnRemoveTeacherRemove;
    private javax.swing.JButton btnRemoveTeacherReset;
    private javax.swing.JButton btnRemoveTeacherShow;
    private javax.swing.JButton btnResetPass1;
    private javax.swing.JButton btnResetPasswordNew;
    private javax.swing.JButton btnStaffAdd;
    private javax.swing.JButton btnStaffChoosePic;
    private javax.swing.JButton btnTeacherAdd;
    private javax.swing.JButton btnTeacherChoosePic;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel chooseStaffPic;
    private javax.swing.JLabel chooseTeacherPic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane mainTabPane;
    private javax.swing.JLabel profileStaffAge;
    private javax.swing.JLabel profileStaffDob;
    private javax.swing.JLabel profileStaffEmail;
    private javax.swing.JLabel profileStaffGender;
    private javax.swing.JLabel profileStaffId;
    private javax.swing.JLabel profileStaffPic;
    private javax.swing.JLabel profileTeacherAge;
    private javax.swing.JLabel profileTeacherDob;
    private javax.swing.JLabel profileTeacherEmail;
    private javax.swing.JLabel profileTeacherGender;
    private javax.swing.JLabel profileTeacherId;
    private javax.swing.JLabel profileTeacherPic;
    private javax.swing.JButton resetStaff;
    private javax.swing.JButton resetTeacher;
    private javax.swing.JPanel showRemoveS;
    private javax.swing.JPanel showRemoveT;
    private com.toedter.calendar.JDateChooser staffDate;
    private javax.swing.JRadioButton staffRadioFemale;
    private javax.swing.JRadioButton staffRadioMale;
    private com.toedter.calendar.JDateChooser teacherDate;
    private javax.swing.JRadioButton teacherRadioFemale;
    private javax.swing.JRadioButton teacherRadioMale;
    private javax.swing.JTextField txtNewPassword;
    private javax.swing.JTextField txtOldPassword;
    private javax.swing.JTextField txtRemoveStaffId;
    private javax.swing.JTextField txtRemoveTeacherId;
    private javax.swing.JTextField txtStaffAge;
    private javax.swing.JTextField txtStaffEmail;
    private javax.swing.JTextField txtStaffId;
    private javax.swing.JTextField txtTeacherAge;
    private javax.swing.JTextField txtTeacherEmail;
    private javax.swing.JTextField txtTeacherId;
    private javax.swing.JTextField txtUsername1;
    // End of variables declaration//GEN-END:variables
}
