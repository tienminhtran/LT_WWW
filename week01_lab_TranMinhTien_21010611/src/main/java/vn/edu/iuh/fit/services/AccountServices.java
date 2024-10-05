package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;

import jakarta.inject.Inject;

import java.util.List;

public class AccountServices {
    private AccountRepository accountRepositories;

    public AccountServices() {
        this.accountRepositories = new AccountRepository();
    }

    public boolean checkAccount(String account_id, String password) {

        Account account = accountRepositories.findAccountByIdPassword(account_id, password);
        return account != null;
    }


    public Account findOneAccountById(String account_id) {
        return accountRepositories.findOneAccountById(account_id);
    }

    public List<Account> findAllAccount() {
        return accountRepositories.findAllAccount();
    }
    public boolean checkExistsAccount(Account account) {
        return accountRepositories.findOneAccountById(account.getAccount_id()) != null;
    }
    // insert account
    public boolean insertAccount(Account account) {
        if (checkExistsAccount(account)) {
            return false;
        } else {
            return accountRepositories.insertAccount(account);
        }
    }

    //update account
    public boolean updateAccount(Account account) {
        if (checkExistsAccount(account)) {
            return accountRepositories.updateAccount(account);
        } else {
            return false;
        }
    }
    public Account getInfor(String account_id) {
        return accountRepositories.findOneAccountById(account_id);
    }


    public boolean deleteAccount(Account account) {
        return accountRepositories.deleteAccount(account.getAccount_id());
    }



}
