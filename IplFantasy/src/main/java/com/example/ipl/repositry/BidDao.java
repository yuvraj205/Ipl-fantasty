package com.example.ipl.repositry;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.ipl.entities.BiddingDetails;

public interface BidDao extends JpaRepository<BiddingDetails, Integer> {

	@Query("select b from BiddingDetails b where b.bidder.bidderId=:bidderId")
	public BiddingDetails findByBidderId(@Param (value="bidderId") int bidderId);
	@Modifying
	@Query("delete from BiddingDetails b where b.biddingId=:biddingId ")
	public void deleteById(@Param(value="biddingId") int biddingId);
	@Modifying
	@Query("delete from BiddingDetails b where b.matchDetails.matchId=:matchId")
	public void deleteByMatchId(@Param(value="matchId") int matchId);
}
