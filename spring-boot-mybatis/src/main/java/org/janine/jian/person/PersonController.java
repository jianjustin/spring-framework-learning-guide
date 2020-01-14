package org.janine.jian.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    public PersonService personService;

    @GetMapping("/persons")
    public List<Person> findAll(){
        return personService.findAll();
    }
}
