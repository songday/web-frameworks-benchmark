package com.songday.benchmark.springboot3mvc.service;

import com.songday.benchmark.springboot3mvc.dao.PersonMapper;
import com.songday.benchmark.springboot3mvc.model.Person;
import io.github.scru128.Scru128;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonMapper personMapper;
    public Person getLatestPerson() {
        return personMapper.getLatestPerson();
    }

    public void savePerson(Person person) {
        personMapper.addPerson(person);
    }

    public Person genPerson() {
        Person person = new Person();
        person.setId(Scru128.generateString());
        person.setName("Name");
        person.setAge((short) 40);
        person.setDescription("This is my description. Nice to meet you.");
        return person;
    }
}
