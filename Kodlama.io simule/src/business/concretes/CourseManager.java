package business.concretes;

import business.abstracts.CourseService;
import business.concretes.constans.CourseManagerMessages;
import core.exceptions.BusinessRulesException;
import core.exceptions.ValidatorException;
import core.logging.abstracts.Logger;
import core.rules.abstracts.CourseRules;
import core.validator.abstracts.CourseValid;
import dataAccess.abstracts.CourseDao;
import entities.concretes.Course;
import netscape.javascript.JSObject;

import java.util.List;

public class CourseManager implements CourseService {

    private CourseDao courseDao;
    private CourseRules courseRules;
    private CourseValid courseValid;
    private Logger[] loggers;

    public CourseManager(CourseDao courseDao, CourseRules courseRules, CourseValid courseValid, Logger[] loggers) {
        this.courseDao = courseDao;
        this.courseRules = courseRules;
        this.courseValid = courseValid;
        this.loggers = loggers;
    }

    @Override
    public void add(Course course) throws BusinessRulesException, ValidatorException {
        this.addBusinessCheck(course);
        this.courseDao.add(course);
        this.log("Kurs veritabanına eklendi: " + course.getName());

    }

    @Override
    public void update(Course course) throws BusinessRulesException, ValidatorException {
        this.updateBusinessCheck(course);
        this.courseDao.update(course);
        this.log("Kurs veritabanında güncellendi: " + course.getName());

    }

    @Override
    public void delete(Course course) {
        this.courseDao.delete(course);
        this.log("Kurs veritabanından silindi: " + course.getName());
    }

    @Override
    public List<Course> getAll() {
        return this.courseDao.getAll();
    }

    @Override
    public Course getById(int id) throws Exception {
        Course course = this.courseDao.get(c -> c.getId() == id);
        if (course == null)
            throw new Exception(CourseManagerMessages.COURSE_NOT_FOUND);
        return course;
    }

    @Override
    public Course getByName(String name) throws Exception {
        Course course = this.courseDao.get(c -> c.getName().equals(name));
        if (course == null)
            throw new Exception(CourseManagerMessages.COURSE_NOT_FOUND);
        return course;
    }

    private void log(String data) {
        for (Logger logger : this.loggers) {
            logger.log(data);
        }
    }

    private void addBusinessCheck(Course course) throws BusinessRulesException, ValidatorException {
        this.courseRules.courseCannotBeNull(course);
        this.courseValid.isValid(course);
        this.courseRules.courseAlreadyExists(course.getName());
    }

    private void updateBusinessCheck(Course course) throws BusinessRulesException, ValidatorException {
        this.courseRules.courseCannotBeNull(course);
        this.courseValid.isValid(course);
        this.courseRules.courseAlreadyExists(course.getName());
    }
}
