package business.abstracts;

import core.exceptions.BusinessRulesException;
import core.exceptions.ValidatorException;
import entities.concretes.Course;
import entities.concretes.Educator;

import java.util.List;

public interface EducatorService {
    void add(Educator educator) throws BusinessRulesException, ValidatorException;

    void update(Educator educator) throws BusinessRulesException, ValidatorException;

    void delete(Educator educator);

    List<Educator> getAll();

    Educator getById(int id) throws Exception;

    List<Educator> getAllByName(String name);
}
