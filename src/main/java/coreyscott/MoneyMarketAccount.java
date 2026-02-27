package coreyscott;

    public class MoneyMarketAccount extends BankAccount {

        private static final double INTEREST_RATE = 0.04; // 4%
        private static final int WITHDRAWAL_LIMIT = 3;
        private static final double EXCESS_WITHDRAWAL_FEE = 15;
        private static final double MIN_BALANCE_FOR_INTEREST = 1000;

        private int withdrawalsThisMonth;

        public MoneyMarketAccount(String owner, String accountNumber, double balance) {
            super(owner, accountNumber, balance);
            this.withdrawalsThisMonth = 0;
        }

        @Override
        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                withdrawalsThisMonth++;
                return true;
            }
            return false;
        }

        @Override
        public void monthlyUpdate() {

            // Apply interest only if minimum balance met
            if (balance >= MIN_BALANCE_FOR_INTEREST) {
                balance += balance * INTEREST_RATE;
            }

            // Apply fee if withdrawal limit exceeded
            if (withdrawalsThisMonth > WITHDRAWAL_LIMIT) {
                balance -= EXCESS_WITHDRAWAL_FEE;
            }

            // Reset withdrawal counter for next month
            withdrawalsThisMonth = 0;
        }
    }

