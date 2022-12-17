package com.example.ipl.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ipl.repositry.AdminMatchDao;
import com.example.ipl.repositry.AdminTeamDao;
import com.example.ipl.repositry.BidderDao;
import com.example.ipl.repositry.BidDao;
import com.example.ipl.dto.BidderDto;
import com.example.ipl.dto.BiddingDto;
import com.example.ipl.dto.MatchDto;
import com.example.ipl.entities.Bidder;
import com.example.ipl.entities.BiddingDetails;
import com.example.ipl.entities.MatchDetails;
import com.example.ipl.entities.TeamDetails;
import com.example.ipl.exception.BidAlreadyExistForBidderException;
import com.example.ipl.exception.BidNotFoundException;
import com.example.ipl.exception.MatchNotFoundException;
import com.example.ipl.exception.TeamNotFoundException;
import com.example.ipl.exception.UserAlreadyExistException;
import com.example.ipl.exception.UserNotExistException;
@Service
public class BidderServiceImpl implements IBidderService{
@Autowired
 BidderDao bidderDao;
@Autowired
  AdminMatchDao adminOperationDao;
@Autowired
  BidDao bidDao;
@Autowired
  AdminTeamDao adminTeamDao;
	@Override
	public Bidder registerBidder(BidderDto bidderDto) throws UserAlreadyExistException{
		if(bidderDao.findByEmail( bidderDto.getEmail()).isEmpty() && bidderDao.findByUserName(bidderDto.getUserName()).isEmpty())
		{
			Bidder bidder=new Bidder();
			bidder.setBidderId( bidderDto.getBidderId());
			bidder.setBiddingDetails( bidderDto.getBiddingDetails());
			bidder.setEmail( bidderDto.getEmail());
			bidder.setName( bidderDto.getName());
			bidder.setPassword( bidderDto.getPassword());
			bidder.setPhoneNo( bidderDto.getPhoneNo());
			bidder.setPoints( bidderDto.getPoints());
			bidder.setUserName( bidderDto.getUserName());
			return bidderDao.save(bidder);
		
		}
		else
		{
			throw new UserAlreadyExistException();
		}
			
			
           
		
		
	}
	@Override
	public String loginBidder(BidderDto bidderDto) {
		if(bidderDao.userExist(bidderDto.getUserName(), bidderDto.getPassword()).isEmpty())
		{
			throw new UserNotExistException();
		}
		else
		{
			return "Login succesfully";
		}
		
	}
	@Override
	public BiddingDetails addBid(BiddingDto biddingDto) throws BidAlreadyExistForBidderException,TeamNotFoundException{
	  if(bidDao.findByBidderId(biddingDto.getBidder().getBidderId())!=null)
	  {
		throw new BidAlreadyExistForBidderException();
	  }
	  else
	  {
		  if(adminOperationDao.existsByTeamId(biddingDto.getTeamDetails().getTeamId())!=null)
		  {
		  BiddingDetails biddingDetails=new BiddingDetails();
			biddingDetails.setBidder(biddingDto.getBidder());
			biddingDetails.setBiddingId(biddingDto.getBiddingId());
			biddingDetails.setMatchDetails(biddingDto.getMatchDetails());
			biddingDetails.setTeamDetails(biddingDto.getTeamDetails());
			return bidDao.save(biddingDetails);
		  }
		  else
		  {
			  throw new TeamNotFoundException();
		  }
	  }
	}
	@Override
	public List<MatchDto> getAllMatches() throws MatchNotFoundException {
		
		Iterable<MatchDetails> matchdetails=adminOperationDao.findAll();
		List<MatchDto> matchDtoList=new ArrayList<>();
		matchdetails.forEach(matches->{
			MatchDto matchDto=new MatchDto();
			matchDto.setDate(matches.getDate());
			matchDto.setMatchId(matches.getMatchId());
			matchDto.setStadium(matches.getStadium());
			matchDto.setTime(matches.getTime());
			matchDto.setTeamDetails1(matches.getTeamDetails1());
			matchDto.setTeamDetails2(matches.getTeamDetails2());
			matchDto.setWinner(matches.getWinner());
			matchDtoList.add(matchDto);
		});
		if(matchDtoList.isEmpty())
		{
			throw new MatchNotFoundException();
		}
	    return matchDtoList;
		
	}

	@Override
	public void updateBid(int bidderId,int teamId) throws BidNotFoundException{
		BiddingDetails biddingDetails=bidDao.findByBidderId(bidderId);
		if(biddingDetails!=null)
		{
		TeamDetails teamDetails=new TeamDetails();
		teamDetails.setTeamId(teamId);
		biddingDetails.setTeamDetails(teamDetails);
		bidDao.save(biddingDetails);
		}
		else
		{
			throw new BidNotFoundException();
		}
		
	}
	@Override
	public void deleteBidById(int bidderId) throws BidNotFoundException{

	BiddingDetails biddingDetails= bidDao.findByBidderId(bidderId);
		if(biddingDetails!= null)
		{
            int biddingId=biddingDetails.getBiddingId();
			bidDao.deleteById(biddingId);
	}
		else
		{
			throw new BidNotFoundException();
		}
	}
	@Override
	public String getResult(int matchId) throws MatchNotFoundException {
		if(adminOperationDao.existsById(matchId))
		{
		MatchDetails matchDetails=adminOperationDao.findById(matchId).get();
		MatchDto matchDto=new MatchDto();
		matchDto.setDate(matchDetails.getDate());
		matchDto.setMatchId(matchDetails.getMatchId());
		matchDto.setStadium(matchDetails.getStadium());
		matchDto.setTime(matchDetails.getTime());
		matchDto.setTeamDetails1(matchDetails.getTeamDetails1());
		matchDto.setTeamDetails2(matchDetails.getTeamDetails2());
		matchDto.setWinner(matchDetails.getWinner());
	    TeamDetails teamDetails= adminTeamDao.findById(matchDto.getWinner()).get();
	    return teamDetails.getTeamName();
		}
		else
		{
			throw new MatchNotFoundException();
		}
	}



}
