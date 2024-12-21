package vn.edu.iuh.fit.onck_rw.backend.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.onck_rw.backend.entities.Account;
import vn.edu.iuh.fit.onck_rw.backend.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountRestAPI {


    @Autowired
    private AccountService accountService;
    @RequestMapping("/find-with")
    public ResponseEntity<List<Account>> getAccountsBetweenBalance(double min, double max) {
        return ResponseEntity.ok(accountService.getAccountByBalanceBetween(min, max));
    }
}
