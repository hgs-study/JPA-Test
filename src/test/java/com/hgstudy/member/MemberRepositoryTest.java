package com.hgstudy.member;

import com.hgstudy.domain.member.application.MemberRepository;
import com.hgstudy.domain.member.application.MemberService;
import com.hgstudy.domain.member.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Rollback(value = false)
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager entityManager;



    @Test
    void saveTest(){
        final Member member = new Member("hyun",28);
        final Member savedMember = memberRepository.save(member);
        final Member findMember = memberRepository.findById(savedMember.getId()).get();

        assertEquals(member.getName(), findMember.getName());
    }


    @DisplayName("JPA 1차 캐시와 동일성 보장")
    @Test
    void jpaTest01(){
        Member member = new Member("hyun",28);
        entityManager.persist(member);

        Member findMember1 = entityManager.find(Member.class, 1L);
        Member findMember2 = entityManager.find(Member.class, 1L);

        assertEquals(findMember1, findMember2);
    }

    @DisplayName("변경 감지(더티체킹)")
    @Test
    void jpaTest02(){
        Member member = new Member("hyun",28);
        memberRepository.save(member);
        member.setName("kim");

        Member findMember = memberRepository.findByName("kim").get();

        assertEquals(findMember.getAge(), member.getAge());
    }


}
