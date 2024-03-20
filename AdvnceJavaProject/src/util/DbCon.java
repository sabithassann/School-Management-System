
package util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Login;
import model.StaffData;
import model.StudentData;
import model.TeacherData;
import view.Track;

public class DbCon {
    private Connection con=null;
    private String url="jdbc:mysql://localhost:3306/test";
    private String userName="root";
    private String passWord="sabit@1234";
    private String driver="com.mysql.cj.jdbc.Driver";
    
    public Connection getCon(){
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url, userName, passWord);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    
    
    public void saveStudentDataToDatabase(StudentData studentData ){
       
        
         
        try {
          con =getCon();
          String sql="insert into studentdata (roll,stdClass,name, lastName, fathersName, mothersName, address, gender, dob, age, picturePath, accountNumber,amount,paymentDate,cardName,paymentMethod) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
          PreparedStatement  pstm = con.prepareStatement(sql);
          
          pstm.setInt(1, studentData.getRoll());
          pstm.setInt(2, studentData.getStdClass());
          pstm.setString(3, studentData.getName());
          pstm.setString(4, studentData.getLastName());
          pstm.setString(5, studentData.getFathersName());
          pstm.setString(6, studentData.getMothersName());
          pstm.setString(7, studentData.getAddress());
          pstm.setString(8, studentData.getGender());
          pstm.setDate(9, studentData.getDob());
          pstm.setInt(10, studentData.getAge());
          pstm.setString(11, studentData.getPicturePath());
          pstm.setString(12, studentData.getAccountNumber());
          pstm.setDouble(13, studentData.getAmount());
          pstm.setDate(14, studentData.getPaymentDate());
          pstm.setString(15, studentData.getCardName());
          pstm.setString(16, studentData.getPaymentMethod());
          
          pstm.executeUpdate();
          con.close();
          
          
        } catch (SQLException ex) {
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    
    
    public void saveTeacherDataToDatabase(TeacherData teacherData){
        
        
        try {
            
        con=getCon();
        String sql="insert into teacherdata (teacherId, email, age, gender,dob,teacherPicturePath) "
                + "values (?,?,?,?,?,?)";
            PreparedStatement pstm=con.prepareStatement(sql);
            
            pstm.setString(1, teacherData.getTeacherId());
            pstm.setString(2, teacherData.getEmail());
            pstm.setInt(3, teacherData.getAge());
            pstm.setString(4, teacherData.getGender());
            pstm.setDate(5, teacherData.getDob());
            pstm.setString(6, teacherData.getTeacherPicturePath());
            
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void saveStaffDataToDatabase(StaffData staffData){
      
        
        try {
        con=getCon();
        String sql="insert into staffdata (staffId,email,age,gender,dob,staffPicturePath) "
                +"values (?,?,?,?,?,?)";
            
            PreparedStatement pstm=con.prepareStatement(sql);
            
            pstm.setString(1, staffData.getStaffId());
            pstm.setString(2, staffData.getEmail());
            pstm.setInt(3, staffData.getAge());
            pstm.setString(4, staffData.getGender());
            pstm.setDate(5, staffData.getDob());
            pstm.setString(6, staffData.getStaffPicturePath());
            
            pstm.executeUpdate();
             
            
        } catch (SQLException ex) {
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void deleteTeacher(String teacherId) {
        try (Connection con = getCon();
             PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM teacherdata WHERE teacherId = ?")) {
            preparedStatement.setString(1, teacherId);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Teacher data with ID " + teacherId + " deleted successfully.");
            } else {
                System.out.println("No teacher data found with ID " + teacherId + ".");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
     public void deleteStaff(String staffId) {
        try (Connection con = getCon();
             PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM staffdata WHERE staffId = ?")) {
            preparedStatement.setString(1, staffId);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Staff data with ID " + staffId + " deleted successfully.");
            } else {
                System.out.println("No teacher data found with ID " + staffId + ".");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
     
     
//     public void insertLogin(String username,String password){
//         Connection con=getCon();
//         PreparedStatement pstmt=null;
//         
//         
//         
//        try {
//            String sql="insert into login (username,password) values(?,?)";
//            pstmt=con.prepareStatement(sql);
//            
//            pstmt.setString(1, username);
//            pstmt.setString(2, password);
//            
//            pstmt.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE, null, ex);
//        }
//     }
     
     public void insertLogin(Login login) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
       
       
        try {
            con=getCon();
       String insertQuery = "INSERT INTO login (username, password) VALUES (?, ?)";
            pstmt=con.prepareStatement(insertQuery);
            pstmt.setString(1, login.getUserName());
            pstmt.setString(2, login.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE, null, ex);
        }
}
     
     
     public boolean resetPassword(Login login, String newPassword) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        
        
        
        try {
            
            con = getCon();
            System.out.println("Username: " + login.getUserName());
        System.out.println("Old Password: " + login.getPassword());
            // Check if the provided username and old password exist in the login table
            String checkQuery = "SELECT * FROM login WHERE username = ? AND password = ?";
            pstmt = con.prepareStatement(checkQuery);
            pstmt.setString(1, login.getUserName());
            pstmt.setString(2, login.getPassword());
            resultSet = pstmt.executeQuery();
            
            
            if (resultSet.next()) {
                // Username and old password match a record in the login table
                
                // Update the password with the new password
                String updateQuery = "UPDATE login SET password = ? WHERE username = ?";
                pstmt = con.prepareStatement(updateQuery);
                pstmt.setString(1, newPassword);
                pstmt.setString(2, login.getUserName());
                pstmt.executeUpdate();
                
                return true; // Password reset successful
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false; // Password reset failed
     }
     
     
     public boolean checkLogin(String username, String password) {
         
         Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet resultSet = null;
        try {
            
            
            con = getCon();
            String checkQuery = "SELECT * FROM login WHERE username = ? AND password = ?";
            pstmt = con.prepareStatement(checkQuery);
            pstmt.setString(1, username);
           pstmt.setString(2, password);
        resultSet = pstmt.executeQuery();
        return resultSet.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
                
     }
     
     
     
     public void saveStudentAttendance(int traineeId,String batchId,String name,boolean attendance){
         String sql="insert into std_attendance (traineeId,batchId,name,attendance) values (?,?,?,?)";
         PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, traineeId);
            preparedStatement.setString(2, batchId);
            preparedStatement.setString(3, name);
            preparedStatement.setBoolean(4, attendance);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE, null, ex);
        }
            
     }
     
     
     
     public StudentData getStudentData(int roll, int stdClass){
        
            Connection con=getCon();
            StudentData studentData=null;
        try {
            String query = "SELECT * FROM studentdata WHERE roll = ? AND stdClass = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setInt(1, roll);
            preparedStatement.setInt(2, stdClass);
            
            ResultSet resultSet=preparedStatement.executeQuery();
            
            if (resultSet.next()) {
            studentData = new StudentData();
            // Populate the StudentData object with data from the database
            studentData.setRoll(resultSet.getInt("roll"));
            studentData.setStdClass(resultSet.getInt("stdClass"));
            // Set other fields similarly
        }
        } catch (SQLException ex) {
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studentData;
     }
     
     
}
