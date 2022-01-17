package org.khalin.jpa_basic.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.khalin.jpa_basic.entity.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@SpringBootTest
@Transactional
@Rollback(false)
public class User2RepositoryTest {

    @Autowired
    User2Repository user2Repository;

    @Test
    public void querySingleRowTest(){
        List<User2> users = makeUserForTest();
        user2Repository.saveAll(users);

        Optional<User2> user = user2Repository.findById(1L);

        user.ifPresent(user2 -> Assertions.assertEquals(user2.getId(), 1L));

    }

    @Test
    public void queriesMultipleRowTest(){
        List<User2> users = makeUserForTest();
        user2Repository.saveAll(users);

        List<User2> selectList = user2Repository.findAll();

        Assertions.assertAll(
                () -> Assertions.assertEquals(selectList.get(0).getId(), 1L),
                () -> Assertions.assertEquals(selectList.get(1).getId(), 2L),
                () -> Assertions.assertEquals(selectList.get(10).getUserName(), "testUser11")
        );


    }


    private List<User2> makeUserForTest(){
        List<User2> list = new ArrayList<>();

        for(int i=1; i<40; i++){
           User2 user = User2.builder().userName("testUser" + i).build();
           list.add(user);
        }

        return list;
    }

}
