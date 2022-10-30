package core.rules.abstracts;

import core.exceptions.BusinessRulesException;
import entities.concretes.Category;
import entities.concretes.Course;

public interface CategoryRules {
    void categoryAlreadyExists(String name) throws BusinessRulesException;
    void categoryCannotBeNull(Category category) throws BusinessRulesException;
}
