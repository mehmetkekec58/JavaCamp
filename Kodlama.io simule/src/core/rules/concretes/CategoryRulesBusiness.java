package core.rules.concretes;

import core.exceptions.BusinessRulesException;
import core.rules.abstracts.CategoryRules;
import core.rules.concretes.constants.CategoryRulesMessages;
import dataAccess.abstracts.CategoryDao;

public class CategoryRulesBusiness implements CategoryRules {

    private CategoryDao categoryDao;

    public CategoryRulesBusiness(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public void categoryAlreadyExists(String name) throws BusinessRulesException {
        if (this.categoryDao.get(c -> c.getName().equals(name)) != null) {
            throw new BusinessRulesException(CategoryRulesMessages.ALREADY_CATEGORY_EXISTS);
    }
    }
}
