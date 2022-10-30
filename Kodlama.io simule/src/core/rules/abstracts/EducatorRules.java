package core.rules.abstracts;

import core.exceptions.BusinessRulesException;
import entities.concretes.Educator;

public interface EducatorRules {
    void educatorCannotBeNull(Educator educator) throws BusinessRulesException;
    void emailAlreadyExists(String email) throws BusinessRulesException;
}
