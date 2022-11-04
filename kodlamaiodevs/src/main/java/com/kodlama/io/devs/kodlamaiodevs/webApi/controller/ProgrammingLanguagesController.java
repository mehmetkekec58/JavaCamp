package com.kodlama.io.devs.kodlamaiodevs.webApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.devs.kodlamaiodevs.business.abstracts.ProgrammingLanguageService;
import com.kodlama.io.devs.kodlamaiodevs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguage")
public class ProgrammingLanguagesController {
    private ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @PostMapping()
    public String add(@RequestBody ProgrammingLanguage programmingLanguage) {

        return programmingLanguageService.add(programmingLanguage);

    }

    @PutMapping()
    public String update(@RequestBody ProgrammingLanguage programmingLanguage) {
        return programmingLanguageService.update(programmingLanguage);
    }

    @DeleteMapping()
    public String delete(@RequestBody ProgrammingLanguage programmingLanguage) {
        return programmingLanguageService.delete(programmingLanguage);
    }

    @GetMapping()
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageService.getAll();
    }

    @GetMapping("/{id}")
    public ProgrammingLanguage getById(@PathVariable("id") int id) {
        return programmingLanguageService.get(id);
    }

}
