package core.validator.concretes;

import core.exceptions.ValidatorException;
import core.validator.abstracts.EducatorValid;
import core.validator.concretes.constants.EducatorValidatorMessages;
import entities.concretes.Educator;

public class EducatorValidator implements EducatorValid {
    @Override
    public void isValid(Educator educator) throws ValidatorException {
        if (educator.getEmail().isEmpty())
            throw new ValidatorException(EducatorValidatorMessages.EMAIL_CANNOT_BE_EMPTY);

        if (educator.getFirstName().isEmpty())
            throw new ValidatorException(EducatorValidatorMessages.FIRSTNAME_CANNOT_BE_EMPTY);

        if (educator.getLastName().isEmpty())
            throw new ValidatorException(EducatorValidatorMessages.LASTNAME_CANNOT_BE_EMPTY);


    }
}
