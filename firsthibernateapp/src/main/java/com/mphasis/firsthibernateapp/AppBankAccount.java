package com.mphasis.firsthibernateapp;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mphasis.firsthibernateapp.model.BankAccount;
import com.mphasis.firsthibernateapp.model.Currency;
import com.mphasis.firsthibernateapp.util.HibernateUtil;

public class AppBankAccount {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // Create and persist two accounts
        BankAccount account1 = new BankAccount();
        account1.setAccountNumber("ACC001");
        account1.setAccountHolderName("Alice Smith");
        account1.setBalance(new BigDecimal("1500.00"));
        account1.setCurrency(new Currency("USD", "$", "en-US"));

        BankAccount account2 = new BankAccount();
        account2.setAccountNumber("ACC002");
        account2.setAccountHolderName("Bob Johnson");
        account2.setBalance(new BigDecimal("2500.50"));
        account2.setCurrency(new Currency("EUR", "€", "de-DE"));

        session.persist(account1);
        session.persist(account2);

        // Retrieve accounts
        BankAccount retrievedAcc1 = session.get(BankAccount.class, "ACC001");
        BankAccount retrievedAcc2 = session.get(BankAccount.class, "ACC002");

        // Display account details
        System.out.println(
            retrievedAcc1.getAccountHolderName() + ": " +
            retrievedAcc1.getCurrency().getCurrencySymbol() +
            retrievedAcc1.getBalance()
        );

        // Transfer 500 from account2 to account1
        retrievedAcc1.setBalance(
            retrievedAcc1.getBalance().add(new BigDecimal("500"))
        );

        retrievedAcc2.setBalance(
            retrievedAcc2.getBalance().subtract(new BigDecimal("500"))
        );

        // Hibernate auto-updates entities inside transaction
        tx.commit();
        session.close();
    }
}