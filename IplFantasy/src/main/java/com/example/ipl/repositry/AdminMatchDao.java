package com.example.ipl.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ipl.entities.MatchDetails;

public interface AdminMatchDao extends JpaRepository<MatchDetails, Integer>{
@Query("select m from MatchDetails m where m.teamDetails1.teamId=:teamId or m.teamDetails2.teamId=:teamId")
public MatchDetails existsByTeamId(@Param(value="teamId") int teamId);
}
