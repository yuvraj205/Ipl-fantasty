package com.example.ipl.entities;

import java.util.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="bidding_details")
public class BiddingDetails {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY )
@Column(name="bidding_id")
private int biddingId;
@OneToOne
@JoinColumn(name="matchId")
private MatchDetails matchDetails;
@OneToOne
@JoinColumn(name="bidderId")
@JsonIgnore
private Bidder bidder;
@OneToOne
@JoinColumn(name="teamId")
private TeamDetails teamDetails;
public BiddingDetails(int biddingId, MatchDetails matchDetails, Bidder bidder, TeamDetails teamDetails) {
	super();
	this.biddingId = biddingId;
	this.matchDetails = matchDetails;
	this.bidder = bidder;
	this.teamDetails = teamDetails;
}
public BiddingDetails() {
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
	return "BiddingDetails [biddingId=" + biddingId + ", matchDetails=" + matchDetails.getMatchId()+",staduim=" +matchDetails.getStadium() + ", bidder=" + bidder
			+ ", teamDetails=" + teamDetails + "]";
}
@Override
public int hashCode() {
	return Objects.hash(bidder, biddingId, matchDetails, teamDetails);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	BiddingDetails other = (BiddingDetails) obj;
	return Objects.equals(bidder, other.bidder) && biddingId == other.biddingId
			&& Objects.equals(matchDetails, other.matchDetails) && Objects.equals(teamDetails, other.teamDetails);
}


}

