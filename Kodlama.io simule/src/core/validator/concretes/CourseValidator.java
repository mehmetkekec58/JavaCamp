package core.validator.concretes;

import core.exceptions.ValidatorException;
import core.validator.abstracts.CourseValid;
import core.validator.concretes.constants.CourseValidatorMessages;
import entities.concretes.Course;

public class CourseValidator implements CourseValid {

    public void isValid(Course course) throws ValidatorException {
        if (course.getName().length() <= 0)
            throw new ValidatorException(CourseValidatorMessages.COURSE_NAME_MUST_BE_LEAST_ONE_CHARACTERS);

        if (course.getPrice() < 0)
            throw new ValidatorException(CourseValidatorMessages.THE_PRICE_OF_THE_COURSE_CANNOT_BE_LESS_THAN_ZERO);

    }
}
