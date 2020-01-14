package org.janine.jian.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    public PersonMapper personMapper;

    public List<Person> findAll(){
        return personMapper.findAll();
    }
}
