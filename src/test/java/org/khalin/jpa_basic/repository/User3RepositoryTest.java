package org.khalin.jpa_basic.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.khalin.jpa_basic.entity.User3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class User3RepositoryTest {

    @Autowired
    User3Repository user3Repository;

    @Test
    public void findUserNameAndAddress(){
        String userName = "testUser";
        String address = "Busan";

        User3 user = User3.builder()
                .userName(userName)
                .address(address)
                .age(29)
                .registerDate(LocalDateTime.now())
                .build();
        user3Repository.save(user);

        Optional<User3> selectUser = user3Repository.findByUserNameAndAddress(userName, address);

        selectUser.ifPresent(user3 -> Assertions.assertEquals(user3.getAge(), 29));

        selectUser.ifPresentOrElse(
                userOptional -> Assertions.assertEquals(userOptional.getAge(), 29),
                Assertions::fail
        );

        if(selectUser.isEmpty()){
            fail();
        }else{
            User3 user3 = selectUser.get();
            Assertions.assertEquals(user3.getUserName(), userName);
        }
    }

    @Test
    public void findByAddressTest(){
        String[] addresses = {"seoul", "busan", "daegeon", "daegu"};
        List<User3> users = new ArrayList<>();
        int adsCount = 0;
        for(int i=1; i<=8; i++){
            User3 user = User3.builder()
                    .userName("testUser" + i)
                    .age(20+i)
                    .address(addresses[adsCount])
                    .registerDate(LocalDateTime.now())
                    .build();
            users.add(user);

            if(adsCount == 3){
                adsCount = 0;
            }else{
                adsCount++;
            }
        }
        user3Repository.saveAll(users);
        for(User3 u : users){
            System.out.println("uuuuuuu : " + u.toString());
        }
        PageRequest request = PageRequest.of(0, 1);
        List<User3> selectedUser = (List<User3>) user3Repository.findAllByAddress("daegu", request);
        Assertions.assertEquals(selectedUser.get(0).getAddress(), "daegu");

        List<User3> selectedUser2 = (List<User3>) user3Repository.findAllByAddress("seoul", request);

        Assertions.assertEquals(selectedUser2.get(0).getAddress(), "seoul");
    }
}
