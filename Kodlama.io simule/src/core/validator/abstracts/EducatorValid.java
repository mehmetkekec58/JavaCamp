package core.validator.abstracts;

import core.exceptions.ValidatorException;
import entities.concretes.Educator;

public interface EducatorValid {
    void isValid(Educator educator) throws ValidatorException;
}
