package vn.fis.training.store;

import vn.fis.training.domain.Customer;
import vn.fis.training.domain.CustomerStatus;
import vn.fis.training.exception.InvalidCustomerStatusException;

import java.util.*;

public final class InMemoryCustomerStore {
    /**
     *  Map dung de lu tru customer trong he thong
     */
    private final Map<String, Customer> mapCustomer = new HashMap<>();

    /**
     * @param customer doi tuong customer (da duoc chuan hoa truoc do)
     * @return Customer: Doi tuong customer sau khi da duoc luu thanh cong vao he thong
     * @throws vn.fis.training.exception.ApplicationException tuong ung.
     */
    public Customer insertOrUpdate(Customer customer) {
        if (customer.getId().isEmpty() || customer.getId()==null){
            mapCustomer.put(customer.getId(), customer);
            return customer;
        } else {
            mapCustomer.put(customer.getId(), customer);
            return customer;
        }
    }

    /**
     * @return : tra ve toan bo danh sach customer trong he thong
     */
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>(mapCustomer.values());
        return list;
    }

    /**
     * @param id: Id cua customer muon delete
     */
    public void deleteById(String id) {
        mapCustomer.remove(id);
    }
}
