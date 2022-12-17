package com.example.ipl.dto;

import com.example.ipl.entities.Bidder;
import com.example.ipl.entities.MatchDetails;
import com.example.ipl.entities.TeamDetails;


public class BiddingDto {
	private int biddingId;
	private MatchDetails matchDetails;
	private Bidder bidder;
	private TeamDetails teamDetails;
	public BiddingDto(int biddingId, MatchDetails matchDetails, Bidder bidder, TeamDetails teamDetails) {
		super();
		this.biddingId = biddingId;
		this.matchDetails = matchDetails;
		this.bidder = bidder;
		this.teamDetails = teamDetails;
	}
	public BiddingDto() {
		super();
		
	}
	public int getBiddingId() {
		return biddingId;
	}
	public void setBiddingId(int biddingId) {
		this.biddingId = biddingId;
	}
	public MatchDetails getMatchDetails() {
		return matchDetails;
	}
	public void setMatchDetails(MatchDetails matchDetails) {
		this.matchDetails = matchDetails;
	}
	public Bidder getBidder() {
		return bidder;
	}
	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
	}
	public TeamDetails getTeamDetails() {
		return teamDetails;
	}
	public void setTeamDetails(TeamDetails teamDetails) {
		this.teamDetails = teamDetails;
	}
	@Override
	public String toString() {
		return "BiddingDetails [biddingId=" + biddingId + ", matchDetails=" + matchDetails.getMatchId()+",staduim=" +matchDetails.getStadium()+ ", bidder=" + bidder
				+ ", teamDetails=" + teamDetails + "]";
	}
}
