package core.validator.abstracts;

import core.exceptions.ValidatorException;
import entities.concretes.Course;

public interface CourseValid {
    void isValid(Course course) throws ValidatorException;
}

