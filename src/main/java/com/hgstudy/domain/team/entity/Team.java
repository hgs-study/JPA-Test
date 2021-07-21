package com.hgstudy.domain.team.entity;

import com.hgstudy.domain.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
    private List<Member> members = new ArrayList<Member>();

    public Team(String name) {
        this.name = name;
    }

    public Team(String name, List<Member> members) {
        this.name = name;
        this.members = members;
    }
}
