
package model;

import java.sql.Date;


public class StaffData {
    private String staffId;
    private String email;
    private int age;
    private String gender;
    private Date dob;
    private String staffPicturePath;

    public StaffData() {
    }

    public StaffData(String staffId, String email, int age, String gender, Date dob, String staffPicturePath) {
        this.staffId = staffId;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.dob = dob;
        this.staffPicturePath = staffPicturePath;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Date getDob() {
        return dob;
    }

    public String getStaffPicturePath() {
        return staffPicturePath;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setStaffPicturePath(String staffPicturePath) {
        this.staffPicturePath = staffPicturePath;
    }

    
    
    
    
}
