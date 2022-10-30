package dataAccess.concretes.jdbcDatabase;

import core.dataAccess.concretes.JdbcBaseEntityDao;
import dataAccess.abstracts.CategoryDao;
import entities.concretes.Category;

public class JdbcCategoryDao extends JdbcBaseEntityDao<Category> implements CategoryDao {

}
