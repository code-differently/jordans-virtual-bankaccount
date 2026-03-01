package org.codedifferently;
/*
 * ABSTRACTION:
 * This interface defines what all accounts must be able to do.
 * It does NOT define how they do it.
 */

public interface AccountOperations {
    void deposit(double amount);
    void withdraw(double amount);

    void monthlyUpdate();// must be different per account

    void printSummary();

}
