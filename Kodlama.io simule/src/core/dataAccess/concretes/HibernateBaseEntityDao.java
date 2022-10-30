package core.dataAccess.concretes;

import core.dataAccess.abstracts.BaseEntityDao;
import core.entities.concretes.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class HibernateBaseEntityDao<T extends Entity> implements BaseEntityDao<T> {

    private List<T> entities = new ArrayList<>();

    @Override
    public void add(T entity) {
        this.entities.add(entity);
    }

    @Override
    public void update(T entity) {
        for (int i = 0; i < this.entities.size(); i++) {
            if (this.entities.get(i).getId() == entity.getId()) {
                this.entities.set(i, entity);
            }
        }
    }

    @Override
    public void delete(T entity) {
        this.entities.remove(entity);
    }

    @Override
    public T get(Predicate<? super T> filter) {
        List<T> entities = this.entities.stream().filter(filter).toList();
        if (entities.size() == 0)
            return null;
        return entities.get(0);
    }

    @Override
    public List<T> getAll() {
        return this.entities;
    }

    @Override
    public List<T> getAll(Predicate<? super T> filter) {
        return this.entities.stream().filter(filter).toList();
    }
}
