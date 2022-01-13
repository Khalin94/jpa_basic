package org.khalin.jpa_basic.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @Setter @NoArgsConstructor
@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String userName;
    private int age;

    @Builder
    public Member(Long id, String userName, int age){
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

}
