package com.kodlama.io.devs.kodlamaiodevs.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.devs.kodlamaiodevs.business.abstracts.ProgrammingLanguageService;
import com.kodlama.io.devs.kodlamaiodevs.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.kodlama.io.devs.kodlamaiodevs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

    private ProgrammingLanguageRepository programmingLanguageRepository;

    
    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public String add(ProgrammingLanguage programmingLanguage) {
        try {
            
            programmingLanguageCannotRepeatName(programmingLanguage.getName());
            programmingLanguageNameCannotBeEmpty(programmingLanguage);
           
        } catch (Exception e) {
            return e.getMessage();
        }
        programmingLanguageRepository.add(programmingLanguage);
        return "Başarıyla eklendi.";
    }

    @Override
    public String update(ProgrammingLanguage programmingLanguage) {
        try {
            
            programmingLanguageCannotRepeatName(programmingLanguage.getName());
            programmingLanguageNameCannotBeEmpty(programmingLanguage);
           
        } catch (Exception e) {
            return e.getMessage();
        }
        programmingLanguageRepository.update(programmingLanguage);
        return "Başarıyla güncellendi.";
        
    }

    @Override
    public String delete(ProgrammingLanguage programmingLanguage) {
        programmingLanguageRepository.delete(programmingLanguage);
        return "Başarıyla silindi.";
        
    }

    @Override
    public ProgrammingLanguage get(int id) {
        return programmingLanguageRepository.getById(id);
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageRepository.getAll();
    }

    private void programmingLanguageCannotRepeatName(String name) throws Exception{
         ProgrammingLanguage programmingLanguage = programmingLanguageRepository.getByName(name);
         if(programmingLanguage != null)
         throw new Exception("Programlama dili zaten kayıtlı");
    }
    private void programmingLanguageNameCannotBeEmpty(ProgrammingLanguage programmingLanguage) throws Exception{
        if(programmingLanguage.getName().isEmpty())
        throw new Exception("Programlama dili boş geçilemez.");
    }
    
}
