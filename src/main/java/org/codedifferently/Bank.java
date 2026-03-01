package org.codedifferently;

import java.util.ArrayList;

    public class Bank {

        private ArrayList<BaseAccount> accounts;

        public Bank() {
            accounts = new ArrayList<>();
        }

        public void addAccount(BaseAccount account) {
            accounts.add(account);
        }

        public void printAllAccounts() {
            for (BaseAccount account : accounts) {
                account.accountSummary();   // POLYMORPHISM
                System.out.println();
            }
        }

        public void runMonthlyUpdates() {
            for (BaseAccount account : accounts) {
                account.monthlyUpdate();    // POLYMORPHISM
            }
        }
        public void transfer(int fromAccountNumber, int toAccountNumber, double amount) {

            BaseAccount fromAccount = findAccount(fromAccountNumber);
            BaseAccount toAccount = findAccount(toAccountNumber);

            if (fromAccount == null || toAccount == null) {
                System.out.println("One or both accounts not found.");
                return;
            }

            if (fromAccount instanceof TransferFunds) {
                ((TransferFunds) fromAccount).transfer(toAccount, amount);
            } else {
                System.out.println("This account type cannot transfer funds.");
            }
        }

        private BaseAccount findAccount(int accountNumber) {
            for (BaseAccount account : accounts) {
                if (account.getAccountNumber() == accountNumber) {
                    return account;
                }
            }
            return null;
        }
    }

