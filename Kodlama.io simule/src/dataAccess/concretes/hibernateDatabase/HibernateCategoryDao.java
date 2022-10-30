package dataAccess.concretes.hibernateDatabase;

import core.dataAccess.concretes.HibernateBaseEntityDao;
import dataAccess.abstracts.CategoryDao;
import entities.concretes.Category;

public class HibernateCategoryDao extends HibernateBaseEntityDao<Category> implements CategoryDao {
}
