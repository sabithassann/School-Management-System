
package model;

import java.sql.Date;


public class TeacherData {
    private String teacherId;
    private String email;
    private int age;
    private String gender;
    private Date dob;
    private String teacherPicturePath;

    public TeacherData() {
    }

    public TeacherData(String teacherId, String email, int age, String gender, Date dob, String teacherPicturePath) {
        this.teacherId = teacherId;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.dob = dob;
        this.teacherPicturePath = teacherPicturePath;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getTeacherPicturePath() {
        return teacherPicturePath;
    }

    public void setTeacherPicturePath(String teacherPicturePath) {
        this.teacherPicturePath = teacherPicturePath;
    }
    
    
    

}