package com.hgstudy.domain.member.application;

import com.hgstudy.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    public Member findById(Long id){
        return memberRepository.findById(id)
                                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
    }

    public void save(Member member){
        memberRepository.save(member);
    }


    public Optional<Member> findByName(String name){
        return memberRepository.findByName(name);
    }

}
