/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.StudentData;
import util.DbCon;

/**
 *
 * @author imran
 */
public final class Track extends javax.swing.JFrame {

    /**
     * Creates new form Track
     */
    private Sixoptions sixoptions;
    private Date selectDate;
    //private Date selecDate1;
    
    public Track(Sixoptions sixoptions) {
        
        setUndecorated(true);
        initComponents();
        
        
      selectDate = new Date(WIDTH); // This initializes it with the current date and time
      //selecDate1=new Date(WIDTH);
    
    //getAllStudent();
    //getAllTeacherData();
    //getAllStaffData();
    
   // showStdAttendence(selectDate);      //this line for show messege no data found in stdAttence 
        
        this.setLocationRelativeTo(null);
        this.sixoptions=sixoptions;
        
//        staffTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
//staffTable.getTableHeader().setOpaque(false);
//staffTable.getTableHeader().setBackground(new Color(255, 0, 0)); 
//staffTable.getTableHeader().setForeground(new Color(255, 255, 255));
//staffTable.setRowHeight(24);


// Customize cell rendering


          DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
         headerRenderer.setBackground(new Color(173, 246, 230));

for (int i = 0; i < staffTable.getModel().getColumnCount(); i++) {
        staffTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
}

    }
    
    
//    for update teacher table
    
    public void updateTeacherTable(){
        DefaultTableModel model=(DefaultTableModel) teacherTable.getModel();
        model.setRowCount(0);
        //getAllTeacherData();
        //model.fireTableDataChanged();
    }
    
    
    public void resetStudentAttendence(){
        
        DefaultTableModel model=(DefaultTableModel)studentTable.getModel();
        
//        for(int row =0; row<model.getRowCount();row++){
//            model.setValueAt(false, row, 3);
//            model.setValueAt(null, row, 4);
//        }
         model.setRowCount(0);
        
        //for repaint the table
        studentTable.repaint();
    }
    
    
    public void resetTeacherAttendence(){
        DefaultTableModel model=(DefaultTableModel)teacherTable.getModel();
        
        model.setRowCount(0);
    }
    
    
    public void resetStaffAttendence(){
        DefaultTableModel model=(DefaultTableModel)staffTable.getModel();
        model.setRowCount(0);
    }
        
    
    
    public void resetStdTable(){
        DefaultTableModel model = (DefaultTableModel) studentTableShow.getModel();
        model.setRowCount(0);
        
        DefaultTableModel modelPresent=(DefaultTableModel) tablePresentStd.getModel();
        modelPresent.setRowCount(0);
        
        DefaultTableModel modelAbsent=(DefaultTableModel) tableAbsentStd.getModel();
        modelAbsent.setRowCount(0);
        
        
        txtPresent.setText("");
        txtAbsent.setText("");
        txtTotalStd.setText("");
        showDate.setText("");
        btnStdDate.setDate(null);
    }
    
    
    public void resetTeacherTable(){
         DefaultTableModel model = (DefaultTableModel) teacherTableShow.getModel();
        model.setRowCount(0);
        
        DefaultTableModel modelPresent=(DefaultTableModel) tablePresentTeacher.getModel();
        modelPresent.setRowCount(0);
        
        DefaultTableModel modelAbsent=(DefaultTableModel) tableAbsentTeacher.getModel();
        modelAbsent.setRowCount(0);
        
        
        txtPresentTeacher.setText("");
        txtAbsentTeacher.setText("");
        txtTotalTeacher.setText("");
        showDateTeacher.setText("");
        btnTeacherDate.setDate(null);
    }
    
    
    
        public void resetStaffTable(){
         DefaultTableModel model = (DefaultTableModel) staffTableShow.getModel();
        model.setRowCount(0);
        
        DefaultTableModel modelPresent=(DefaultTableModel) tablePresentStaff.getModel();
        modelPresent.setRowCount(0);
        
        DefaultTableModel modelAbsent=(DefaultTableModel) tableAbsentStaff.getModel();
        modelAbsent.setRowCount(0);
        
        
        txtPresentStaff.setText("");
        txtAbsentStaff.setText("");
        txtTotalStaff.setText("");
        showDateStaff.setText("");
        btnStaffDate.setDate(null);
    }
    
    
    
    DbCon con=new DbCon();
    
    PreparedStatement ps;
    String sql="";
    ResultSet rs;
    
    
    
   

    
    
    
    //String[] studentColumnName={"Trainee Id","Batch Id","Name","Gender","Address","Dob","Age","Attendence"};
    String[] studentColumnName={"Roll","Class","Name","Attendence","Date"};
    
