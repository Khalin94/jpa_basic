package org.khalin.jpa_basic.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Builder @ToString @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class UserForAuditing extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String address;
    private int age;
}
