package core.dataAccess.abstracts;

import core.entities.concretes.Entity;

import java.util.List;
import java.util.function.Predicate;

public interface BaseEntityDao<T extends Entity>  {
    void add(T entity);
    void update(T entity);
    void delete(T entity);
    T get(Predicate<? super T> filter);
    List<T> getAll();
    List<T> getAll(Predicate<? super T> filter);
}
