package business.concretes;

import business.abstracts.CourseService;
import core.exceptions.BusinessRulesException;
import core.rules.abstracts.CourseRules;
import dataAccess.abstracts.CourseDao;
import entities.concretes.Course;

import java.util.List;

public class CourseManager implements CourseService {

    private CourseDao courseDao;
    private CourseRules courseRules;
    public CourseManager(CourseDao courseDao, CourseRules courseRules) {
        this.courseDao = courseDao;
        this.courseRules = courseRules;
    }

    @Override
    public void add(Course course) throws BusinessRulesException {
        this.courseRules.courseAlreadyExists(course.getName());
        this.courseRules.thePriceOfTheCourseCannotBeLessThanZero(course.getPrice());
        this.courseDao.add(course);
    }

    @Override
    public void update(Course course) throws BusinessRulesException {
        this.courseRules.courseAlreadyExists(course.getName());
        this.courseRules.thePriceOfTheCourseCannotBeLessThanZero(course.getPrice());
        this.courseDao.update(course);
    }
    @Override
    public void delete(Course course) {
        this.courseDao.delete(course);
    }

    @Override
    public List<Course> getAll() {
        return this.courseDao.getAll();
    }

    @Override
    public Course getById(int id){
        return this.courseDao.get(c->c.getId() == id);
    }

    @Override
    public List<Course> getAllByName(String name) {
        return this.courseDao.getAll(c->c.getName().equals(name));
    }

}
