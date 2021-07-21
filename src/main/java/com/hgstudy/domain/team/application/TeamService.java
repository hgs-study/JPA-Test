package com.hgstudy.domain.team.application;

import com.hgstudy.domain.member.entity.Member;
import com.hgstudy.domain.team.entity.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TeamService {

    private final TeamRepository teamRepository;


    public Team findById(Long id){
        return teamRepository.findById(id)
                                .orElseThrow(() -> new IllegalArgumentException("not found the team"));
    }

    @Transactional
    public void save(Team team){
        teamRepository.save(team);
    }
}
