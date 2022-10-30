package dataAccess.concretes.jdbcDatabase;

import core.dataAccess.concretes.JdbcBaseEntityDao;
import dataAccess.abstracts.CourseDao;
import entities.concretes.Course;

public class JdbcCourseDao extends JdbcBaseEntityDao<Course> implements CourseDao {

}
