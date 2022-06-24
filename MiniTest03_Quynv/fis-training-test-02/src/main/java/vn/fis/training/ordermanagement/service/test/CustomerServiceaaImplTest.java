package vn.fis.training.ordermanagement.service.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import vn.fis.training.ordermanagement.repository.CustomerRepository;
import vn.fis.training.ordermanagement.service.CustomerService;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceaaImplTest {
    @Autowired
    CustomerService customerService;

    @Test
    void findByMobileNumber() {
        System.out.println(this.customerService.findByMobileNumber("0332429178"));
    }
}