package org.khalin.jpa_basic.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.khalin.jpa_basic.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void saveMemberTest(){
        //given
        long id = 2L;
        String name = "testName";
        int age = 20;

        //when
        Member member = Member.builder()
                .userName(name)
                .age(age)
                .id(id)
                .build();
        Member saveMember = memberRepository.save(member);

        //then
        Assertions.assertEquals(saveMember.getAge(), age);
        Assertions.assertEquals(saveMember.getUserName(), name);

    }
}
