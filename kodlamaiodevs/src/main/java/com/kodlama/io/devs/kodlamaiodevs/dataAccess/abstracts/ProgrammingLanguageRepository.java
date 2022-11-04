package com.kodlama.io.devs.kodlamaiodevs.dataAccess.abstracts;

import java.util.List;
import java.util.function.Predicate;

import com.kodlama.io.devs.kodlamaiodevs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {
    void add(ProgrammingLanguage programmingLanguage);
    void update(ProgrammingLanguage programmingLanguage);
    void delete(ProgrammingLanguage programmingLanguage);
    ProgrammingLanguage getById(int id);
    ProgrammingLanguage getByName(String name);
    List<ProgrammingLanguage> getAll();
    List<ProgrammingLanguage> getAll(Predicate<? super ProgrammingLanguage> filter);
}
