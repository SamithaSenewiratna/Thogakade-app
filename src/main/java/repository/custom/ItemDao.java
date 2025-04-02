package repository.custom;

import dto.Item;
import repository.CrudRepository;

public interface ItemDao extends CrudRepository<Item> {

    Integer getQty(String itemCode);

}
