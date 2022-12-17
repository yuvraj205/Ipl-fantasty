package com.example.ipl.dto;



import java.time.LocalDate;
import java.time.LocalTime;



import com.example.ipl.entities.TeamDetails;

public class MatchDto {
	
	
	private int matchId;
	
	private LocalDate date;
	
	private LocalTime time;
	
	private String stadium;
	
	private int winner;

	TeamDetails teamDetails1;

	TeamDetails teamDetails2;
	public MatchDto() {
		super();

	}
	public MatchDto(int matchId, LocalDate date, LocalTime time, String stadium, int winner, TeamDetails teamDetails1,
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

	
}
