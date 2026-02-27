package amanidrummond;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<BankAccount> accounts = new ArrayList<>();

        accounts.add(new CheckingAccount("Jordan", "001", 500.00, 500.00,
                 5.00));
        accounts.add(new SavingsAccount("Jordan", "002", 1000.00, 0.02));
        accounts.add(new CreditAccount("Jordan", "003",300.00, 500.00, 0.03));

        accounts.get(0).withdraw(50);
        accounts.get(1).deposit(25);
        accounts.get(2).withdraw(100);

        System.out.println("--- BEFORE MONTHLY UPDATE ---");
        printSummaries(accounts);

        for (BankAccount acct : accounts) {
            acct.monthlyUpdate();
        }

        System.out.println("\n--- AFTER MONTHLY UPDATE ---");
        printSummaries(accounts);
    }
    private static void printSummaries(ArrayList<BankAccount> accounts) {
        for (BankAccount acct : accounts) {
            System.out.println(acct.getSummary());
        }
    }
}