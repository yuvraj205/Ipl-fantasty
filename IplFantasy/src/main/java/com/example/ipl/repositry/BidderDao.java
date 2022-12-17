package com.example.ipl.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import com.example.ipl.entities.Bidder;

public interface BidderDao extends JpaRepository<Bidder, Integer>{
	@Query("select e from Bidder e where e.userName=:username and e.password=:password")
	public List<Bidder> userExist(@Param(value ="username") String userName,@Param(value="password") String password);
    @Query("select e from Bidder e where e.email=:email")
	public List<Bidder> findByEmail(@Param(value ="email") String email);
    @Query("select e from Bidder e where e.userName=:userName")
    public List<Bidder> findByUserName(@Param(value ="userName") String userName);
    @Query("select b from Bidder b where b.biddingDetails.matchDetails.matchId=:matchId")
    public List<Bidder> findByMatchId(@Param(value="matchId") int matchId );
}
