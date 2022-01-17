package org.khalin.jpa_basic.controller;

import lombok.RequiredArgsConstructor;
import org.khalin.jpa_basic.entity.User3;
import org.khalin.jpa_basic.repository.User3Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final User3Repository userRepository;

    @GetMapping("/users")
    public Page<User3> getAllUsers(){
        PageRequest pageRequest = PageRequest.of(0, 5);
        return userRepository.findAll(pageRequest);
    }

    @GetMapping("/users/ads")
    public Page<User3> getAllUserWithAddress(@Param("page") Integer page, @Param("size") Integer size){
        PageRequest pageRequest = PageRequest.of(page, size);
        return userRepository.findAllByAddress("seoul", pageRequest);
    }

    @PostConstruct
    public void init(){
        for(int i=0; i<100; i++){
            User3 user = User3.builder()
                    .userName("testUser" +i)
                    .age(i)
                    .address("seoul")
                    .registerDate(LocalDateTime.now())
                    .build();
            userRepository.save(user);
        }
    }
}
