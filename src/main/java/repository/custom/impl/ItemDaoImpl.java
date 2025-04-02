package repository.custom.impl;

import dto.Item;
import repository.custom.ItemDao;

import java.util.List;

public class ItemDaoImpl implements ItemDao {


    @Override
    public Integer getQty(String itemCode) {
        return 0;
    }

    @Override
    public boolean save(Item entity) {
        return false;
    }

    @Override
    public Item search(String id) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(Item entity) {
        return false;
    }

    @Override
    public List<Item> getAll() {
        return List.of();
    }
}
