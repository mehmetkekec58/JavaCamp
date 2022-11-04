package com.kodlama.io.devs.kodlamaiodevs.business.abstracts;

import java.util.List;

import com.kodlama.io.devs.kodlamaiodevs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
    String add(ProgrammingLanguage programmingLanguage);
    String update(ProgrammingLanguage programmingLanguage);
    String delete(ProgrammingLanguage programmingLanguage);
    ProgrammingLanguage get(int id);
    List<ProgrammingLanguage> getAll();
    
}
