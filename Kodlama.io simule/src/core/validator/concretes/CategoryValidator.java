package core.validator.concretes;

import core.exceptions.ValidatorException;
import core.validator.abstracts.CategoryValid;
import core.validator.concretes.constants.CategoryValidatorMessages;
import core.validator.concretes.constants.CourseValidatorMessages;
import entities.concretes.Category;

public class CategoryValidator implements CategoryValid {
    @Override
    public void isValid(Category category) throws ValidatorException {
        if (category.getName().isEmpty())
            throw new ValidatorException(CategoryValidatorMessages.CATEGORY_NAME_CANNOT_BE_EMPTY);

    }
}
