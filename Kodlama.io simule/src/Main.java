import business.abstracts.CourseService;
import business.concretes.CourseManager;
import core.rules.abstracts.CourseRules;
import core.rules.concretes.CourseRulesBussiness;
import dataAccess.abstracts.CourseDao;
import dataAccess.concretes.jdbcDatabase.JdbcCourseDao;
import entities.concretes.Course;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Course course = new Course();
        course.setId(1);
        course.setPrice(45.5);
        course.setName("Java");
        course.setEducatorId(2);
        course.setCategoryId(5);

        Course course2 = new Course();
        course2.setId(2);
        course.setPrice(45.5);
        course2.setName("C#");
        course2.setEducatorId(1);
        course2.setCategoryId(4);

        Course course3 = new Course();
        course3.setId(3);
        course.setPrice(45.5);
        course3.setName("C#");
        course3.setEducatorId(1);
        course3.setCategoryId(4);

        Course course4 = new Course();
        course4.setId(3);
        course.setPrice(45.5);
        course4.setName("JavaScript");
        course4.setEducatorId(1);
        course4.setCategoryId(4);

        Course course5 = new Course();
        course5.setId(4);
        course.setPrice(45.5);
        course5.setName("Go");
        course5.setEducatorId(1);
        course5.setCategoryId(4);

        Course course6 = new Course(5,"PHP",50.1,2,5);



        CourseDao jdbcCourseDao = new JdbcCourseDao();
        CourseRules courseRules = new CourseRulesBussiness(jdbcCourseDao);

        CourseService courseService = new CourseManager(jdbcCourseDao,courseRules);
        courseService.add(course);
        courseService.add(course2);

        try {
             courseService.add(course3);
        }catch (Exception e){
            System.out.println("Hata: " + e.getMessage());
        }

        try {
        courseService.update(course4);
        courseService.add(course5);
        courseService.delete(course5);
        courseService.add(course6);
            List<Course> courses = courseService.getAllByName(course2.getName());
            for (Course cours:courses) {
                System.out.println(cours.getName());
            }
            System.out.println("------------------");
            List<Course> courses2 = courseService.getAll();
            for (Course cours:courses2) {
                System.out.println(cours.getName() + ", id:" +cours.getId());
            }
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }


    }
}
