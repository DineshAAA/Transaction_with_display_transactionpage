package net.springboot.Transaction.Entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Transaction_Data")
public class TransactionData {

    @Override
    public String toString() {
        return "TransactionData{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", toAmount=" + toAmount +
                ", additionalFees=" + additionalFees +
                ", totalAmount=" + totalAmount +
                ", transactionDate=" + transactionDate +
                ", transactionMode='" + transactionMode + '\'' +
                ", fromCurrency='" + fromCurrency + '\'' +
                ", toCurrency='" + toCurrency + '\'' +
                ", accountStatus=" + accountStatus +
                '}';
    }

    @Id
    @Column(name = "Transaction_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Username")
    @NotEmpty(message = "Username cannot be empty...")
    @Size(min = 5, max = 250)
    private String userName;

    @Column(name= "Transaction_Amount")
    @NotNull(message = "Transaction_Amount cannot be empty...")
    private Double transactionAmount;


    @Column(name= "To_Amount",scale = 4)
    private Double  toAmount;

    @Column(name= "Additional_Fees")
    private Double  additionalFees;

    @Column(name= "Total_Amount")
    private Double  totalAmount;

    @Temporal(TemporalType.DATE)
    @Column(name= "Transaction_Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date transactionDate;

    @Column(name="Transaction_Mode")
    private String transactionMode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name="Transaction_Currency_From")
    private String fromCurrency;

    @Column(name="Transaction_Currency_To")
    private String toCurrency ="USD";


    @Column(name="Status")
    private Boolean accountStatus;


    @Column(name= "Tax_Amount")
    private Double taxAmount;

    public Double getTaxpercentage() {
        return taxpercentage;
    }

    public void setTaxpercentage(Double taxpercentage) {
        this.taxpercentage = taxpercentage;
    }

    @Column(name= "Tax_Percentage")
    private Double taxpercentage;


    public Double getTaxAmount() {
        return taxAmount;
    }

    public Double setTaxAmount(Double taxAmount) {
        return this.taxAmount = taxAmount;
    }



    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public Double getToAmount() {
        return toAmount;
    }

    public Double setToAmount(Double toAmount) {
        this.toAmount = toAmount;
        return toAmount;
    }

    public Double  getAdditionalFees() {
        return additionalFees;
    }

    public void setAdditionalFees(Double  additionalFees) {
        this.additionalFees = additionalFees;
    }

    public Double  getTotalAmount() {
        return totalAmount;
    }

    public Double  setTotalAmount(Double  totalAmount) {
        return this.totalAmount = totalAmount;
    }

    public String getTransactionMode() {
        return transactionMode;
    }

    public void setTransactionMode(String transactionMode) {
        this.transactionMode = transactionMode;
    }

    public Boolean getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Boolean accountStatus) {
        this.accountStatus = accountStatus;
    }


    public Double  getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double  transactionAmount) {
        this.transactionAmount = transactionAmount;
    }


    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }



    public TransactionData(long id, Double  transactionAmount, Double  toAmount, Double  additionalFees,
                           Double  totalAmount, Date transactionDate, String transactionMode, String fromCurrency, String toCurrency,
                           Boolean accountStatus, Double taxAmount,Double taxPercentage,String userName) {
        super();
        this.id = id;
        this.transactionAmount = transactionAmount;
        this.toAmount = toAmount;
        this.additionalFees = additionalFees;
        this.totalAmount = totalAmount;
        this.transactionDate = transactionDate;
        this.transactionMode = transactionMode;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.accountStatus = accountStatus;
        this.taxAmount = taxAmount;
        this.taxpercentage = taxPercentage;
        this.userName = userName;
    }

    public TransactionData(){

    }
}