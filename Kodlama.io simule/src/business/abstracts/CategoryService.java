package business.abstracts;

import core.exceptions.BusinessRulesException;
import entities.concretes.Category;
import entities.concretes.Course;

import java.util.List;

public interface CategoryService {
    void add(Category category) throws BusinessRulesException;
    void update(Category category) throws BusinessRulesException;
    void delete(Category category);
    List<Category> getAll();
    Category getById(int id) throws BusinessRulesException;
    List<Category> getAllByName(String name);
}
