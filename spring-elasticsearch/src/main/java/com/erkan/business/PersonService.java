package com.erkan.business;

import com.erkan.model.Person;
import com.erkan.repository.PersonRepo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class PersonService {
    private
    PersonRepo personRepo;

    public
    PersonService ( PersonRepo personRepo ) {
        this.personRepo = personRepo;
    }

    public
    List<Person> getByCustomQuery ( String search ) {
        return personRepo.getByCustomQuery(search);
    }

    public
    void save ( Person person ) {
    }
}
