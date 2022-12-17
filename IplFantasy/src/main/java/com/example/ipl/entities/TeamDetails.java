package com.example.ipl.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="team_details")
public class TeamDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="teamid")
	private int teamId;
	@Column(name="teamname")
	private String teamName;
	@Column(name="numberofplayers")
	private int numberOfPlayers;
	
	public TeamDetails() {
		super();

	}
	public TeamDetails(int teamId, String teamName, int numberOfPlayers) {
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
	@Override
	public int hashCode() {
		return Objects.hash(numberOfPlayers, teamId, teamName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeamDetails other = (TeamDetails) obj;
		return numberOfPlayers == other.numberOfPlayers && teamId == other.teamId
				&& Objects.equals(teamName, other.teamName);
	}
	
	
}
