package org.codedifferently;

public class CheckingAccount extends BankAccount{
    double overdraftFee= 10;
    String acctType= "Checking Account";

    public CheckingAccount(Customer person, int acctNumber, double acctBalance) {
        super(person, acctNumber, acctBalance);
    }

    public CheckingAccount() {

    }

    @Override
    public void depositFunds(int acct, String acctType) {
        super.depositFunds(acct, acctType);
    }

    @Override
    public void withdrawFunds(int acctNum, String acctType) {
        super.withdrawFunds(acctNum, acctType);
    }

    @Override
    public Customer getCustomer() {
        return super.getCustomer();
    }

    @Override
    public void setCustomer(Customer customer) {
        super.setCustomer(customer);
    }

    public CheckingAccount(Customer person, int acctNumber) {
        super(person, acctNumber);
    }

    @Override
    public void setCustomerFirstName(String customerFirstName) {
        super.setCustomerFirstName(customerFirstName);
    }

    @Override
    public String getCustomerLastName() {
        return super.getCustomerLastName();
    }

    @Override
    public void setCustomerLastName(String customerLastName) {
        super.setCustomerLastName(customerLastName);
    }

    @Override
    public double getAcctBalance() {
        return super.getAcctBalance();
    }

    @Override
    public void setAcctBalance(double acctBalance) {
        super.setAcctBalance(acctBalance);
    }

    @Override
    public int getAcctNumber() {
        return super.getAcctNumber();
    }

    @Override
    public void setAcctNumber(int acctNumber) {
        super.setAcctNumber(acctNumber);
    }


    @Override
    public void printSummary() {
    }

    @Override
    public void printMonthlyStatement() {
        super.printMonthlyStatement();
    }

    @Override
    public String getCustomerFirstName() {
        return super.getCustomerFirstName();
    }

    public double getOverdraftFee() {
        return overdraftFee;
    }

    public void setOverdraftFee(double overdraftFee) {
        this.overdraftFee = overdraftFee;
    }

    @Override
    public String getAcctType() {
        return acctType;
    }

    @Override
    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }
}
