package com.example.ipl.dto;


public class TeamDto {
	
	private int teamId;
	
	private String teamName;
	
	private int numberOfPlayers;
	public TeamDto() {
		super();

	}
	public TeamDto(int teamId, String teamName, int numberOfPlayers) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.numberOfPlayers = numberOfPlayers;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	@Override
	public String toString() {
		return "TeamDetails [teamId=" + teamId + ", teamName=" + teamName + ", numberOfPlayers=" + numberOfPlayers
				+ "]";
	}
	
}
