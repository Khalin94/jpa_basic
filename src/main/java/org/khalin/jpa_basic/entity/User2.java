package org.khalin.jpa_basic.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
public class User2 {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String userName;

}
