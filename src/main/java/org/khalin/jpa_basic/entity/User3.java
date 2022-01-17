package org.khalin.jpa_basic.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
@Entity
public class User3 {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String address;
    private int age;
    private LocalDateTime registerDate;
}
