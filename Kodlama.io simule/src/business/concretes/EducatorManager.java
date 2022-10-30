package business.concretes;

import business.abstracts.EducatorService;
import business.concretes.constans.EducatorManagerMessages;
import core.exceptions.BusinessRulesException;
import core.exceptions.ValidatorException;
import core.logging.abstracts.Logger;
import core.rules.abstracts.EducatorRules;
import core.validator.abstracts.EducatorValid;
import dataAccess.abstracts.EducatorDao;
import entities.concretes.Educator;

import java.util.List;

public class EducatorManager implements EducatorService {

    private EducatorDao educatorDao;
    private EducatorRules educatorRules;
    private EducatorValid educatorValid;
    private Logger[] loggers;

    public EducatorManager(EducatorDao educatorDao, EducatorRules educatorRules, EducatorValid educatorValid, Logger[] loggers) {
        this.educatorDao = educatorDao;
        this.educatorRules = educatorRules;
        this.educatorValid = educatorValid;
        this.loggers = loggers;
    }

    @Override
    public void add(Educator educator) throws BusinessRulesException, ValidatorException {
        this.addBusinessCheck(educator);
        this.educatorDao.add(educator);
        this.log("Veritabanına eklendi: " + educator.getFirstName());
    }

    @Override
    public void update(Educator educator) throws BusinessRulesException, ValidatorException {
        this.updateBusinessCheck(educator);
        this.educatorDao.update(educator);
        this.log("Veritabanında güncellendi: " + educator.getFirstName());
    }

    @Override
    public void delete(Educator educator) {
        this.educatorDao.delete(educator);
        this.log("Veritabanından silindi: " + educator.getFirstName());
    }

    @Override
    public List<Educator> getAll() {
        return this.educatorDao.getAll();
    }

    @Override
    public Educator getById(int id) throws Exception {
        Educator educator = this.educatorDao.get(c -> c.getId() == id);
        if (educator == null)
            throw new Exception(EducatorManagerMessages.EDUCATOR_NOT_FOUND);
        return educator;
    }

    @Override
    public List<Educator> getAllByName(String name) {
        return this.educatorDao.getAll(c -> c.getFirstName().equals(name));
    }

    private void log(String data) {
        for (Logger logger : this.loggers) {
            logger.log(data);
        }
    }

    private void addBusinessCheck(Educator educator) throws BusinessRulesException, ValidatorException {
        this.educatorRules.educatorCannotBeNull(educator);
        this.educatorValid.isValid(educator);
        this.educatorRules.emailAlreadyExists(educator.getEmail());
    }

    private void updateBusinessCheck(Educator educator) throws BusinessRulesException, ValidatorException {
        this.educatorRules.educatorCannotBeNull(educator);
        this.educatorValid.isValid(educator);
        this.educatorRules.emailAlreadyExists(educator.getEmail());
    }
}
