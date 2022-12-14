package core.rules.abstracts;

import core.exceptions.BusinessRulesException;
import dataAccess.abstracts.CourseDao;
import entities.concretes.Course;

public interface CourseRules {
    void courseAlreadyExists(String name) throws BusinessRulesException;

    void courseCannotBeNull(Course course) throws BusinessRulesException;
}
