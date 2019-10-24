package org.janine.jian.domain;

import javax.persistence.*;

@Table(name = "user_role")
@Entity
public class UserRole {
    @Id
    @GeneratedValue
    @Column(name = "PK_ID")
    public Long id;
    @Column(name = "MEMBER_USER_ID")
    public String memberUserId;
    @Column(name = "MEMBER_ROLE_ID")
    public String memberRoleId;
}
