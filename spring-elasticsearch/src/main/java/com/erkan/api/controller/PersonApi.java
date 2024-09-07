package com.erkan.api.controller;

import com.erkan.business.PersonService;
import com.erkan.model.Person;
import jakarta.annotation.PostConstruct;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/person")
public
class PersonApi {

    private
    PersonService personService;

    public
    PersonApi ( PersonService personService ) {
        this.personService = personService;
    }

    @PostConstruct
    public void init(){
        Person person = new Person ();
        person.setFirstName ( "Yest" );
        person.setLastName ( "Noo" );
        person.setAddress ( "test" );
        person.setBirthDay (   Calendar.getInstance ().getTime ()  );
        person.setId ( "K0001" );
        personService.save ( person );
    }


    @GetMapping("/{search}")
    public
    ResponseEntity<List<Person>> getUsers( @PathVariable String search ){
        List<Person> people =  personService.getByCustomQuery(search);
        return ResponseEntity.ok ( people );
    }
}
