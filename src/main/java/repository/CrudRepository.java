package repository;

import java.util.List;

public interface CrudRepository<T> extends SuperDao {


    boolean save(T entity);
    T search(String id);
    boolean delete(String id);
    boolean update(T entity);
    List<T> getAll();
}
