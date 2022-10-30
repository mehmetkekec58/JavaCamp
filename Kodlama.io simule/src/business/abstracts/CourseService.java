package business.abstracts;

import core.exceptions.BusinessRulesException;
import core.exceptions.ValidatorException;
import entities.concretes.Course;

import java.util.List;

public interface CourseService {
    void add(Course course) throws BusinessRulesException, ValidatorException;

    void update(Course course) throws BusinessRulesException, ValidatorException;

    void delete(Course course);

    List<Course> getAll();

    Course getById(int id) throws Exception;

    Course getByName(String name) throws Exception;
}
