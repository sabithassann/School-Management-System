
package model;

import java.sql.Date;


public class ConfirmPaymentData {
    private String accountNumber;
    private Date paymentDate;
    private String cityCode;
    private String cardName;

    public ConfirmPaymentData() {
    }

    public ConfirmPaymentData(String accountNumber, Date paymentDate, String cityCode, String cardName) {
        this.accountNumber = accountNumber;
        this.paymentDate = paymentDate;
        this.cityCode = cityCode;
        this.cardName = cardName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getCardName() {
        return cardName;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
    
    
}
