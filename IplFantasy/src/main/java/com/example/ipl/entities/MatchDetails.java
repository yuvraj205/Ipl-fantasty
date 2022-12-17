package com.example.ipl.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="match_details")
public class MatchDetails {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="match_id")
private int matchId;
@Column(name="match_date")
private LocalDate date;
@Column(name="match_time")
private LocalTime time;
@Column(name="match_stadium")
private String stadium;
@Column(name="winner")
private int winner;
@OneToOne
@JoinColumn(name="team_one_id")
TeamDetails teamDetails1;
@OneToOne
@JoinColumn(name="team_two_id")
TeamDetails teamDetails2;
public MatchDetails() {
	super();
	
}
public MatchDetails(int matchId, LocalDate date, LocalTime time, String stadium, int winner, TeamDetails teamDetails1,
		TeamDetails teamDetails2) {
	super();
	this.matchId = matchId;
	this.date = date;
	this.time = time;
	this.stadium = stadium;
	this.winner = winner;
	this.teamDetails1 = teamDetails1;
	this.teamDetails2 = teamDetails2;
}
public int getMatchId() {
	return matchId;
}
public void setMatchId(int matchId) {
	this.matchId = matchId;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public LocalTime getTime() {
	return time;
}
public void setTime(LocalTime time) {
	this.time = time;
}
public String getStadium() {
	return stadium;
}
public void setStadium(String stadium) {
	this.stadium = stadium;
}
public int getWinner() {
	return winner;
}
public void setWinner(int winner) {
	this.winner = winner;
}
public TeamDetails getTeamDetails1() {
	return teamDetails1;
}
public void setTeamDetails1(TeamDetails teamDetails1) {
	this.teamDetails1 = teamDetails1;
}
public TeamDetails getTeamDetails2() {
	return teamDetails2;
}
public void setTeamDetails2(TeamDetails teamDetails2) {
	this.teamDetails2 = teamDetails2;
}
@Override
public String toString() {
	return "MatchDetails [matchId=" + matchId + ", date=" + date + ", time=" + time + ", stadium=" + stadium
			+ ", winner=" + winner + ", teamDetails1=" + teamDetails1 + ", teamDetails2=" + teamDetails2 + "]";
}
@Override
public int hashCode() {
	return Objects.hash(date, matchId, stadium, teamDetails1, teamDetails2, time, winner);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	MatchDetails other = (MatchDetails) obj;
	return Objects.equals(date, other.date) && matchId == other.matchId && Objects.equals(stadium, other.stadium)
			&& Objects.equals(teamDetails1, other.teamDetails1) && Objects.equals(teamDetails2, other.teamDetails2)
			&& Objects.equals(time, other.time) && winner == other.winner;
}


}
