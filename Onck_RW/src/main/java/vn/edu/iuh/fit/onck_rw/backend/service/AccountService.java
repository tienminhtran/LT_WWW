package vn.edu.iuh.fit.onck_rw.backend.service;

import vn.edu.iuh.fit.onck_rw.backend.entities.Account;

import java.util.List;

public interface AccountService {
    public List<Account> getAccountByBalanceBetween(double min, double max);


}
