package business.concretes;

import business.abstracts.CategoryService;
import core.exceptions.BusinessRulesException;
import core.rules.abstracts.CategoryRules;
import dataAccess.abstracts.CategoryDao;
import entities.concretes.Category;

import java.util.List;

public class CategoryManager implements CategoryService {

    private CategoryDao categoryDao;
    private CategoryRules categoryRules;

    public CategoryManager(CategoryDao categoryDao, CategoryRules categoryRules) {
        this.categoryDao = categoryDao;
        this.categoryRules = categoryRules;
    }

    @Override
    public void add(Category category) throws BusinessRulesException {
        this.categoryRules.categoryAlreadyExists(category.getName());
        this.categoryDao.add(category);
    }

    @Override
    public void update(Category category) throws BusinessRulesException {
        this.categoryRules.categoryAlreadyExists(category.getName());
        this.categoryDao.update(category);
    }

    @Override
    public void delete(Category category) {
        this.categoryDao.delete(category);
    }

    @Override
    public List<Category> getAll() {
        return this.categoryDao.getAll();
    }

    @Override
    public Category getById(int id) {
        return this.categoryDao.get(c -> c.getId() == id);
    }

    @Override
    public List<Category> getAllByName(String name) {
        return this.categoryDao.getAll(c -> c.getName().equals(name));
    }
}
