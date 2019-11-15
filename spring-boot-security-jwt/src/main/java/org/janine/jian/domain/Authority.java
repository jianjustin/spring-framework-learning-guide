package org.janine.jian.domain;

import javax.persistence.*;

@Table(name = "authority")
@Entity
public class Authority {
    @Id
    @GeneratedValue
    @Column(name = "PK_ID")
    public Long id;
    @Column(name = "MEMBER_RESOURCE_ROUTER")
    public String memberResourceRouter;
}
