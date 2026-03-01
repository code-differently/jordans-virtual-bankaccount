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

    public void printAccountSummaries() {
        System.out.println("=====" + getFirstName() + " " + getLastName() + "'s active accounts." + "=====");
        for (int i = 0; i < Customer.this.bankAccounts.size(); i++) {
            System.out.println("Account number: " + this.bankAccounts.get(i).getAcctNumber());
            System.out.println("Account type: " + this.bankAccounts.get(i).getAcctType());
            System.out.println("Balance: $" + this.bankAccounts.get(i).getAcctBalance());
            System.out.println("========================================");
            System.out.println(" ");
        }
    }

    public void depositFunds(int acctNumber, String acctType) {
        System.out.println("How much money are you depositing?");
        double deposit = sc.nextDouble();
        this.acctBalance += deposit;
        bankAccount.setAcctBalance(deposit);
        System.out.println("Your deposit has been processed!" + "\n Your new "+ acctType+ "balance is: " + acctBalance);

    }

    public void withdrawFunds(int acctNumber, String acctType) {
        System.out.println("How much money are you depositing?");
        double withdraw = sc.nextDouble();
        if (this.acctBalance < withdraw) {
            System.out.println("Insufficient funds. Please try again");
        } else {
            acctBalance -= withdraw;
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

