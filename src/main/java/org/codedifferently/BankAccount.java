package org.codedifferently;

import java.util.Scanner;

public abstract class BankAccount {
    protected String customerFirstName;
    protected String customerLastName;
    protected int acctNumber;
    protected double acctBalance;
    protected Customer customer;
    protected String acctType;
    Scanner sc = new Scanner(System.in);

    public BankAccount() {
    }
    public BankAccount(Customer person, int acctNumber) {
        this.customerFirstName = Customer.firstName;
        this.customerLastName = Customer.lastName;
    }

    public BankAccount(Customer person, int acctNumber, double acctBalance){
        this.customerFirstName= Customer.firstName;
        this.customerLastName= Customer.lastName;
        this.acctNumber= person.getAcctNumber();
        this.acctBalance=acctBalance;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public double getAcctBalance() {
        return acctBalance;
    }

    public void setAcctBalance(double acctBalance) {
        this.acctBalance = acctBalance;
    }

    public int getAcctNumber() {
        return acctNumber;
    }

    public void setAcctNumber(int acctNumber) {
        this.acctNumber = acctNumber;
    }

    public void depositFunds(int acct, String acctType){
        System.out.println("How much money are you depositing?");
        double deposit=sc.nextDouble();
        acctBalance+=deposit;
        setAcctBalance(acctBalance);
        System.out.println("Your deposit has been processed!"+"\n Your new balance is: "+acctBalance);
    }

    public void withdrawFunds(int acctNum, String acctType) {
        System.out.println("How much money are you withdrawing?");
        double withdraw=sc.nextDouble();
        if (getAcctBalance() < withdraw) {
            System.out.println("Insufficient funds. Please try again");
        } else {
            this.acctBalance -= withdraw;
            setAcctBalance(this.acctBalance);
        }

    }

    public void printSummary(){
        System.out.println("======ACCOUNT SUMMARY======");
        System.out.println("Customer name: "+this.customerFirstName+" "+this.customerLastName);
        System.out.println("Account #: "+this.getAcctNumber());
        System.out.println("Account Balance: $"+ this.getAcctBalance());
    }
    public void printMonthlyStatement(){
        System.out.println("======MONTHLY STATEMENT======");
        System.out.println("Customer name: "+this.customerFirstName+" "+this.customerLastName);
        System.out.println("Account #: "+this.getAcctNumber());
        System.out.println("Account Balance: $"+ this.getAcctBalance());
    }









}
