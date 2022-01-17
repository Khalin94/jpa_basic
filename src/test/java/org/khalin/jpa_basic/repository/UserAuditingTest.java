package org.khalin.jpa_basic.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.khalin.jpa_basic.entity.User3;
import org.khalin.jpa_basic.entity.UserForAuditing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UserAuditingTest {

    @Autowired
    UserForAuditingRepository userRepository;

    @Test
    public void AuditingTest() {
        UserForAuditing user = UserForAuditing.builder()
                .userName("testUser")
                .address("korea")
                .age(20)
                .build();

        UserForAuditing saveUser = userRepository.save(user);
        System.out.println("saveUser :: " + saveUser);

        Optional<UserForAuditing> selectedUser = userRepository.findById(1L);

        if(selectedUser.isPresent()) {
            System.out.println("created At : " + selectedUser.get().getCreatedAt());
            System.out.println("updated At : " + selectedUser.get().getUpdatedAt());
        }

        selectedUser.ifPresent(selUser -> Assertions.assertNotNull(selUser.getCreatedAt()));
        selectedUser.ifPresent(selUser -> Assertions.assertNotNull(selUser.getUpdatedAt()));

        Optional<UserForAuditing> updatedUser = userRepository.findById(1L);
        updatedUser.get().setUserName("USA");

        UserForAuditing modifiedUser = userRepository.save(updatedUser.get());

        Assertions.assertEquals(selectedUser.get().getId(), modifiedUser.getId());

    }
}
