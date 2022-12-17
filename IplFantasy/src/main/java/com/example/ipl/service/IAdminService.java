package com.example.ipl.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.example.ipl.dto.AdminDto;
import com.example.ipl.dto.BidderDto;
import com.example.ipl.dto.MatchDto;
import com.example.ipl.dto.TeamDto;

import com.example.ipl.entities.MatchDetails;
import com.example.ipl.entities.TeamDetails;
import com.example.ipl.exception.BidderNotFoundException;
import com.example.ipl.exception.InvalidAdminException;
import com.example.ipl.exception.MatchAlreadyInProgressException;
import com.example.ipl.exception.MatchNotFoundException;
import com.example.ipl.exception.TeamAlreadyExistException;
import com.example.ipl.exception.TeamMemberException;
import com.example.ipl.exception.TeamNotFoundException;

public interface IAdminService {

	public String loginAdmin(AdminDto adminDto)throws InvalidAdminException;
	public MatchDetails addMatch(MatchDto matchDto)throws MatchAlreadyInProgressException;
	public TeamDetails addTeam(TeamDto teamDto)throws TeamAlreadyExistException,TeamMemberException;
	public void updateMatchByDate(int matchId,LocalDate date,LocalTime time) throws MatchNotFoundException;
	public void updateMatchByTeam(int matchId,int teamoneId,int teamtwoId) throws MatchNotFoundException;
	public void deleteMatchById(int matchId)throws MatchNotFoundException;
	public List<BidderDto> getAllBidder() throws BidderNotFoundException;
	public void updateScore(int bidderId ,int score)throws BidderNotFoundException;
	public void declareResult(int matchId ,int win)throws MatchNotFoundException;
	public void delelteTeam(String teamName) throws TeamNotFoundException;
	
	
}
