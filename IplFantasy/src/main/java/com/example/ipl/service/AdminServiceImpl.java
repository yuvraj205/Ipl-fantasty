package com.example.ipl.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ipl.repositry.AdminDao;
import com.example.ipl.repositry.AdminMatchDao;
import com.example.ipl.repositry.AdminTeamDao;
import com.example.ipl.repositry.BidderDao;
import com.example.ipl.repositry.BidDao;
import com.example.ipl.dto.AdminDto;
import com.example.ipl.dto.BidderDto;

import com.example.ipl.dto.MatchDto;
import com.example.ipl.dto.TeamDto;

import com.example.ipl.entities.Bidder;

import com.example.ipl.entities.MatchDetails;
import com.example.ipl.entities.TeamDetails;
import com.example.ipl.exception.BidderNotFoundException;
import com.example.ipl.exception.InvalidAdminException;
import com.example.ipl.exception.MatchAlreadyInProgressException;
import com.example.ipl.exception.MatchNotFoundException;
import com.example.ipl.exception.TeamAlreadyExistException;
import com.example.ipl.exception.TeamMemberException;
import com.example.ipl.exception.TeamNotFoundException;
@Service
@Transactional
public class AdminServiceImpl implements IAdminService {
  @Autowired
  AdminDao adminDao;
  @Autowired
  AdminMatchDao adminMatchDao;
  @Autowired
  AdminTeamDao adminTeamDao;
  @Autowired
  BidderDao bidderDao;
  @Autowired
  BidDao bidDao;
  
	@Override
	public String loginAdmin(AdminDto adminDto) throws InvalidAdminException{
		if(adminDao.findAdmin(adminDto.getUserName(),adminDto.getPassword()).isEmpty())
		{
			throw new InvalidAdminException();
		}
		else
		{
		  return "Login Succesfully";
		}
	}
	@Override
	public MatchDetails addMatch(MatchDto matchDto) throws MatchAlreadyInProgressException{
		if(adminMatchDao.findAll().isEmpty())
		{
			MatchDetails matchDetails=new MatchDetails();
			matchDetails.setDate(matchDto.getDate());
			matchDetails.setMatchId(matchDto.getMatchId());
			matchDetails.setStadium(matchDto.getStadium());
			matchDetails.setTime(matchDto.getTime());
			matchDetails.setWinner(matchDto.getWinner());
			matchDetails.setTeamDetails1(matchDto.getTeamDetails1());
			matchDetails.setTeamDetails2(matchDto.getTeamDetails2());
			return adminMatchDao.save(matchDetails);
		  
		}
		else
		{
			  throw new MatchAlreadyInProgressException();
		}
		
	}
	@Override
	public TeamDetails addTeam(TeamDto teamDto) throws TeamAlreadyExistException ,TeamMemberException {
		if(teamDto.getNumberOfPlayers()==15)
		{
		if(adminTeamDao.findByName(teamDto.getTeamName())==null)
		{
		TeamDetails teamDetails=new TeamDetails();
		teamDetails.setNumberOfPlayers(teamDto.getNumberOfPlayers());
		teamDetails.setTeamId(teamDto.getTeamId());
		teamDetails.setTeamName(teamDto.getTeamName());
		return adminTeamDao.save(teamDetails);
		}
		
		else
		{
			throw new TeamAlreadyExistException();
		}
		}
		else
		{
			throw new TeamMemberException();
		}
		
		
	}
	@Override
	public void updateMatchByDate(int matchId ,LocalDate date,LocalTime time) throws MatchNotFoundException{
		if(adminMatchDao.findById(matchId).isEmpty())
		{
			throw new MatchNotFoundException();
		}
		else
		{
         MatchDetails matchDetails=adminMatchDao.findById(matchId).get();
         matchDetails.setDate(date);
         matchDetails.setTime(time);
		 adminMatchDao.save(matchDetails);
		}
	}
	@Override
	public void updateMatchByTeam(int matchId,int teamoneId,int teamtwoId) throws MatchNotFoundException
	{
		if(adminMatchDao.findById(matchId).isEmpty())
		{
			throw new MatchNotFoundException();
		}
		else {
			MatchDetails matchDetails=adminMatchDao.findById(matchId).get();
			  TeamDetails teamone=new TeamDetails();
			  teamone.setTeamId(teamoneId);
			  TeamDetails teamtwo=new TeamDetails();
			  teamtwo.setTeamId(teamtwoId);
			  matchDetails.setTeamDetails1(teamone);
			  matchDetails.setTeamDetails2(teamtwo);
			  adminMatchDao.save(matchDetails);
		}
		   
	}
	@Override
	public void deleteMatchById(int matchId) throws MatchNotFoundException{
	    bidDao.deleteByMatchId(matchId);
		Optional<MatchDetails> optional= adminMatchDao.findById(matchId);
	    optional.orElseThrow(()-> new MatchNotFoundException());
		adminMatchDao.deleteById(matchId);
		
	}
	@Override
	public List<BidderDto> getAllBidder()  throws BidderNotFoundException{
		Iterable<Bidder> bidder = bidderDao.findAll();
		List<BidderDto> bidderDtoList=new ArrayList<>();
		bidder.forEach(bidders->{
			BidderDto bidderDto=new BidderDto();
		    bidderDto.setBidderId(bidders.getBidderId());
		    bidderDto.setBiddingDetails(bidders.getBiddingDetails());
		    bidderDto.setEmail(bidders.getEmail());
		    bidderDto.setName(bidders.getName());
		    bidderDto.setPassword(bidders.getPassword());
		    bidderDto.setPhoneNo(bidders.getPhoneNo());
		    bidderDto.setPoints(bidders.getPoints());
		    bidderDto.setUserName(bidders.getUserName());
		    bidderDtoList.add(bidderDto);
		    
		});
		if(bidderDtoList.isEmpty())
		{
			throw new BidderNotFoundException();
		
		}
		else
			return bidderDtoList;
	}
	@Override
	public void updateScore(int bidderId, int score) throws BidderNotFoundException{
		  if(bidderDao.existsById(bidderId))
		  {

	      Bidder b= bidderDao.findById(bidderId).get();
	      b.setPoints(score);      
		  bidderDao.save(b);
		  }
		  else
		  {
			  throw new BidderNotFoundException();
		  }
	}
	@Override
	public void declareResult(int matchId, int win) throws MatchNotFoundException {
		if(adminMatchDao.existsById(matchId))
		{
		MatchDetails matchDetails=adminMatchDao.findById(matchId).get();
		matchDetails.setWinner(win);
		adminMatchDao.save(matchDetails);
		List<Bidder> bidderList= bidderDao.findByMatchId(matchId);
		   for(Bidder bidder:bidderList)
		   {
			   if(bidder.getBiddingDetails().getTeamDetails().getTeamId()==win)
			   {
				   int point=bidder.getPoints()+1;
				   bidder.setPoints(point);
			   }
		   }
		}
		else
		{
			throw new MatchNotFoundException();
		}
	}
	@Override
	public void delelteTeam(String teamName) throws TeamNotFoundException {
		TeamDetails teamDetails=adminTeamDao.findByName(teamName);
		if(teamDetails==null)
		{
			throw new TeamNotFoundException();
		}
		else {
			adminTeamDao.deleteById(teamDetails.getTeamId());
		}
	}

}
