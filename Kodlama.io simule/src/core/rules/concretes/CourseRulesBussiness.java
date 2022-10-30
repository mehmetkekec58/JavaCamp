package core.rules.concretes;

import core.exceptions.BusinessRulesException;
import core.rules.abstracts.CourseRules;
import core.rules.concretes.constants.CourseRulesMessages;
import dataAccess.abstracts.CourseDao;
import entities.concretes.Course;

public class CourseRulesBussiness implements CourseRules {
    private CourseDao courseDao;
    public CourseRulesBussiness(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public void courseAlreadyExists(String name) throws BusinessRulesException {
       Course result = this.courseDao.get(c->c.getName().equals(name));
       if (result != null)
           throw new BusinessRulesException(CourseRulesMessages.ALREADY_COURSE_EXISTS);
    }

    @Override
    public void courseCannotBeNull(Course course) throws BusinessRulesException {
        if(course == null)
            throw  new BusinessRulesException(CourseRulesMessages.COURSE_CANNOT_BE_NULL);
    }
}
