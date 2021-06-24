package com.example.personaldata;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/person")
public class PersonApi {

    private PersonManager personManager;

    private List<Person> personList;


    @Autowired
    public PersonApi(PersonManager personManager){

        this.personManager = personManager;
        personList = new ArrayList<>();
        personList.add(new Person( 1L, "Kuba", "Nowicki", 99031205479L, "Male", LocalDate.of(1999, 3, 12)));
        personList.add(new Person(  2L, "Mateusz", "Nowak", 94080605479L, "Male", LocalDate.of(1994, 8, 6)));
        personList.add(new Person(  3L, "Karolina", "Lewandowska", 89080705480L, "Female", LocalDate.of(1989, 8, 7)));

    }



    @GetMapping("/all")
    public Iterable<Person> getAll() {

        return personManager.findall();
    }

    @GetMapping("/id")
    public Optional<Person> getById(@RequestParam long index) {

        return personManager.findbyid(index);
    }


    @GetMapping("/pesel")
    public Optional<Person> getbyPesel(@RequestParam long pesel){
        return personManager.fin(pesel);
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person){
        return personManager.save(person);
    }

    @PutMapping
    public Person updatePerson(@RequestBody Person person){
        return personManager.save(person);
    }


    @DeleteMapping
    public void deletePerson(@RequestParam Long index) {
        personManager.deleteById(index);

    }

}

