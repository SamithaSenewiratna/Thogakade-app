package service.custom;

import javafx.collections.ObservableList;
import dto.Customer;
import service.SuperService;

import java.util.List;

public interface CustomerService extends SuperService {


    List<Customer> getAll();
    boolean saveCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(String customerId);
    Customer searchCustomer(String customerId);
     ObservableList<String> getCustomerIds();
}
