package vn.edu.iuh.fit.onck_rw.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.onck_rw.backend.entities.Account;
import vn.edu.iuh.fit.onck_rw.backend.repository.AccountRepository;
import vn.edu.iuh.fit.onck_rw.backend.service.AccountService;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<Account> getAccountByBalanceBetween(double min, double max) {
       return accountRepository.findAccountByBalanceBetween(min, max);

    }


}
