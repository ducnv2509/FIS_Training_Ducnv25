package vn.fis.training.service;

import vn.fis.training.domain.Customer;
import vn.fis.training.domain.CustomerStatus;
import vn.fis.training.exception.CustomerNotFoundException;
import vn.fis.training.exception.DuplicateCustomerException;
import vn.fis.training.exception.InvalidCustomerStatusException;
import vn.fis.training.store.InMemoryCustomerStore;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class SimpleCustomerService implements CustomerService {

    private InMemoryCustomerStore customerStore;

    public SimpleCustomerService() {
        this.customerStore = new InMemoryCustomerStore();
    }

    public void setCustomerStore(InMemoryCustomerStore customerStore) {
        this.customerStore = customerStore;
    }

    private boolean isNullOrEmpty(String id) {
        if (id.trim() == null) {
            return true;
        }
        return false;
    }

    @Override
    public Customer findById(String id) {
        if (isNullOrEmpty(id)) {
            throw new IllegalArgumentException("kh dc de trong");
        }

        return customerStore.findAll().stream()
                .filter(i -> i.getId().equals(id))
                .findFirst().orElseThrow(() -> {
                    throw new CustomerNotFoundException("Khong tim thay" + id);
                });
    }

    @Override
    public Customer createCustomer(Customer customer) {
        validate(customer);
        checkDuplicate(customer);
        return customerStore.insertOrUpdate(customer);
    }

    private void checkDuplicate(Customer customer) {
        try {

        } catch (CustomerNotFoundException customerNotFoundException) {
            if (customerStore.findAll().stream().anyMatch(i -> i.hashCode() == 1)) {
                throw new DuplicateCustomerException(customer,
                        String.format("da ton tai customer %s", customer.toString()));
            }
        }
    }

    private void validate(Customer customer) {
        if(isNullOrEmpty(customer.getName())){
            throw new DuplicateCustomerException(customer,"Customer name not valid");
        }
        if(isNullOrEmpty(customer.getMobile())){
            throw new DuplicateCustomerException(customer,"Customer mobile not valid");
        }
        if(isNullOrEmpty(customer.getBirthDay().toString())){
            throw new DuplicateCustomerException(customer,"Customer DOB not valid");
        }
        if(isNullOrEmpty(customer.getStatus().toString())){
            throw new DuplicateCustomerException(customer,"Customer Status not valid");
        }
        if(customer.getName().length() < 5 || customer.getName().length() > 50){
            throw new DuplicateCustomerException(customer,"Customer name not valid");
        }
        if(customer.getName().matches("^[a-zA-Z]+$")){
            throw new DuplicateCustomerException(customer,"Customer name not valid");
        }
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        validate(customer);
        findById(customer.getId());
        return customerStore.insertOrUpdate(customer);
    }

    @Override
    public void deleteCustomerById(String id) {
        if (isNullOrEmpty(id))
            throw new IllegalArgumentException("kh dc de trong");
        customerStore.deleteById(id);
    }

    @Override
    public List<Customer> findAllOrderByNameAsc() {
        customerStore.findAll();
        if (customerStore.findAll().isEmpty()) {
            throw new CustomerNotFoundException("No Data");
        }
        return customerStore.findAll().stream()
                .sorted(Comparator.comparing(Customer::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> findAllOrderByNameLimit(int limit) {
        customerStore.findAll();
        if (customerStore.findAll().isEmpty()) {
            throw new CustomerNotFoundException("No Data");
        }
        return customerStore.findAll().stream()
                .sorted(Comparator.comparing(Customer::getName))
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> findAllCustomerByNameLikeOrderByNameAsc(String custName, String limit) {
        customerStore.findAll();
        if (customerStore.findAll().isEmpty()) {
            throw new CustomerNotFoundException("No Data");
        }
        try {
            int limitInt = Integer.parseInt(limit);
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập limit là số");
            return null;
        }
        return customerStore.findAll().stream()
                .filter(i -> i.getName().contains(custName))
                .sorted(Comparator.comparing(Customer::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<SummaryCustomerByAgeDTO> summaryCustomerByAgeOrderByAgeDesc() {
        List<Customer> list = customerStore.findAll();
        List<SummaryCustomerByAgeDTO> lstDTO = new ArrayList<>();
        for (Customer x : list) {
            int age = LocalDate.now().getYear() - x.getBirthDay().getYear();
            if (lstDTO.isEmpty() || lstDTO.stream().filter(i -> i.getAge() == age).collect(Collectors.toList()).isEmpty()) {
                lstDTO.add(new SummaryCustomerByAgeDTO(
                        (age)
                        , 1));
            } else {
                lstDTO.stream().filter(i1 -> i1.getAge() == age)
                        .forEach(i2 -> i2.setCount(i2.getCount() + 1));
            }
        }
        return lstDTO;
    }

}
