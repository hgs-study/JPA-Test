package com.hgstudy.domain.member.api;

import com.hgstudy.domain.member.application.MemberService;
import com.hgstudy.domain.member.entity.Member;
import com.hgstudy.domain.team.application.TeamService;
import com.hgstudy.domain.team.entity.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    private final TeamService teamService;


    @PostMapping("/bothwaysSave")
    public void bothwaysSave(){
        Team team1 = new Team("team1");
        teamService.save(team1);

        Member member1 = new Member("hyun",28,team1);
        Member member2 = new Member("kim",28,team1);
        memberService.save(member1);
        memberService.save(member2);

        team1.getMembers().add(member1);
        team1.getMembers().add(member2);

        List<Member> members = team1.getMembers();

        for (Member member : members) {
            System.out.println("member = " + member.getName());
        }
    }
}
