package org.janine.jian.domain;

import javax.persistence.*;

@Entity
public class RandomCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    public String name;
}