    public void getAllStudent(int selectedClass){
        sql="select *from studentdata where stdClass=?";
        
//        DefaultTableModel model=(DefaultTableModel) studentTable.getModel();
//        model.setRowCount(0);

       DefaultTableModel model = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 3) { // 7 is the index of the "Attendence" column
                    return Boolean.class; // Set the class of "Attendence" column to Boolean (for checkboxes)
                }
                return super.getColumnClass(columnIndex);
            }
        };

        
        //DefaultTableModel model=new DefaultTableModel();
        model.setColumnIdentifiers(studentColumnName);
        studentTable.setModel(model);
        
        try {
            ps=con.getCon().prepareStatement(sql);
            ps.setInt(1, selectedClass);
            rs=ps.executeQuery();
            
            while (rs.next()){
                int roll=rs.getInt("roll");
                int stdClass=rs.getInt("stdClass");
                String name=rs.getString("name");
                
//                String gender=rs.getString("gender");
//                String address=rs.getString("address");
//                Date showDate=rs.getDate("dob");
//                int age=rs.getInt("age");
                
                boolean attendanceStatus=false;
                
                //boolean attendenceStatus=deter
                //model.addRow(new Object[]{traineeId,batchId,name,gender,address,showDate,age,attendanceStatus});
                model.addRow(new Object[]{roll,stdClass,name,attendanceStatus});
                
                
            }
            ps.close();
            con.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Track.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
    
    
    
    String[] showStdColumnName={ "Roll","Class","Name","Attendence","Date"};
    
//    String[] showPresent={"Batch Id","Attendence"};
//    String[] showAbsent={"Batch Id","Attendence"};
    
//    DefaultTableModel presentTableModel=new DefaultTableModel();
//    DefaultTableModel absentTableModel=new DefaultTableModel();
    
    public void showStdAttendence(Date selectDate , int selectedClass1){





      DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(showStdColumnName);
    studentTableShow.setModel(model);

    DefaultTableModel presentModel = new DefaultTableModel();
    presentModel.addColumn("Roll");
    presentModel.addColumn("Status");
    
    tablePresentStd.setModel(presentModel);

    DefaultTableModel absentModel = new DefaultTableModel();
    absentModel.addColumn("Roll");
    absentModel.addColumn("Status");
    tableAbsentStd.setModel(absentModel);
    
    int presentCount=0;
    int absentCount=0;

    try {
        sql = "select * from std_attendence1 WHERE date = ? and stdClass=?";
        ps = con.getCon().prepareStatement(sql);

        ps.setDate(1, new java.sql.Date(selectDate.getTime()));
        ps.setInt(2, selectedClass1);
        rs = ps.executeQuery();

        boolean dataFound = false;

        while (rs.next()) {
            dataFound = true;

            int traineeId = rs.getInt("roll");
            String batchId = rs.getString("stdClass");
            String name = rs.getString("name");
            boolean attendance = rs.getBoolean("attendance");
            Date showDate = rs.getDate("date");

            // Convert boolean attendance to "Present" or "Absent"
            String attendanceStatus = attendance ? "Present" : "Absent";

            model.addRow(new Object[]{traineeId, batchId, name, attendanceStatus, showDate});

            if (attendance) {
                presentModel.addRow(new Object[]{batchId,attendanceStatus});
                presentCount++;
            } else {
                absentModel.addRow(new Object[]{batchId,attendanceStatus});
                absentCount++;
            }
        }
        
        int total=presentCount+absentCount;

        ps.close();
        con.getCon().close();

        if (!dataFound) {
            JOptionPane.showMessageDialog(rootPane, "No data found in the selected date.");
            showDate.setText(selectDate.toString());
        }
        else{
            
            showDate.setText(selectDate.toString());
             txtPresent.setText("Present : " +presentCount);
             txtAbsent.setText("Absent : "+absentCount);
             txtTotalStd.setText("Total : "+total);
            
        }
    } catch (SQLException ex) {
        Logger.getLogger(Track.class.getName()).log(Level.SEVERE, null, ex);
    }
            
    }
    
    
    
    //for checkTeacher Attendence
    
     String[] teacherColumnName1={"Teacher Id","Email","Attendence","Date"};
    
    public void showTeacherAttendence(Date selectDate){
        
        DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(teacherColumnName1);
    teacherTableShow.setModel(model);

    DefaultTableModel presentModel = new DefaultTableModel();
    presentModel.addColumn("Teacher Id");
    presentModel.addColumn("Status");
    
    tablePresentTeacher.setModel(presentModel);

    DefaultTableModel absentModel = new DefaultTableModel();
    absentModel.addColumn("Teacher Id");
    absentModel.addColumn("Status");
    tableAbsentTeacher.setModel(absentModel);
    
    int presentCount=0;
    int absentCount=0;

    try {
        sql = "select * from teacher_attendence WHERE date = ?";
        ps = con.getCon().prepareStatement(sql);

        ps.setDate(1, new java.sql.Date(selectDate.getTime()));
        rs = ps.executeQuery();

        boolean dataFound = false;

        while (rs.next()) {
            dataFound = true;

            int teacherId = rs.getInt("teacherId");
            String name = rs.getString("email");
           
            boolean attendance = rs.getBoolean("attendence");
            Date showDate = rs.getDate("date");

            // Convert boolean attendance to "Present" or "Absent"
            String attendanceStatus = attendance ? "Present" : "Absent";

            model.addRow(new Object[]{teacherId, name, attendanceStatus, showDate});

            if (attendance) {
                presentModel.addRow(new Object[]{teacherId,attendanceStatus});
                presentCount++;
            } else {
                absentModel.addRow(new Object[]{teacherId,attendanceStatus});
                absentCount++;
            }
        }
        
        int total=presentCount+absentCount;

        ps.close();
        con.getCon().close();

        if (!dataFound) {
            JOptionPane.showMessageDialog(rootPane, "No data found in the selected date.");
            showDateTeacher.setText(selectDate.toString());
        }
        else{
            
            showDateTeacher.setText(selectDate.toString());
             txtPresentTeacher.setText("Present : " +presentCount);
             txtAbsentTeacher.setText("Absent : "+absentCount);
             txtTotalTeacher.setText("Total : "+total);
            
        }
    } catch (SQLException ex) {
        Logger.getLogger(Track.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
    
    
    
    //for Staff Attendence
    
    String[] staffColumnName1={"Staff Id","Email","Attendence","Date"};
    
    public void showStaffAttendence(Date selectDate){
        
        DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(staffColumnName1);
    staffTableShow.setModel(model);

    DefaultTableModel presentModel = new DefaultTableModel();
    presentModel.addColumn("Staff Id");
    presentModel.addColumn("Status");
    
    tablePresentStaff.setModel(presentModel);

    DefaultTableModel absentModel = new DefaultTableModel();
    absentModel.addColumn("Staff Id");
    absentModel.addColumn("Status");
    tableAbsentStaff.setModel(absentModel);
    
    int presentCount=0;
    int absentCount=0;

    try {
        sql = "select * from staff_attendence WHERE date = ?";
        ps = con.getCon().prepareStatement(sql);

        ps.setDate(1, new java.sql.Date(selectDate.getTime()));
        rs = ps.executeQuery();

        boolean dataFound = false;

        while (rs.next()) {
            dataFound = true;

            int staffId = rs.getInt("staffId");
            String name = rs.getString("email");
           
            boolean attendance = rs.getBoolean("attendence");
            Date showDate = rs.getDate("date");

            // Convert boolean attendance to "Present" or "Absent"
            String attendanceStatus = attendance ? "Present" : "Absent";

            model.addRow(new Object[]{staffId, name, attendanceStatus, showDate});

            if (attendance) {
                presentModel.addRow(new Object[]{staffId,attendanceStatus});
                presentCount++;
            } else {
                absentModel.addRow(new Object[]{staffId,attendanceStatus});
                absentCount++;
            }
        }
        
        int total=presentCount+absentCount;

        ps.close();
        con.getCon().close();

        if (!dataFound) {
            JOptionPane.showMessageDialog(rootPane, "No data found in the selected date.");
            showDateStaff.setText(selectDate.toString());
        }
        else{
            
            showDateStaff.setText(selectDate.toString());
             txtPresentStaff.setText("Present : " +presentCount);
             txtAbsentStaff.setText("Absent : "+absentCount);
             txtTotalStaff.setText("Total : "+total);
            
        }
    } catch (SQLException ex) {
        Logger.getLogger(Track.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
    
    
    
    
    
    
    //for teacher Table
    
    
    String[] teacherColumnName={"Teacher Id","Email","Attendence","Date"};
    
    
    public void getAllTeacherData(){
        sql="select *from teacherdata";
        
        
        
         DefaultTableModel model1 = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 2) { // 7 is the index of the "Attendence" column
                    return Boolean.class; // Set the class of "Attendence" column to Boolean (for checkboxes)
                }
                return super.getColumnClass(columnIndex);
            }
        };
        
       //DefaultTableModel model1=new DefaultTableModel();
        model1.setColumnIdentifiers(teacherColumnName);
        teacherTable.setModel(model1);
        
        try {
            ps=con.getCon().prepareStatement(sql);
            rs=ps.executeQuery();
            
            while (rs.next()){
                int teacherId=rs.getInt("teacherId");
                String name=rs.getString("email");
                boolean attendenceStatus=false;
                
                
                
               model1.addRow(new Object[]{teacherId,name,attendenceStatus});
                
                
            }
            ps.close();
            con.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Track.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
    
    
     String[] staffColumnName={"Staff Id","Email","Attendence","Date"};
     
    public void getAllStaffData(){
        sql="select *from staffdata";
        
        DefaultTableModel model2 = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 2) { // 7 is the index of the "Attendence" column
                    return Boolean.class; // Set the class of "Attendence" column to Boolean (for checkboxes)
                }
                return super.getColumnClass(columnIndex);
            }
        };
        
       
        model2.setColumnIdentifiers(staffColumnName);
        staffTable.setModel(model2);
        
        try {
            ps=con.getCon().prepareStatement(sql);
            rs=ps.executeQuery();
            
            while (rs.next()){
                int staffId=rs.getInt("staffId");
                String email=rs.getString("email");
                boolean attendenceStatus=false;
                
                
                
                
                model2.addRow(new Object[]{staffId,email,attendenceStatus});
                
                
            }
            ps.close();
            con.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Track.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
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
        jLabel1 = new javax.swing.JLabel();
        btnTrackHome = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        mainTab = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnTrackStd = new javax.swing.JButton();
        btnTrackTeacher = new javax.swing.JButton();
        btnTrackStaff = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        btnTrackStaff1 = new javax.swing.JButton();
        btnCheckTeacher = new javax.swing.JButton();
        bntCheckStaff = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        studentBack = new javax.swing.JButton();
        btnSaveStudentData = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtDate = new com.toedter.calendar.JDateChooser();
        btnLoad = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        stdClassComboBox = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        teacherBack = new javax.swing.JButton();
        btnSaveTeacherAttendence = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnLoadTable = new javax.swing.JButton();
        btnTeacherDateLoad = new com.toedter.calendar.JDateChooser();
        btnTeacherReset = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        teacherTable = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        staffTable = new javax.swing.JTable();
        staffBack = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtStaffDate = new com.toedter.calendar.JDateChooser();
        btnStaffLoad = new javax.swing.JButton();
        btnStaffReset = new javax.swing.JButton();
        btnSaveStaffAttendence = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        showDate = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        studentTableShow = new javax.swing.JTable();
        btnStdDate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        btnStudentAttendenceShow = new javax.swing.JButton();
        btnResetStdTable = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablePresentStd = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableAbsentStd = new javax.swing.JTable();
        txtAbsent = new javax.swing.JLabel();
        txtPresent = new javax.swing.JLabel();
        txtTotalStd = new javax.swing.JLabel();
        btnBackStudentCheck = new javax.swing.JButton();
        comboSelectedStudent = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        showDateTeacher = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        teacherTableShow = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablePresentTeacher = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableAbsentTeacher = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        btnTeacherDate = new com.toedter.calendar.JDateChooser();
        btnTeacherAttendenceShow = new javax.swing.JButton();
        btnResetTeacherTable = new javax.swing.JButton();
        txtPresentTeacher = new javax.swing.JLabel();
        txtAbsentTeacher = new javax.swing.JLabel();
        txtTotalTeacher = new javax.swing.JLabel();
        btnBackTeacherCheck = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        showDateStaff = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        staffTableShow = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        tablePresentStaff = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        tableAbsentStaff = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        btnStaffDate = new com.toedter.calendar.JDateChooser();
        btnStaffAttendenceShow = new javax.swing.JButton();
        btnResetStaffTable = new javax.swing.JButton();
        txtPresentStaff = new javax.swing.JLabel();
        txtAbsentStaff = new javax.swing.JLabel();
        txtTotalStaff = new javax.swing.JLabel();
        btnBackStaffCheck = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(60, 92, 72));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Track :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 130, 40));

        btnTrackHome.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnTrackHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/home-page.png"))); // NOI18N
        btnTrackHome.setText("Home");
        btnTrackHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTrackHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrackHomeActionPerformed(evt);
            }
        });
        jPanel2.add(btnTrackHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 120, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 60));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        btnTrackStd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTrackStd.setText("Student");
        btnTrackStd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrackStdActionPerformed(evt);
            }
        });

        btnTrackTeacher.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTrackTeacher.setText("Teacher");
        btnTrackTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrackTeacherActionPerformed(evt);
            }
        });

        btnTrackStaff.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTrackStaff.setText("Staff");
        btnTrackStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrackStaffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTrackStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrackTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrackStd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnTrackStd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnTrackTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnTrackStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel22.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 180, 330));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        btnTrackStaff1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTrackStaff1.setText("CheckStd");
        btnTrackStaff1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrackStaff1ActionPerformed(evt);
            }
        });

        btnCheckTeacher.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCheckTeacher.setText("CheckTcher");
        btnCheckTeacher.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCheckTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckTeacherActionPerformed(evt);
            }
        });

        bntCheckStaff.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bntCheckStaff.setText("CheckStaff");
        bntCheckStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCheckStaffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntCheckStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrackStaff1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheckTeacher, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnTrackStaff1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnCheckTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(bntCheckStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jPanel22.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 190, 330));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel16.setText("Take Attendence");
        jLabel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel22.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 66, 180, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setText("Check Attendence");
        jLabel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel22.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 66, 190, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/trackpage2.jpg"))); // NOI18N
        jPanel22.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 560));

        jPanel6.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 560));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainTab.addTab("Main", jPanel4);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        studentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(studentTable);

        jPanel8.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 640, 260));

        studentBack.setBackground(new java.awt.Color(0, 102, 0));
        studentBack.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        studentBack.setForeground(new java.awt.Color(255, 255, 255));
        studentBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/left.png"))); // NOI18N
        studentBack.setText("Back");
        studentBack.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        studentBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentBackActionPerformed(evt);
            }
        });
        jPanel8.add(studentBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 440, 110, 40));

        btnSaveStudentData.setBackground(new java.awt.Color(51, 178, 73));
        btnSaveStudentData.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnSaveStudentData.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveStudentData.setText("Save");
        btnSaveStudentData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveStudentDataActionPerformed(evt);
            }
        });
        jPanel8.add(btnSaveStudentData, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 130, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Date:");
        jPanel8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 60, 20));

        txtDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 130, 40));

        btnLoad.setBackground(new java.awt.Color(255, 204, 0));
        btnLoad.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/loading26x26.png"))); // NOI18N
        btnLoad.setText("Load");
        btnLoad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });
        jPanel8.add(btnLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 110, 40));

        btnReset.setBackground(new java.awt.Color(234, 33, 46));
        btnReset.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel8.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, 110, 40));

        jPanel25.setBackground(new java.awt.Color(188, 203, 201));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stdClassComboBox.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        stdClassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<--Select-->", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jPanel25.add(stdClassComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 110, 40));

        jPanel8.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 560));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainTab.addTab("Student", jPanel5);

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        teacherBack.setBackground(new java.awt.Color(0, 102, 0));
        teacherBack.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        teacherBack.setForeground(new java.awt.Color(255, 255, 255));
        teacherBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/left.png"))); // NOI18N
        teacherBack.setText("Back");
        teacherBack.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        teacherBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherBackActionPerformed(evt);
            }
        });
        jPanel11.add(teacherBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 410, 100, 40));

        btnSaveTeacherAttendence.setBackground(new java.awt.Color(51, 178, 73));
        btnSaveTeacherAttendence.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnSaveTeacherAttendence.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveTeacherAttendence.setText("Save");
        btnSaveTeacherAttendence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveTeacherAttendenceActionPerformed(evt);
            }
        });
        jPanel11.add(btnSaveTeacherAttendence, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 130, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Date:");
        jPanel11.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 70, 30));

        btnLoadTable.setBackground(new java.awt.Color(255, 204, 0));
        btnLoadTable.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnLoadTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/loading26x26.png"))); // NOI18N
        btnLoadTable.setText("Load");
        btnLoadTable.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLoadTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadTableActionPerformed(evt);
            }
        });
        jPanel11.add(btnLoadTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 110, 40));

        btnTeacherDateLoad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel11.add(btnTeacherDateLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 130, 40));

        btnTeacherReset.setBackground(new java.awt.Color(234, 33, 46));
        btnTeacherReset.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnTeacherReset.setForeground(new java.awt.Color(255, 255, 255));
        btnTeacherReset.setText("Reset");
        btnTeacherReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeacherResetActionPerformed(evt);
            }
        });
        jPanel11.add(btnTeacherReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, 120, 40));

        jPanel24.setBackground(new java.awt.Color(188, 203, 201));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        teacherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        teacherTable.setRowHeight(25);
        teacherTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teacherTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(teacherTable);

        jPanel24.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 680, 240));

        jPanel11.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 560));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainTab.addTab("Teacher", jPanel9);

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        staffTable.setBackground(new java.awt.Color(255, 255, 224));
        staffTable.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        staffTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        staffTable.setRowHeight(25);
        staffTable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        staffTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(staffTable);

        jPanel12.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 720, 260));

        staffBack.setBackground(new java.awt.Color(0, 102, 0));
        staffBack.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        staffBack.setForeground(new java.awt.Color(255, 255, 255));
        staffBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/left.png"))); // NOI18N
        staffBack.setText("Back");
        staffBack.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        staffBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffBackActionPerformed(evt);
            }
        });
        jPanel12.add(staffBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 440, 100, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Date:");
        jPanel12.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 60, 30));

        txtStaffDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel12.add(txtStaffDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 130, 40));

        btnStaffLoad.setBackground(new java.awt.Color(255, 204, 0));
        btnStaffLoad.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnStaffLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/loading26x26.png"))); // NOI18N
        btnStaffLoad.setText("Load");
        btnStaffLoad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnStaffLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffLoadActionPerformed(evt);
            }
        });
        jPanel12.add(btnStaffLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 100, 40));

        btnStaffReset.setBackground(new java.awt.Color(234, 33, 46));
        btnStaffReset.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnStaffReset.setForeground(new java.awt.Color(255, 255, 255));
        btnStaffReset.setText("Reset");
        btnStaffReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffResetActionPerformed(evt);
            }
        });
        jPanel12.add(btnStaffReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 100, 40));

        btnSaveStaffAttendence.setBackground(new java.awt.Color(51, 178, 73));
        btnSaveStaffAttendence.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnSaveStaffAttendence.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveStaffAttendence.setText("Save");
        btnSaveStaffAttendence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveStaffAttendenceActionPerformed(evt);
            }
        });
        jPanel12.add(btnSaveStaffAttendence, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 100, 40));

        jPanel26.setBackground(new java.awt.Color(180, 203, 201));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel12.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 560));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainTab.addTab("Staff", jPanel10);

        jPanel14.setBackground(new java.awt.Color(180, 203, 201));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Check Student Attendence");
        jPanel14.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 770, 60));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Date:");
        jPanel14.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 60, 30));

        showDate.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jPanel14.add(showDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 150, 30));

        jPanel15.setBackground(new java.awt.Color(180, 203, 201));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentTableShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(studentTableShow);

        jPanel15.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 360));

        btnStdDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel15.add(btnStdDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, 140, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Date:");
        jPanel15.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 50, 30));

        btnStudentAttendenceShow.setBackground(new java.awt.Color(51, 178, 73));
        btnStudentAttendenceShow.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnStudentAttendenceShow.setForeground(new java.awt.Color(255, 255, 255));
        btnStudentAttendenceShow.setText("Show");
        btnStudentAttendenceShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentAttendenceShowActionPerformed(evt);
            }
        });
        jPanel15.add(btnStudentAttendenceShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 90, 40));

        btnResetStdTable.setBackground(new java.awt.Color(234, 33, 36));
        btnResetStdTable.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnResetStdTable.setForeground(new java.awt.Color(255, 255, 255));
        btnResetStdTable.setText("Reset");
        btnResetStdTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetStdTableActionPerformed(evt);
            }
        });
        jPanel15.add(btnResetStdTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 90, 40));

        tablePresentStd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tablePresentStd);

        jPanel15.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 160, 350));

        tableAbsentStd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tableAbsentStd);

        jPanel15.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 160, 350));

        txtAbsent.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtAbsent.setForeground(new java.awt.Color(255, 0, 51));
        jPanel15.add(txtAbsent, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 370, 170, 30));

        txtPresent.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtPresent.setForeground(new java.awt.Color(51, 153, 0));
        jPanel15.add(txtPresent, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 180, 30));

        txtTotalStd.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jPanel15.add(txtTotalStd, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 430, 200, 30));

        btnBackStudentCheck.setBackground(new java.awt.Color(0, 102, 0));
        btnBackStudentCheck.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnBackStudentCheck.setForeground(new java.awt.Color(255, 255, 255));
        btnBackStudentCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/left.png"))); // NOI18N
        btnBackStudentCheck.setText("Back");
        btnBackStudentCheck.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBackStudentCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackStudentCheckActionPerformed(evt);
            }
        });
        jPanel15.add(btnBackStudentCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 430, 100, 40));

        comboSelectedStudent.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        comboSelectedStudent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-Select-->", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jPanel15.add(comboSelectedStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 110, 40));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel17.setText("Select Class");
        jPanel15.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 80, 20));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE))
        );

        mainTab.addTab("check", jPanel13);

        jPanel18.setBackground(new java.awt.Color(180, 203, 201));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(180, 203, 201));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Check Teacher Attendence");
        jPanel19.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 60));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Date:");
        jPanel19.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 60, 30));

        showDateTeacher.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jPanel19.add(showDateTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 150, 30));

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, -1));

        teacherTableShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(teacherTableShow);

        jPanel18.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 550, 360));

        tablePresentTeacher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(tablePresentTeacher);

        jPanel18.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 160, 350));

        tableAbsentTeacher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(tableAbsentTeacher);

        jPanel18.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 160, 350));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Date:");
        jPanel18.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 50, 30));

        btnTeacherDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel18.add(btnTeacherDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, 120, 40));

        btnTeacherAttendenceShow.setBackground(new java.awt.Color(51, 178, 73));
        btnTeacherAttendenceShow.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnTeacherAttendenceShow.setForeground(new java.awt.Color(255, 255, 255));
        btnTeacherAttendenceShow.setText("Show");
        btnTeacherAttendenceShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeacherAttendenceShowActionPerformed(evt);
            }
        });
        jPanel18.add(btnTeacherAttendenceShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, 90, 40));

        btnResetTeacherTable.setBackground(new java.awt.Color(234, 33, 36));
        btnResetTeacherTable.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnResetTeacherTable.setForeground(new java.awt.Color(255, 255, 255));
        btnResetTeacherTable.setText("Reset");
        btnResetTeacherTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetTeacherTableActionPerformed(evt);
            }
        });
        jPanel18.add(btnResetTeacherTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 90, 40));

        txtPresentTeacher.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtPresentTeacher.setForeground(new java.awt.Color(51, 153, 0));
        jPanel18.add(txtPresentTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 430, 180, 30));

        txtAbsentTeacher.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtAbsentTeacher.setForeground(new java.awt.Color(255, 0, 51));
        jPanel18.add(txtAbsentTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 430, 170, 30));

        txtTotalTeacher.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jPanel18.add(txtTotalTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 490, 200, 30));

        btnBackTeacherCheck.setBackground(new java.awt.Color(0, 102, 0));
        btnBackTeacherCheck.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnBackTeacherCheck.setForeground(new java.awt.Color(255, 255, 255));
        btnBackTeacherCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/left.png"))); // NOI18N
        btnBackTeacherCheck.setText("Back");
        btnBackTeacherCheck.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBackTeacherCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackTeacherCheckActionPerformed(evt);
            }
        });
        jPanel18.add(btnBackTeacherCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 480, 100, 40));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainTab.addTab("CheckT", jPanel16);

        jPanel20.setBackground(new java.awt.Color(180, 203, 201));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel21.setBackground(new java.awt.Color(180, 203, 201));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Check Staff Attendence");
        jPanel21.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 60));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Date:");
        jPanel21.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 60, 30));

        showDateStaff.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jPanel21.add(showDateStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 150, 30));

        jPanel20.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, -1));

        staffTableShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(staffTableShow);

        jPanel20.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 550, 360));

        tablePresentStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane11.setViewportView(tablePresentStaff);

        jPanel20.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 160, 350));

        tableAbsentStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane12.setViewportView(tableAbsentStaff);

        jPanel20.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 160, 350));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Date:");
        jPanel20.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, 50, 30));

        btnStaffDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel20.add(btnStaffDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 470, 120, 40));

        btnStaffAttendenceShow.setBackground(new java.awt.Color(51, 178, 73));
        btnStaffAttendenceShow.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnStaffAttendenceShow.setForeground(new java.awt.Color(255, 255, 255));
        btnStaffAttendenceShow.setText("Show");
        btnStaffAttendenceShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffAttendenceShowActionPerformed(evt);
            }
        });
        jPanel20.add(btnStaffAttendenceShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, 90, 40));

        btnResetStaffTable.setBackground(new java.awt.Color(234, 33, 36));
        btnResetStaffTable.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnResetStaffTable.setForeground(new java.awt.Color(255, 255, 255));
        btnResetStaffTable.setText("Reset");
        btnResetStaffTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetStaffTableActionPerformed(evt);
            }
        });
        jPanel20.add(btnResetStaffTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 470, 90, 40));

        txtPresentStaff.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtPresentStaff.setForeground(new java.awt.Color(51, 153, 0));
        jPanel20.add(txtPresentStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 430, 180, 30));

        txtAbsentStaff.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtAbsentStaff.setForeground(new java.awt.Color(255, 0, 51));
        jPanel20.add(txtAbsentStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 430, 170, 30));

        txtTotalStaff.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jPanel20.add(txtTotalStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 490, 200, 30));

        btnBackStaffCheck.setBackground(new java.awt.Color(0, 102, 0));
        btnBackStaffCheck.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnBackStaffCheck.setForeground(new java.awt.Color(255, 255, 255));
        btnBackStaffCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/left.png"))); // NOI18N
        btnBackStaffCheck.setText("Back");
        btnBackStaffCheck.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBackStaffCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackStaffCheckActionPerformed(evt);
            }
        });
        jPanel20.add(btnBackStaffCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 490, 100, 40));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 1041, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTab.addTab("CheckStaff", jPanel17);

        jPanel3.add(mainTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1050, 620));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1050, 590));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrackStdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrackStdActionPerformed
        // TODO add your handling code here:
        mainTab.setSelectedIndex(1);
    }//GEN-LAST:event_btnTrackStdActionPerformed

    private void btnTrackStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrackStaffActionPerformed
        // TODO add your handling code here:
        mainTab.setSelectedIndex(3);
    }//GEN-LAST:event_btnTrackStaffActionPerformed

    private void btnTrackTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrackTeacherActionPerformed
        // TODO add your handling code here:
        mainTab.setSelectedIndex(2);
    }//GEN-LAST:event_btnTrackTeacherActionPerformed

    private void studentBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentBackActionPerformed
        // TODO add your handling code here:
        mainTab.setSelectedIndex(0);
    }//GEN-LAST:event_studentBackActionPerformed

    private void teacherBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherBackActionPerformed
        // TODO add your handling code here:
        mainTab.setSelectedIndex(0);
    }//GEN-LAST:event_teacherBackActionPerformed

    private void staffBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffBackActionPerformed
        // TODO add your handling code here:
        mainTab.setSelectedIndex(0);
    }//GEN-LAST:event_staffBackActionPerformed

    private void teacherTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherTableMouseClicked
        // TODO add your handling code here:
        
