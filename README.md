
# Jordan’s Virtual Bank

### “Real Money. Real Logic. Real OOP.”

Jordan just got serious about managing money.

He has:

* A **Checking Account**
* A **Savings Account** (earns interest)
* One **additional account type of your choice**

Your job is to build his virtual banking system using **proper Object-Oriented Programming principles**.

This is not a “just make it work” assignment.
This is a **prove you understand OOP** assignment.

---

# 🎯 Objective

Design a small banking system that demonstrates:

* Abstraction
* Encapsulation
* Inheritance
* Polymorphism

If you cannot explain where each principle appears in your code, you did not complete the assignment correctly.

---

# 📁 Required Files

You must create:

* `BankAccount.java`
* `CheckingAccount.java`
* `SavingsAccount.java`
* `YourThirdAccountType.java`
* `Main.java`

---

# System Requirements

## Base Account

Create a base account class that represents what all accounts have in common.

All accounts must:

* Have an owner
* Have an account number
* Have a balance
* Support deposits
* Support withdrawals
* Support a monthly update
* Be able to print a summary

Not all accounts behave the same way.

That’s intentional.

---

## Checking Account

* Allows deposits
* Allows withdrawals (cannot withdraw more than balance)
* Monthly update:

  * Apply a fee if balance is below a certain amount

You decide reasonable rules.

---

## Savings Account

* Allows deposits
* Allows withdrawals (cannot exceed balance)
* Must accrue interest during monthly update

You decide how interest works.

---

## Third Account (Your Choice)

Choose something different. Examples:

* Credit account
* Investment account
* High-yield savings
* Crypto wallet
* Business account

It must:

* Behave differently than checking and savings
* Have unique rules
* Override behavior where necessary

Be creative — but keep it realistic.

---

# Main Program Requirements

In `Main.java`:

1. Create at least one of each account type.
2. Store them together in a single collection (array or ArrayList).
3. Perform multiple transactions.
4. Run monthly updates on all accounts.
5. Print account summaries before and after updates.

---

# OOP Expectations

Your code must clearly demonstrate:

### Abstraction

There should be behavior defined that subclasses must implement.

### Encapsulation

Fields must not be publicly accessible.
Validation must happen inside methods.

### Inheritance

Account types must reuse shared behavior.

### Polymorphism

You must treat different account types as the same base type at some point in your program.

---

# Restrictions

* No static global balances.
* No public fields.
* No copy-pasting code between account classes.
* No giant `if(type == "...")` statements in Main to control behavior.
* Do not hardcode behavior in Main that belongs in a class.

If your Main file controls account logic, you misunderstood the assignment.

---

# Minimum Output Example (Structure Only)

Your output should resemble:

```
--- BEFORE MONTHLY UPDATE ---
Checking (001) - Balance: $500.00
Savings (002) - Balance: $1000.00
Credit (003) - Balance: $300.00

--- AFTER MONTHLY UPDATE ---
Checking (001) - Balance: $495.00
Savings (002) - Balance: $1020.00
Credit (003) - Balance: $309.00
```

Your numbers will differ depending on your rules.

---

# Submission Rules

Be prepared to:

* Explain where each OOP principle exists in your code. Using comments
* Explain why you made certain methods abstract.
* Explain why fields are private.
* Explain how polymorphism works in your loop.

If you cannot explain it, you don’t fully understand it yet.

---

# Bonus (Optional)

Choose one:

* Add a transfer method between accounts
* Add transaction history
* Add overdraft logic
* Add user input with Scanner
* Add unit tests

---


