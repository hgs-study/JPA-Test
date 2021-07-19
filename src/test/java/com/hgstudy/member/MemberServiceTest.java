package com.hgstudy.member;

import com.hgstudy.domain.member.application.MemberRepository;
import com.hgstudy.domain.member.application.MemberService;
import com.hgstudy.domain.member.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @InjectMocks
    MemberService memberService;

    @Mock
    MemberRepository memberRepository;

    @DisplayName("save 확인")
    @Test
    void save(){
        final Member member = new Member(1L,"hyun",28);

        given(memberService.findByName("hyun")).willReturn(Optional.of(member));
        Member findMember = memberService.findByName("hyun").get();

        verify(memberRepository,times(1)).findByName(anyString());
        assertEquals(findMember.getId(),1L);
        assertEquals(findMember.getName(),"hyun");
        assertEquals(findMember.getAge(),28);
    }
}
