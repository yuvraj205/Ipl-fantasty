package com.example.ipl.repositry;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ipl.entities.TeamDetails;

public interface AdminTeamDao extends JpaRepository<TeamDetails, Integer>{
@Query("select t from TeamDetails t  where t.teamName=:teamName" )
public TeamDetails findByName(@Param(value="teamName") String teamName);
}
