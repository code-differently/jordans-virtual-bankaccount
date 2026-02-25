package org.codedifferently;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CheckingAccount checking = new CheckingAccount(5000.0,"Derwin");

        SavingsAccount saving = new SavingsAccount(10000.0, "Derwin");

        checking.bankSummary();
        saving.bankSummary();

    }
}