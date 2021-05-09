package org.janine.jian.springbootcurd.person;

import javax.persistence.*;

@Table(name = "person")
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "INT")
    private int id;
    
    @Column(name = "name", columnDefinition = "VARCHAR(50)")
    private String name;
    
    @Column(name = "age", columnDefinition = "INT")
    private int age;
    
    @Column(name = "email", columnDefinition = "VARCHAR(255)")
    private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
