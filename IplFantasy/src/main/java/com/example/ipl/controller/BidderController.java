package com.example.ipl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ipl.dto.BidderDto;
import com.example.ipl.dto.BiddingDto;
import com.example.ipl.dto.MatchDto;
import com.example.ipl.exception.BidAlreadyExistForBidderException;
import com.example.ipl.exception.BidNotFoundException;
import com.example.ipl.exception.MatchNotFoundException;
import com.example.ipl.exception.TeamNotFoundException;
import com.example.ipl.exception.UserAlreadyExistException;
import com.example.ipl.exception.UserNotExistException;
import com.example.ipl.service.IBidderService;

@RestController
public class BidderController {
@Autowired
  IBidderService service;
  
  @PostMapping("/register")
  public ResponseEntity<String> registerBidder(@RequestBody BidderDto bidderDto) throws UserAlreadyExistException
  {
	  service.registerBidder(bidderDto);
	return new ResponseEntity<>("Register Succesfully",HttpStatus.OK);
  }
  @PostMapping("/login")
  public ResponseEntity<String> loginBidder(@ RequestBody BidderDto bidderDto) throws UserNotExistException
  {
	  service.loginBidder(bidderDto);
	  
	  return new ResponseEntity<>("Login Succesfully",HttpStatus.OK);
  }
  @PostMapping("/addbid")
  public ResponseEntity<String> addBid(@RequestBody  BiddingDto biddingDto) throws BidAlreadyExistForBidderException,TeamNotFoundException
  {
	  service.addBid(biddingDto);
	  return  new ResponseEntity<>("Bid Added Succesfully",HttpStatus.OK);
  }
  @PutMapping("/updatebid/{bidderId}")
  public ResponseEntity<String> updateBid(@PathVariable int bidderId,@RequestBody BiddingDto biddingDto ) throws BidNotFoundException
  {
	  service.updateBid(bidderId,biddingDto.getTeamDetails().getTeamId());
	  return new ResponseEntity<>("Bid Update Succesfully",HttpStatus.ACCEPTED);
  }
  @DeleteMapping("/{bidderId}")
  public ResponseEntity<String> deleteBidById(@PathVariable  int bidderId) throws BidNotFoundException
  {
	  service.deleteBidById(bidderId);
	  return new ResponseEntity<>("Delete succesfully",HttpStatus.OK);
  }
  @GetMapping("/getmatch") 
  public ResponseEntity<List<MatchDto>> getAllMatches() throws MatchNotFoundException 
  {
	  
	 return new  ResponseEntity<>(service.getAllMatches(),HttpStatus.FOUND);
  }
  @GetMapping("/result/{matchId}")
  public ResponseEntity<String> getResult(@PathVariable  int matchId) throws MatchNotFoundException
  {
	  
	  return new ResponseEntity<> (service.getResult(matchId),HttpStatus.FOUND);
  }
}
