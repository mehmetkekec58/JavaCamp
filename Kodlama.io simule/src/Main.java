import business.abstracts.CourseService;
import business.concretes.CourseManager;
import core.logging.abstracts.Logger;
import core.logging.concretes.DatabaseLogger;
import core.logging.concretes.FileLogger;
import core.rules.abstracts.CourseRules;
import core.rules.concretes.CourseRulesBussiness;
import core.validator.abstracts.CourseValid;
import core.validator.concretes.CourseValidator;
import dataAccess.abstracts.CourseDao;
import dataAccess.concretes.jdbcDatabase.JdbcCourseDao;
import entities.concretes.Course;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Course course = new Course();
        course.setId(1);
        course.setPrice(5.5);
        course.setName("Java");
        course.setEducatorId(2);
        course.setCategoryId(5);

        Course course2 = new Course();
        course2.setId(2);
        course2.setPrice(-9.0);
        course2.setName("C#");
        course2.setEducatorId(1);
        course2.setCategoryId(4);

        Course course3 = new Course();
        course3.setId(3);
        course3.setPrice(45.5);
        course3.setName("C#");
        course3.setEducatorId(1);
        course3.setCategoryId(4);

        Course course4 = new Course();
        course4.setId(3);
        course4.setPrice(45.5);
        course4.setName("JavaScript");
        course4.setEducatorId(1);
        course4.setCategoryId(4);

        Course course5 = new Course();
        course5.setId(4);
        course5.setPrice(45.5);
        course5.setName("Go");
        course5.setEducatorId(1);
        course5.setCategoryId(4);

        Course course6 = new Course(5, "PHP", 50.1, 2, 5);


        CourseDao jdbcCourseDao = new JdbcCourseDao();
        CourseRules courseRules = new CourseRulesBussiness(jdbcCourseDao);
        CourseValid courseValid = new CourseValidator();
        Logger[] loggers = new Logger[]{new DatabaseLogger(),new FileLogger()};

        CourseService courseService = new CourseManager(jdbcCourseDao, courseRules, courseValid, loggers);

        try {
            courseService.add(course);
            courseService.add(course2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            courseService.add(course3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(courseService.getById(1).getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            courseService.update(course4);
            courseService.add(course5);
            courseService.delete(course5);
            courseService.add(course6);
            List<Course> courses = courseService.getAllByName(course2.getName());
            for (Course cours : courses) {
                System.out.println(cours.getName());
            }
            System.out.println("------------------");
            List<Course> courses2 = courseService.getAll();
            for (Course cours : courses2) {
                System.out.println(cours.getName() + ", id:" + cours.getId());
            }
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }


    }
}
