package com.songday.benchmark.springboot3mvc.controller;

import com.songday.benchmark.springboot3mvc.model.Person;
import com.songday.benchmark.springboot3mvc.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;
    @GetMapping("person/get")
    public Person get() {
        personService.savePerson(personService.genPerson());
        return personService.getLatestPerson();
    }
}
