package vn.fis.training.service;


import org.junit.jupiter.api.Test;
import vn.fis.training.domain.Customer;
import vn.fis.training.domain.CustomerStatus;
import vn.fis.training.store.InMemoryCustomerStore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

class SimpleCustomerServiceTest {



    @Test
    void findById() {
        SimpleCustomerService scs = new SimpleCustomerService();
        scs.createCustomer(new Customer("1"
                , "quoc"
                , LocalDate.of(2002, 12,12)
                , "02356432", CustomerStatus.ACTIVE
                , LocalDateTime.of(2020, 12, 12,12,12,12)));

        System.out.println(scs.findById("1"));
    }

    @Test
    void createCustomer() {
        SimpleCustomerService scs = new SimpleCustomerService();
        Customer customer = scs.createCustomer(new Customer("1"
                , "quoc"
                , LocalDate.of(2002, 12,12)
                , "02356432", CustomerStatus.ACTIVE
                , LocalDateTime.of(2020, 12, 12,12,12,12)));

        System.out.println(customer.toString());
    }

    @Test
    void updateCustomer() {
        SimpleCustomerService scs = new SimpleCustomerService();
        Customer customer = scs.createCustomer(new Customer("1"
                , "quoc"
                , LocalDate.of(2002, 12,12)
                , "02356432", CustomerStatus.ACTIVE
                , LocalDateTime.of(2020, 12, 12,12,12,12)));
        customer.setName("Quocccc");
        System.out.println(scs.updateCustomer(customer).toString());
    }

    @Test
    void deleteCustomerById() {
        SimpleCustomerService scs = new SimpleCustomerService();
        Customer customer = scs.createCustomer(new Customer("1"
                , "quoc"
                , LocalDate.of(2002, 12,12)
                , "02356432", CustomerStatus.ACTIVE
                , LocalDateTime.of(2020, 12, 12,12,12,12)));
    }

    @Test
    void findAllOrderByNameAsc() {
        SimpleCustomerService scs = new SimpleCustomerService();
        Customer customer = scs.createCustomer(new Customer("1"
                , "quoc"
                , LocalDate.of(2002, 12,12)
                , "02356432", CustomerStatus.ACTIVE
                , LocalDateTime.of(2020, 12, 12,12,12,12)));
        scs.createCustomer(new Customer("2"
                , "aquocc"
                , LocalDate.of(2002, 12,12)
                , "02356432", CustomerStatus.ACTIVE
                , LocalDateTime.of(2020, 12, 12,12,12,12)));
        List<Customer> lst = scs.findAllOrderByNameAsc();
        System.out.println(lst.toString());
    }

    @Test
    void findAllOrderByNameLimit() {
        SimpleCustomerService scs = new SimpleCustomerService();
        Customer customer = scs.createCustomer(new Customer("1"
                , "quoc"
                , LocalDate.of(2002, 12,12)
                , "02356432", CustomerStatus.ACTIVE
                , LocalDateTime.of(2020, 12, 12,12,12,12)));
        scs.createCustomer(new Customer("2"
                , "aquocc"
                , LocalDate.of(2002, 12,12)
                , "02356432", CustomerStatus.ACTIVE
                , LocalDateTime.of(2020, 12, 12,12,12,12)));
        List<Customer> lst = scs.findAllOrderByNameLimit(1);
        System.out.println(lst.toString());
    }

    @Test
    void findAllCustomerByNameLikeOrderByNameAsc() {
        SimpleCustomerService scs = new SimpleCustomerService();
        Customer customer = scs.createCustomer(new Customer("1"
                , "quoc"
                , LocalDate.of(2002, 12,12)
                , "02356432", CustomerStatus.ACTIVE
                , LocalDateTime.of(2020, 12, 12,12,12,12)));
        scs.createCustomer(new Customer("2"
                , "aquocc"
                , LocalDate.of(2002, 12,12)
                , "02356432", CustomerStatus.ACTIVE
                , LocalDateTime.of(2020, 12, 12,12,12,12)));
        List<Customer> lst = scs.findAllCustomerByNameLikeOrderByNameAsc("quoc", "2");
        System.out.println(lst.toString());
    }

    @Test
    void summaryCustomerByAgeOrderByAgeDesc() {
        SimpleCustomerService scs = new SimpleCustomerService();
        Customer customer = scs.createCustomer(new Customer("1"
                , "quoc"
                , LocalDate.of(2002, 12,12)
                , "02356432", CustomerStatus.ACTIVE
                , LocalDateTime.of(2020, 12, 12,12,12,12)));
        scs.createCustomer(new Customer("2"
                , "aquocc"
                , LocalDate.of(2002, 12,12)
                , "02356432", CustomerStatus.ACTIVE
                , LocalDateTime.of(2020, 12, 12,12,12,12)));
        scs.createCustomer(new Customer("2"
                , "aquocc"
                , LocalDate.of(2001, 12,12)
                , "02356432", CustomerStatus.ACTIVE
                , LocalDateTime.of(2020, 12, 12,12,12,12)));
        List<SummaryCustomerByAgeDTO> lst = scs.summaryCustomerByAgeOrderByAgeDesc();
        System.out.println(lst.toString());
    }
}