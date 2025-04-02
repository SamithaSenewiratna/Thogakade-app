package repository.custom.impl;

import entity.CustomerEntity;
import repository.custom.CustomerDao;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {


    @Override
    public boolean save(CustomerEntity entity) {

        System.out.println("dao  : "+entity);


        return false;
    }

    @Override
    public CustomerEntity search(String id) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(CustomerEntity entity) {
        return false;
    }

    @Override
    public List<CustomerEntity> getAll() {
        return List.of();
    }
}
