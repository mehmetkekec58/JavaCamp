import business.abstracts.CategoryService;
import business.abstracts.CourseService;
import business.abstracts.EducatorService;
import business.concretes.CategoryManager;
import business.concretes.CourseManager;
import business.concretes.EducatorManager;
import core.logging.abstracts.Logger;
import core.logging.concretes.DatabaseLogger;
import core.logging.concretes.EmailLogger;
import core.logging.concretes.FileLogger;
import core.rules.abstracts.CategoryRules;
import core.rules.abstracts.CourseRules;
import core.rules.abstracts.EducatorRules;
import core.rules.concretes.CategoryRulesBusiness;
import core.rules.concretes.CourseRulesBusiness;
import core.rules.concretes.EducatorRulesBusiness;
import core.validator.abstracts.CategoryValid;
import core.validator.abstracts.CourseValid;
import core.validator.abstracts.EducatorValid;
import core.validator.concretes.CategoryValidator;
import core.validator.concretes.CourseValidator;
import core.validator.concretes.EducatorValidator;
import dataAccess.abstracts.CategoryDao;
import dataAccess.abstracts.CourseDao;
import dataAccess.abstracts.EducatorDao;
import dataAccess.concretes.hibernateDatabase.HibernateCategoryDao;
import dataAccess.concretes.jdbcDatabase.JdbcCourseDao;
import dataAccess.concretes.jdbcDatabase.JdbcEducatorDao;
import entities.concretes.Category;
import entities.concretes.Course;
import entities.concretes.Educator;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        course();
        System.out.println("-----------------------------------------------------------------------");
        category();
        System.out.println("-----------------------------------------------------------------------");
        educator();
    }

    public static void course() {
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

        Course course6 = new Course(5, "PHP", 50.1, 2, 2);
        Course course7 = new Course(6, "Python", 71.1, 7, 2);
        Course course8 = new Course(6, "JavaScript", 71.1, 7, 2);


        CourseDao jdbcCourseDao = new JdbcCourseDao();
        CourseRules courseRules = new CourseRulesBusiness(jdbcCourseDao);
        CourseValid courseValid = new CourseValidator();
        Logger[] loggers = new Logger[]{new DatabaseLogger(), new FileLogger()};

        CourseService courseService = new CourseManager(jdbcCourseDao, courseRules, courseValid, loggers);
        System.out.println("*******************************");
        try {
            courseService.add(course);  //veritaban??na ekler. hata yok
            courseService.add(course2); // hata verir. kurs fiyat?? 0'dan b??y??k olmal?? diye
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("*******************************");

        try {
            courseService.add(course3); //veritaban??na ekler. hata yok
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(courseService.getById(1).getName()); //id'ye g??re veritaban??ndan getirir. Java
            System.out.println(courseService.getById(10).getName()); //id'ye g??re veritaban??ndan getirir fakat hata verir. Kurs bulunamad??
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("*******************************");

        try {
            courseService.update(course4); // kursu g??nceller. C#'?? JavaScript yapar
            courseService.add(course5);  // Veritaban??na ekler. GO
            courseService.delete(course5); // Veritaban??ndan siler. GO
            courseService.add(course6);  // veritaban??ne ekler. PHP
            courseService.add(course7); //veritaban??ne ekler. Python

            Course cou = courseService.getByName(course.getName()); //ad java olan?? getirir
            System.out.println(cou.getName());

            List<Course> courses2 = courseService.getAll(); //veritaban??na ekli t??m dilleri getirir.
            for (Course cours : courses2) {
                System.out.println(cours.getName());
            }
            courseService.add(course8); // hata verir zaten Kurs kay??tl?? diye
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("*******************************");
    }

    public static void category() {
        Category category = new Category();
        category.setId(1);
        category.setName("Yaz??l??m");

        Category category1 = new Category(2, "Senior");

        Category category2 = new Category(3, "Yaz??l??m");

        CategoryDao categoryDao = new HibernateCategoryDao();
        CategoryRules categoryRules = new CategoryRulesBusiness(categoryDao);
        CategoryValid categoryValid = new CategoryValidator();
        Logger[] loggers = new Logger[]{new DatabaseLogger(), new EmailLogger()};

        CategoryService categoryService = new CategoryManager(categoryDao, categoryRules, categoryValid, loggers);

        try {
            categoryService.add(category); // veritaban??ne ekler. Yaz??l??m
            categoryService.add(category1); // veritaban??ne ekler. Senior
            categoryService.add(category2); // hata verir. Zaten kategori kay??tl??
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            categoryService.update(category2);// g??ncelleme yapmaz. Zaten kategori kay??tl??
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        List<Category> categories = categoryService.getAll();
        for (Category cate:categories) {
            System.out.println(cate.getName());
        }
    }

    public static void educator() {
        Educator educator = new Educator();
        educator.setId(1);
        educator.setFirstName("Mehmet");
        educator.setLastName("Keke??");
        educator.setEmail("deneme@gmail.com");

        Educator educator1 = new Educator(2, "Ahmet", "Ta??kesen", "der@gmail.com");
        Educator educator2 = new Educator(2, "Selim", "Helvac??", "deneme@gmail.com");
        Educator educator3 = new Educator(2, "Selim", "Helvac??", "hey@gmail.com");

        EducatorDao educatorDao = new JdbcEducatorDao();
        EducatorRules educatorRules = new EducatorRulesBusiness(educatorDao);
        EducatorValid educatorValid = new EducatorValidator();
        Logger[] loggers = new Logger[]{new FileLogger(), new EmailLogger()};
        EducatorService educatorService = new EducatorManager(educatorDao, educatorRules, educatorValid, loggers);

        try {
            educatorService.add(educator); // veritaban??ne ekler. Mehmet
            educatorService.add(educator1); // veritaban??ne ekler. Ahmet
            educatorService.add(educator2); // hata verir. E-posta zaten kay??tl??
            educatorService.add(educator3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        List<Educator> educators = educatorService.getAll();
        for (Educator educatorr : educators) {
            System.out.println(educatorr.getFirstName());
        }
    }
}
