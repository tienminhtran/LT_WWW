package vn.edu.iuh.fit.onck_rw;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.onck_rw.backend.entities.Account;
import vn.edu.iuh.fit.onck_rw.backend.entities.Customer;
import vn.edu.iuh.fit.onck_rw.backend.enums.AccoutStatus;
import vn.edu.iuh.fit.onck_rw.backend.repository.AccountRepository;
import vn.edu.iuh.fit.onck_rw.backend.repository.CustomerRepository;
import net.datafaker.Faker;

import java.time.LocalDate;

@SpringBootTest
class OnckRwApplicationTests {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private final Faker faker = new Faker(); // Khởi tạo Faker một lần

    @Test
    void contextLoads() {
    }


    @Test
    public void generateCus() {
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer();
            customer.setName(faker.name().fullName());
            // tao mảng các 12/11/2003; 12/12/2004; 12/11/2005; 12/12/2006;
            LocalDate[] dates = {LocalDate.of(2000, 11, 12), LocalDate.of(2004, 12, 12), LocalDate.of(2005, 11, 12), LocalDate.of(2006, 12, 12)};
            customer.setDob(dates[faker.number().numberBetween(0, 3)]);
            customer.setAddress(faker.address().fullAddress());
            customer.setEmail((faker.internet().emailAddress()));
            // random số tài khoản từ 1 đến 10
            customerRepository.save(customer);
        }
    }
    @Test
    public void generateAcc() {
        Faker faker = new Faker();
        for (int i = 1; i <= 10; i++) {
            Customer customer = customerRepository.findById((long) i).get();
            for (int j = 1; j <= 10; j++) {
                Account account = new Account();
                account.setBalance(faker.number().randomDouble(2, 100, 1000));
                account.setCustomer(customer);
                account.setStatus(AccoutStatus.CHECKING);
                accountRepository.save(account);
            }

        }
    }




}
