package com.hgstudy.domain.team.application;

import com.hgstudy.domain.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {


}
