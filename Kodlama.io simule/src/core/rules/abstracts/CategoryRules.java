package core.rules.abstracts;

import core.exceptions.BusinessRulesException;

public interface CategoryRules {
    void categoryAlreadyExists(String name) throws BusinessRulesException;
}
