package org.codedifferently;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Customer {
    static String firstName;
    static String lastName;
    static Random r = new Random();
    private int acctNumber;
    protected double acctBalance;
    Scanner sc = new Scanner(System.in);
    String[] acctTypes = {"Checking Account","Savings Account","Brokerage Account"};

    BankAccount bankAccount = new BankAccount() {
    };
    CheckingAccount chkAcct = new CheckingAccount();
    SavingsAccount savAcct = new SavingsAccount();
    BrokerageAccount brkAcct= new BrokerageAccount();

    ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    Customer(String firstName, String lastName) {
        Customer.firstName = firstName;
        Customer.lastName = lastName;
        acctNumber = r.nextInt(100000000, 999999999);
    }

    Customer(String firstName, String lastName, int acctNumber) {
        Customer.firstName = firstName;
        Customer.lastName = lastName;
        this.acctNumber = acctNumber;
    }

    public int getAcctNumber() {
        return acctNumber;
    }

    public void setAcctNumber(int acctNumber) {
        this.acctNumber = acctNumber;
    }

    public void getCustomerSummary() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Account #: " + firstName + " " + lastName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        Customer.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        Customer.firstName = firstName;
    }

    public static Customer createNewCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Freddy's FirstTrust Financial");
        System.out.println("Enter your first name: ");
        firstName = sc.nextLine();
        System.out.println("Enter your first name: ");
        lastName = sc.nextLine();
        return new Customer(firstName, lastName);
    }

    public void printAccountSummaries(Customer customer) {
        System.out.println("=====" + getFirstName() + " " + getLastName() + "'s active accounts." + "=====");
        //for (int i = 0; i < Customer.this.bankAccounts.size(); i++) {
            System.out.println("Account number: " + customer.getAcctNumber());
            System.out.println("Account type: " + customer.acctTypes[0]);
            System.out.println("Balance: $" + customer.chkAcct.getAcctBalance());
            System.out.println("========================================");
        System.out.println("Account number: " + customer.getAcctNumber());
        System.out.println("Account type: " + customer.acctTypes[1]);
        System.out.println("Balance: $" + customer.savAcct.getAcctBalance());
        System.out.println("========================================");
        System.out.println("Account number: " + customer.getAcctNumber());
        System.out.println("Account type: " + customer.acctTypes[2]);
        System.out.println("Balance: $" + customer.brkAcct.getAcctBalance());
        System.out.println("========================================");

            System.out.println(" ");
        //}
    }

    public void depositFunds(Customer customer, String acctType) {
        System.out.println("How much money are you depositing?");
        double deposit = sc.nextDouble();
        switch (acctType) {
            case "Checking Account" -> {
                double balance = customer.chkAcct.getAcctBalance() + deposit;
                customer.chkAcct.setAcctBalance(balance);
                System.out.println("Your Checking Account balance is now:"+ balance);
            }
        case "Savings Account" -> {
            double balance = customer.savAcct.getAcctBalance() + deposit;
            customer.savAcct.setAcctBalance(balance);
            System.out.println("Your Savings Account balance is now:"+ balance);
        }
            case "Brokerage Account" -> {
                    double balance = customer.brkAcct.getAcctBalance() + deposit;
                    customer.brkAcct.setAcctBalance(balance);
                System.out.println("Your Brokerage Account balance is now:"+ balance);
            }
        }
    }

    public void withdrawFunds(Customer customer, String acctType) {
        System.out.println("How much money are you withdrawing?");
        double withdraw = sc.nextDouble();
        switch (acctType) {
            case "Checking Account" -> {
                if (customer.chkAcct.getAcctBalance() < withdraw) {
                    System.out.println("Insufficient funds. Please try again");
                } else {
                    double balance = customer.savAcct.getAcctBalance() - withdraw;
                    customer.chkAcct.setAcctBalance(balance);
                }
            }
            case "Savings Account" -> {
                if (customer.savAcct.getAcctBalance() < withdraw) {
                    System.out.println("Insufficient funds. Please try again");
                } else {
                    double balance = customer.savAcct.getAcctBalance() - withdraw;
                    customer.savAcct.setAcctBalance(balance);
                }
            }
            case "Brokerage Account" -> {
                if (customer.brkAcct.getAcctBalance() < withdraw) {
                    System.out.println("Insufficient funds. Please try again");
                } else {
                    double balance = customer.brkAcct.getAcctBalance() - withdraw;
                    customer.brkAcct.setAcctBalance(balance);
                }
            }
        }
    }

    public String selectAccount() {
        boolean valid=false;
        String acctType = null;
        do {
            System.out.println("Which account will you be depositing funds?");
            System.out.println("1. Checking Account\n2. Savings Account\n3. Brokerage Account\n4. Exit");
            int acctSelection = sc.nextInt();
            if (acctSelection > 0 && acctSelection < acctTypes.length) {
                acctType = acctTypes[acctSelection-1];
                System.out.println(acctType+" has been selected.");
                valid=true;
                break;
            } else if (acctSelection==4){
                break;
            }
                else {
                System.out.println("Invalid selection. Please try again.");
            }
        } while (!valid);
        return acctType;
    }
}

