package com.example.ipl.service;

import java.util.List;

import com.example.ipl.dto.BidderDto;
import com.example.ipl.dto.BiddingDto;
import com.example.ipl.dto.MatchDto;
import com.example.ipl.entities.Bidder;
import com.example.ipl.entities.BiddingDetails;
import com.example.ipl.exception.BidAlreadyExistForBidderException;
import com.example.ipl.exception.BidNotFoundException;
import com.example.ipl.exception.MatchNotFoundException;
import com.example.ipl.exception.TeamNotFoundException;
import com.example.ipl.exception.UserAlreadyExistException;
import com.example.ipl.exception.UserNotExistException;

public interface IBidderService {
public Bidder registerBidder(BidderDto bidderDto)throws UserAlreadyExistException;
public String loginBidder(BidderDto bidderDto) throws UserNotExistException;
public BiddingDetails addBid(BiddingDto biddingDto) throws BidAlreadyExistForBidderException,TeamNotFoundException;
public void updateBid(int biddingId,int teamId) throws BidNotFoundException;
public void deleteBidById(int bidderId)throws BidNotFoundException;
public List<MatchDto> getAllMatches() throws MatchNotFoundException;
public String getResult(int matchId) throws MatchNotFoundException;
}
