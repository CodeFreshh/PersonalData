package com.example.personaldata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PersonManager {

    Person person = new Person();

    private PersonRepository personRepository;


    @Autowired
    public PersonManager(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public Optional<Person> findbyid(Long id){

        return personRepository.findById(id);

    }

    public Optional<Person> fin(Long pesel){
        return personRepository.findPersonByPESEL(pesel);
    }



    public Iterable<Person> findall(){

        return personRepository.findAll();
    }

    public Person save(Person person){

        return personRepository.save(person);
    }
    public void deleteById(Long id){
        personRepository.deleteById(id);

    }
    @EventListener(ApplicationReadyEvent.class)
    public void FillDB(){
        save(new Person( 1L, "Kuba", "Nowicki", 99031205479L, "male", LocalDate.of(1999, 3, 12)));
        save(new Person(  2L, "Mateusz", "Nowak", 94080605479L, "male", LocalDate.of(1994, 8, 6)));
        save(new Person(  3L, "Karolina", "Lewandowska", 89080705480L, "Female", LocalDate.of(1989, 8, 7)));
    }

}
