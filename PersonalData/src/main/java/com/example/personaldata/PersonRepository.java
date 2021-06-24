package com.example.personaldata;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long>{


    public Optional<Person> findPersonByPESEL(Long pesel);

}