//        int rowIndex=teacherTable.getSelectedRow();
//        
//        
//        String teacherId=teacherTable.getModel().getValueAt(rowIndex, 0).toString();
//        String email=teacherTable.getModel().getValueAt(rowIndex, 1).toString();
//        String age=teacherTable.getModel().getValueAt(rowIndex, 2).toString();
//        String gender=teacherTable.getModel().getValueAt(rowIndex, 3).toString();
//        String showDate=teacherTable.getModel().getValueAt(rowIndex, 4).toString();
        
        
    }//GEN-LAST:event_teacherTableMouseClicked

    private void studentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentTableMouseClicked
        // TODO add your handling code here:
        
//        int rowIndex=studentTable.getSelectedRow();
//        
//        
//        String teacherId=studentTable.getModel().getValueAt(rowIndex, 0).toString();
//        String email=studentTable.getModel().getValueAt(rowIndex, 1).toString();
//        String age=studentTable.getModel().getValueAt(rowIndex, 2).toString();
//        String gender=studentTable.getModel().getValueAt(rowIndex, 3).toString();
//        String showDate=studentTable.getModel().getValueAt(rowIndex, 4).toString();


//        int rowIndex = studentTable.getSelectedRow();
//    
//        String studentId = studentTable.getModel().getValueAt(rowIndex, 0).toString();
//        String batchId = studentTable.getModel().getValueAt(rowIndex, 1).toString();
//       String name = studentTable.getModel().getValueAt(rowIndex, 2).toString();
//    
//    ///it will asumme that  "Attendance" is a Boolean column (checkbox)
//        Boolean attendanceStatus = (Boolean) studentTable.getModel().getValueAt(rowIndex, 3);
    }//GEN-LAST:event_studentTableMouseClicked

    private void btnTrackHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrackHomeActionPerformed
        // TODO add your handling code here:
        this.dispose();
        sixoptions.setVisible(true);
        
    }//GEN-LAST:event_btnTrackHomeActionPerformed

    private void btnSaveStudentDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveStudentDataActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model=(DefaultTableModel) studentTable.getModel();
        
        for (int row = 0; row < model.getRowCount(); row++) {
        int roll = (int) model.getValueAt(row, 0);
        int stdClass = (int) model.getValueAt(row, 1);
        String name = (String) model.getValueAt(row, 2);
        boolean attendance = (boolean) model.getValueAt(row, 3);
        java.sql.Date date=(java.sql.Date) model.getValueAt(row, 4);
        
        // Call your saveStudentAttendance method to save the data
        
            saveStudentAttendance(roll, stdClass, name, attendance, date);
//            DbCon db=new DbCon();
//            db.saveStudentAttendance(traineeId, batchId, name, attendance);
        
        
        
    }//GEN-LAST:event_btnSaveStudentDataActionPerformed
      JOptionPane.showMessageDialog(rootPane, "data saved succesfully");
    
    }
    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
        //Date selectedDate =(Date) txtDate.getDate();
        
        if(txtDate.getDate()==null){
            JOptionPane.showMessageDialog(this, "Please select a date before load");
            return;
        }
        
        int selectedClass = Integer.parseInt(stdClassComboBox.getSelectedItem().toString());
       getAllStudent(selectedClass);
      java.util.Date selectedDate = txtDate.getDate();
    
    // Convert the selected date to a java.sql.Date
    java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());

    // Assuming you have a JTable named studentTable and the date column is at index 4
    int columnIndex = 4; // Adjust this index as needed based on your table structure

    DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
    
    // Iterate through all rows and set the date in the specified column
    for (int row = 0; row < model.getRowCount(); row++) {
        model.setValueAt(sqlDate, row, columnIndex);
    }
    
    // Repaint the table to reflect the changes
    studentTable.repaint();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetStudentAttendence();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnTrackStaff1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrackStaff1ActionPerformed
        // TODO add your handling code here:
        mainTab.setSelectedIndex(4);
    }//GEN-LAST:event_btnTrackStaff1ActionPerformed

    private void btnStudentAttendenceShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentAttendenceShowActionPerformed
        // TODO add your handling code here:
          // Check if a date is selected
          
          
           if(btnStdDate.getDate()==null){
            JOptionPane.showMessageDialog(this, "Please select a date before load");
            return;
        }
           
           int selectedClass1=Integer.parseInt(comboSelectedStudent.getSelectedItem().toString());
    java.util.Date selectedDate = btnStdDate.getDate();
    
    if (selectedDate != null) {
        // Convert the selected date to a java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
        
        // Call showStdAttendence with the selected date
        showStdAttendence(sqlDate,selectedClass1);
    } else {
        // Handle the case where no date is selected, e.g., show an error message.
        System.out.println("Select a valid date.");
    }
    }//GEN-LAST:event_btnStudentAttendenceShowActionPerformed

    private void btnResetStdTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetStdTableActionPerformed
        // TODO add your handling code here:
        resetStdTable();
    }//GEN-LAST:event_btnResetStdTableActionPerformed

    private void btnLoadTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadTableActionPerformed
        // TODO add your handling code here:
        
         if(btnTeacherDateLoad.getDate()==null){
            JOptionPane.showMessageDialog(this, "Please select a date before load");
            return;
        }
        
        
        getAllTeacherData();
        java.util.Date selectDate=btnTeacherDateLoad.getDate();
        java.sql.Date sqlDate=new Date(selectDate.getTime());
        int columnindex=3;
        
        DefaultTableModel model=(DefaultTableModel) teacherTable.getModel();
        for(int row=0; row<model.getRowCount();row++){
            model.setValueAt(sqlDate, row, columnindex);
        }
        teacherTable.repaint();
    }//GEN-LAST:event_btnLoadTableActionPerformed

    private void btnSaveTeacherAttendenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveTeacherAttendenceActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel)teacherTable.getModel();
        
        for(int row=0;row<model.getRowCount();row++){
            int teacherId=(int) model.getValueAt(row, 0);
            String email=(String) model.getValueAt(row, 1);
            boolean attendence=(boolean)model.getValueAt(row, 2);
            java.sql.Date date=(java.sql.Date)model.getValueAt(row, 3);
            
            saveTeacherAttendence(teacherId, email, attendence, date);
            
            
        }
        JOptionPane.showMessageDialog(rootPane, "Teacher Attendence Saved");
        resetTeacherAttendence();
    }//GEN-LAST:event_btnSaveTeacherAttendenceActionPerformed

    private void btnTeacherResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeacherResetActionPerformed
        // TODO add your handling code here:
        resetTeacherAttendence();
    }//GEN-LAST:event_btnTeacherResetActionPerformed

    private void btnStaffLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffLoadActionPerformed
        // TODO add your handling code here:
        
         if(txtStaffDate.getDate()==null){
            JOptionPane.showMessageDialog(this, "Please select a date before load");
            return;
        }
        
                  DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
         headerRenderer.setBackground(new Color(255, 255, 255));


       

        
        getAllStaffData();
        java.util.Date selectDate=txtStaffDate.getDate();
        java.sql.Date sqlDate=new Date(selectDate.getTime());
        
        int columnIndex=3;
        
        DefaultTableModel model=(DefaultTableModel)staffTable.getModel();
        
        for(int row=0;row<model.getRowCount();row++){
            model.setValueAt(sqlDate, row, columnIndex);
             staffTable.getColumnModel().getColumn(row).setHeaderRenderer(headerRenderer);
        }
        
        staffTable.repaint();
        
       
        
        
        
        
        
        
    }//GEN-LAST:event_btnStaffLoadActionPerformed

    private void btnSaveStaffAttendenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveStaffAttendenceActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model=(DefaultTableModel)staffTable.getModel();
        
        for(int row=0;row<model.getRowCount();row++){
            int staffId=(int) model.getValueAt(row, 0);
            String email=(String) model.getValueAt(row, 1);
            boolean attendence=(boolean)model.getValueAt(row, 2);
            java.sql.Date date=(java.sql.Date)model.getValueAt(row, 3);
            
            
            saveStaffAttendence(staffId, email, attendence, date);
            
        }
        JOptionPane.showMessageDialog(rootPane, "Staff Data Saved");
        resetStaffAttendence();
    }//GEN-LAST:event_btnSaveStaffAttendenceActionPerformed

    private void btnStaffResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffResetActionPerformed
        // TODO add your handling code here:
        resetStaffAttendence();
    }//GEN-LAST:event_btnStaffResetActionPerformed

    private void btnCheckTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckTeacherActionPerformed
        // TODO add your handling code here:
        mainTab.setSelectedIndex(5);
    }//GEN-LAST:event_btnCheckTeacherActionPerformed

    private void bntCheckStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCheckStaffActionPerformed
        // TODO add your handling code here:
        mainTab.setSelectedIndex(6);
    }//GEN-LAST:event_bntCheckStaffActionPerformed

    private void btnTeacherAttendenceShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeacherAttendenceShowActionPerformed
        // TODO add your handling code here:
        
        
        
        java.util.Date selectedDate = btnTeacherDate.getDate();
    
    if (selectedDate != null) {
        // Convert the selected date to a java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
        
        // Call showStdAttendence with the selected date
        showTeacherAttendence(sqlDate);
    } else {
        // Handle the case where no date is selected, e.g., show an error message.
        System.out.println("Select a valid date.");
    
    }  
    }//GEN-LAST:event_btnTeacherAttendenceShowActionPerformed

    private void btnResetTeacherTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetTeacherTableActionPerformed
        // TODO add your handling code here:
        resetTeacherTable();
    }//GEN-LAST:event_btnResetTeacherTableActionPerformed

    private void btnStaffAttendenceShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffAttendenceShowActionPerformed
        // TODO add your handling code here:
        java.util.Date selectedDate = btnStaffDate.getDate();
    
    if (selectedDate != null) {
        // Convert the selected date to a java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
        
        // Call showStdAttendence with the selected date
        showStaffAttendence(sqlDate);
    } else {
        // Handle the case where no date is selected, e.g., show an error message.
        System.out.println("Select a valid date.");
    
    }  
    }//GEN-LAST:event_btnStaffAttendenceShowActionPerformed

    private void btnResetStaffTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetStaffTableActionPerformed
        // TODO add your handling code here:
        resetStaffTable();
    }//GEN-LAST:event_btnResetStaffTableActionPerformed

    private void btnBackTeacherCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackTeacherCheckActionPerformed
        // TODO add your handling code here:
        mainTab.setSelectedIndex(0);
    }//GEN-LAST:event_btnBackTeacherCheckActionPerformed

    private void btnBackStudentCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackStudentCheckActionPerformed
        // TODO add your handling code here:
        mainTab.setSelectedIndex(0);
    }//GEN-LAST:event_btnBackStudentCheckActionPerformed

    private void btnBackStaffCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackStaffCheckActionPerformed
        // TODO add your handling code here:
        mainTab.setSelectedIndex(0);
    }//GEN-LAST:event_btnBackStaffCheckActionPerformed
    
    
    
    
    
    
    
    
    
    
    
    
    public void saveTeacherAttendence(int teacherId,String email,boolean attendence, Date date){
        String sql="insert into teacher_attendence (teacherId,email,attendence,date) values (?,?,?,?)";
        
        PreparedStatement ps;
        
        try {
            ps=con.getCon().prepareStatement(sql);
            ps.setInt(1, teacherId);
            ps.setString(2, email);
            ps.setBoolean(3, attendence);
            ps.setDate(4, date);
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Track.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
        
    }
    
    
    
    public void saveStaffAttendence(int staffId,String email,boolean attendence,Date date){
        
        String sql="insert into staff_attendence (staffId,email,attendence,date) values(?,?,?,?)";
        
        PreparedStatement ps;
        
        try {
            ps=con.getCon().prepareStatement(sql);
            ps.setInt(1, staffId);
            ps.setString(2, email);
            ps.setBoolean(3, attendence);
            ps.setDate(4, date);
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Track.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    public void saveStudentAttendance(int roll, int stdClass, String name, boolean attendance, Date date) {
        String sql = "insert into std_attendence1 (roll, stdClass, name, attendance,date) values (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement;
        
        try {
            preparedStatement = con.getCon().prepareStatement(sql);
            preparedStatement.setInt(1, roll);
            preparedStatement.setInt(2, stdClass);
            preparedStatement.setString(3, name);
            preparedStatement.setBoolean(4, attendance);
            preparedStatement.setDate(5, date);
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            //resetStudentAttendence();
        } catch (SQLException ex) {
            Logger.getLogger(Track.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        
    }
    
    
//    public void showAttedence(){
//       java.util.Date selectedDate = btnStdDate.getDate();
//    
//    if (selectedDate != null) {
//        java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
//        showStdAttendence(sqlDate); // Pass sqlDate instead of selectDate
//    } else {
//        System.out.println("Select a valid date.");
//    }
//
//        
//        
//        
//        
//    }
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
            java.util.logging.Logger.getLogger(Track.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Track.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Track.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Track.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Sixoptions sixoptions=new Sixoptions();
                Track track=new Track(sixoptions);
                track.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCheckStaff;
    private javax.swing.JButton btnBackStaffCheck;
    private javax.swing.JButton btnBackStudentCheck;
    private javax.swing.JButton btnBackTeacherCheck;
    private javax.swing.JButton btnCheckTeacher;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnLoadTable;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnResetStaffTable;
    private javax.swing.JButton btnResetStdTable;
    private javax.swing.JButton btnResetTeacherTable;
    private javax.swing.JButton btnSaveStaffAttendence;
    private javax.swing.JButton btnSaveStudentData;
    private javax.swing.JButton btnSaveTeacherAttendence;
    private javax.swing.JButton btnStaffAttendenceShow;
    private com.toedter.calendar.JDateChooser btnStaffDate;
    private javax.swing.JButton btnStaffLoad;
    private javax.swing.JButton btnStaffReset;
    private com.toedter.calendar.JDateChooser btnStdDate;
    private javax.swing.JButton btnStudentAttendenceShow;
    private javax.swing.JButton btnTeacherAttendenceShow;
    private com.toedter.calendar.JDateChooser btnTeacherDate;
    private com.toedter.calendar.JDateChooser btnTeacherDateLoad;
    private javax.swing.JButton btnTeacherReset;
    private javax.swing.JButton btnTrackHome;
    private javax.swing.JButton btnTrackStaff;
    private javax.swing.JButton btnTrackStaff1;
    private javax.swing.JButton btnTrackStd;
    private javax.swing.JButton btnTrackTeacher;
    private javax.swing.JComboBox<String> comboSelectedStudent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane mainTab;
    private javax.swing.JLabel showDate;
    private javax.swing.JLabel showDateStaff;
    private javax.swing.JLabel showDateTeacher;
    private javax.swing.JButton staffBack;
    private javax.swing.JTable staffTable;
    private javax.swing.JTable staffTableShow;
    private javax.swing.JComboBox<String> stdClassComboBox;
    private javax.swing.JButton studentBack;
    private javax.swing.JTable studentTable;
    private javax.swing.JTable studentTableShow;
    private javax.swing.JTable tableAbsentStaff;
    private javax.swing.JTable tableAbsentStd;
    private javax.swing.JTable tableAbsentTeacher;
    private javax.swing.JTable tablePresentStaff;
    private javax.swing.JTable tablePresentStd;
    private javax.swing.JTable tablePresentTeacher;
    private javax.swing.JButton teacherBack;
    private javax.swing.JTable teacherTable;
    private javax.swing.JTable teacherTableShow;
    private javax.swing.JLabel txtAbsent;
    private javax.swing.JLabel txtAbsentStaff;
    private javax.swing.JLabel txtAbsentTeacher;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JLabel txtPresent;
    private javax.swing.JLabel txtPresentStaff;
    private javax.swing.JLabel txtPresentTeacher;
    private com.toedter.calendar.JDateChooser txtStaffDate;
    private javax.swing.JLabel txtTotalStaff;
    private javax.swing.JLabel txtTotalStd;
    private javax.swing.JLabel txtTotalTeacher;
    // End of variables declaration//GEN-END:variables
}
