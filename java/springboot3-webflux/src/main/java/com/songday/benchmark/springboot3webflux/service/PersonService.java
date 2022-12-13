package com.songday.benchmark.springboot3webflux.service;

import com.songday.benchmark.springboot3webflux.model.Person;
import com.songday.benchmark.springboot3webflux.repository.PersonRepository;
import io.github.scru128.Scru128;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public Mono<Person> getLatestPerson() {
        return personRepository.getLatestPerson();
    }

    public Mono<Person> savePerson(Person person) {
        return personRepository.save(person);
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
