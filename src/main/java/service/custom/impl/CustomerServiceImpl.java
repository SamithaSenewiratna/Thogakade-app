package service.custom.impl;

import entity.CustomerEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import dto.Customer;
import org.modelmapper.ModelMapper;
import repository.DaoFactroy;
import repository.SuperDao;
import repository.custom.CustomerDao;
import service.custom.CustomerService;
import util.CrudUtil;
import util.DaoType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class CustomerServiceImpl implements CustomerService {
    private static CustomerServiceImpl instance;

    public CustomerServiceImpl() {
    }

    public static CustomerServiceImpl getInstance() {
        return instance == null ? instance = new CustomerServiceImpl() : instance;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();
        try {
            ResultSet resultSet = CrudUtil.execute("SELECT * FROM customer");
            while (resultSet.next()) {
                customerList.add(new Customer(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerList;
    }

    @Override
    public ObservableList<String> getCustomerIds() {
        ObservableList<String> custIdlist = FXCollections.observableArrayList();
        getAll().forEach(customer -> {
            custIdlist.add(customer.getId());
        });
        return custIdlist;
    }

    @Override
    public boolean saveCustomer(Customer customer) {

       CustomerEntity entity= new ModelMapper().map(customer,CustomerEntity.class);



        CustomerDao customerDao = DaoFactroy.getInstance().getDaoTyyple(DaoType.CUSTOMER);

        customerDao.save(entity);

        System.out.println("service layer :"+customer);

        return true;

//        try {
//            String SQL = "INSERT INTO customer VALUES(?,?,?,?)";
//            return CrudUtil.execute(SQL,
//                    customer.getId(),
//                    customer.getName(),
//                    customer.getAddress(),
//                    customer.getSalary()
//            );
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        String SQL = "UPDATE customer set name=?, address=?, salary=? WHERE id=?";
        return false;
    }

    @Override
    public boolean deleteCustomer(String customerId) {
        String SQL = "DELETE customer WHERE id=?";
        return false;
    }

    @Override
    public Customer searchCustomer(String customerId) {
        String SQL = "SELECT * FROM customer WHERE id=" + "'" + customerId + "'";

        try {
            ResultSet resultSet = CrudUtil.execute(SQL);
            resultSet.next();
            return new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
