package business.abstracts;

import core.exceptions.BusinessRulesException;
import entities.concretes.Course;

import java.util.List;

public interface CourseService {
    void add(Course course) throws BusinessRulesException;
    ;
    void update(Course course) throws BusinessRulesException;
    void delete(Course course);
    List<Course> getAll();
    Course getById(int id) throws BusinessRulesException;
    List<Course> getAllByName(String name);
}
