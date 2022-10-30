package core.rules.concretes;

import core.exceptions.BusinessRulesException;
import core.rules.abstracts.EducatorRules;
import core.rules.concretes.constants.EducatorRulesMessages;
import dataAccess.abstracts.EducatorDao;
import entities.concretes.Educator;

public class EducatorRulesBusiness implements EducatorRules {
    private EducatorDao educatorDao;

    public EducatorRulesBusiness(EducatorDao educatorDao) {
        this.educatorDao = educatorDao;
    }

    @Override
    public void educatorCannotBeNull(Educator educator) throws BusinessRulesException {
        if (educator == null)
            throw new BusinessRulesException(EducatorRulesMessages.EDUCATOR_CANNOT_BE_NULL);
    }

    @Override
    public void emailAlreadyExists(String email) throws BusinessRulesException {
        if (educatorDao.get(c -> c.getEmail().equals(email)) != null) {
            throw new BusinessRulesException(EducatorRulesMessages.ALREADY_EMAIL_EXISTS);
        }
    }
}
