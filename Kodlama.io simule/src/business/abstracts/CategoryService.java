package business.abstracts;

import core.exceptions.BusinessRulesException;
import core.exceptions.ValidatorException;
import entities.concretes.Category;
import entities.concretes.Course;

import java.util.List;

public interface CategoryService {
    void add(Category category) throws BusinessRulesException, ValidatorException;

    void update(Category category) throws BusinessRulesException, ValidatorException;

    void delete(Category category);

    List<Category> getAll();

    Category getById(int id) throws Exception;

    List<Category> getAllByName(String name);
}
