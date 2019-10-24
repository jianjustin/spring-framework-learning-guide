package org.janine.jian.domain;

import javax.persistence.*;

@Table(name = "app_role")
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name="role_name")
    public String roleName;

    @Column(name="description")
    public String description;
}
