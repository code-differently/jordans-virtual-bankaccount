package mesheikbrown;

public class Main {

    public static void main(String[] args) {

        // 1) Create accounts (objects)
        CheckingAccount checking = new CheckingAccount(
                "Mesheik Brown", 1001, 200.00,
                300.00, 15.00
        );

        SavingsAccount savings = new SavingsAccount(
                "Mesheik Brown", 2001, 1000.00,
                0.02   // 2% monthly interest (example)
        );

        InvestmentAccount invest = new InvestmentAccount(
                "Mesheik Brown", 3001, 500.00,
                0.05,  // 5% monthly growth (example)
                0.10   // 10% withdrawal penalty (example)
        );


        // 2) Print starting summaries
        System.out.println("===== STARTING BALANCES =====");
        checking.printSummary();
        System.out.println();
        savings.printSummary();
        System.out.println();
        invest.printSummary();
        System.out.println();


        // 3) Do some transactions (deposit / withdraw)
        System.out.println("===== TRANSACTIONS =====");

        checking.deposit(50);
        checking.withdraw(25);
        System.out.println();

        savings.deposit(200);
        savings.withdraw(100);
        System.out.println();

        invest.deposit(100);
        invest.withdraw(200); // will include penalty in your override
        System.out.println();


        // 4) Run monthly updates (fees, interest, growth)
        System.out.println("===== MONTHLY UPDATES =====");

        checking.monthlyUpdate();  // may charge fee if below minimum
        System.out.println();

        savings.monthlyUpdate();   // adds interest
        System.out.println();

        invest.monthlyUpdate();    // adds growth
        System.out.println();


        // 5) Print ending summaries
        System.out.println("===== ENDING BALANCES =====");
        checking.printSummary();
        System.out.println();
        savings.printSummary();
        System.out.println();
        invest.printSummary();
    }

}
