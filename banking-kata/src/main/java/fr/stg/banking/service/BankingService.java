package fr.stg.banking.service;

import fr.stg.banking.Account;

public interface BankingService {

    /**
     * Deposit an amount to an account
     *
     * @param account Account to use for deposit
     * @param amount Amount to deposit
     */
    public void deposit(Account account, int amount);

    /**
     * Withdraw an amount to an account
     *
     * @param account Account to use for withdraw
     * @param amount amount to withdraw
     */
    public void withdraw(Account account, int amount);

    /**
     * Print the statment of account
     *
     * @param account Account to print
     * @return
     */
    public String printStatment(Account account);

}
