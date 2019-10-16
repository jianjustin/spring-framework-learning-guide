package org.janine.jian.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue
    public int id;
    public String name;
    public int age;
    public String email;
}
