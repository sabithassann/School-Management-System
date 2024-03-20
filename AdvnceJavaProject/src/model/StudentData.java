
package model;

import java.sql.Date;


public class StudentData {
    private int roll;
    private int stdClass;
    private String name;
    private String lastName;
    private String fathersName;
    private String mothersName;
    private String address;
    private String gender;
    private Date dob;
    private int age;
    private String picturePath;
    private String accountNumber;
    private double amount;
    private Date paymentDate;
    private String cardName;
    private String paymentMethod;

    public StudentData() {
    }

    public StudentData(int roll, int stdClass, String name, String lastName, String fathersName, String mothersName, String address, String gender, Date dob, int age, String picturePath, String accountNumber, double amount, Date paymentDate, String cardName, String paymentMethod) {
        this.roll = roll;
        this.stdClass = stdClass;
        this.name = name;
        this.lastName = lastName;
        this.fathersName = fathersName;
        this.mothersName = mothersName;
        this.address = address;
        this.gender = gender;
        this.dob = dob;
        this.age = age;
        this.picturePath = picturePath;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.cardName = cardName;
        this.paymentMethod = paymentMethod;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getStdClass() {
        return stdClass;
    }

    public void setStdClass(int stdClass) {
        this.stdClass = stdClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    

    
    
    
    
    
    
    
    

    
    
    
}
