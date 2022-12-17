package com.example.ipl.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ipl.entities.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer>  {
	@Query("select a from Admin a where a.userName=:username and a.password=:password")
    public List<Admin> findAdmin(@Param(value="username")  String userName,@Param(value="password") String password);
}
