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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ipl.dto.AdminDto;
import com.example.ipl.dto.BidderDto;
import com.example.ipl.dto.MatchDto;
import com.example.ipl.dto.TeamDto;
import com.example.ipl.exception.BidderNotFoundException;
import com.example.ipl.exception.InvalidAdminException;
import com.example.ipl.exception.MatchAlreadyInProgressException;
import com.example.ipl.exception.MatchNotFoundException;
import com.example.ipl.exception.TeamAlreadyExistException;
import com.example.ipl.exception.TeamMemberException;
import com.example.ipl.exception.TeamNotFoundException;
import com.example.ipl.service.IAdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
@Autowired
IAdminService adminService;

@PostMapping("/login")
public ResponseEntity<String> loginAdmin(@RequestBody  AdminDto adminDto) throws InvalidAdminException
{
	
	return new ResponseEntity<>(adminService.loginAdmin(adminDto),HttpStatus.OK);
}
@PostMapping("/match") 
public ResponseEntity<String> addMatch(@RequestBody MatchDto matchDto) throws MatchAlreadyInProgressException
{
	adminService.addMatch(matchDto);
	return new ResponseEntity<>("Match Add Succesfully",HttpStatus.CREATED);
}
@PostMapping("/team")
	public ResponseEntity<String> addTeam(@RequestBody  TeamDto teamDto) throws TeamAlreadyExistException,TeamMemberException
	{
	    adminService.addTeam(teamDto);
	      return new ResponseEntity<>("Team Add Successfully",HttpStatus.CREATED); 
	}
@PutMapping("/match/date/{matchId}") 
public ResponseEntity<String> updateMatchDate(@PathVariable int matchId ,  @RequestBody  MatchDto matchDto) throws MatchNotFoundException
{
	adminService.updateMatchByDate(matchId,matchDto.getDate(),matchDto.getTime());
	return new ResponseEntity<>("Match Update Succesfully",HttpStatus.OK);
}
@PutMapping("/match/team/{matchId}") 
public ResponseEntity<String> updateMatchTeam(@PathVariable int matchId ,  @RequestBody  MatchDto matchDto) throws MatchNotFoundException
{
	adminService.updateMatchByTeam(matchId,matchDto.getTeamDetails1().getTeamId(),matchDto.getTeamDetails2().getTeamId());
	return new ResponseEntity<>("Match Update Succesfully",HttpStatus.OK);
}
@DeleteMapping("/match/{matchId}") 
public ResponseEntity<String> deleteMatchById( @PathVariable  int matchId) throws MatchNotFoundException
{
	adminService.deleteMatchById(matchId);
	return new ResponseEntity<>(" Match Delete Succesfully",HttpStatus.OK); 
}
@GetMapping("/getbidders")
public ResponseEntity<List<BidderDto>> getAllBidder() throws BidderNotFoundException
{

	return new ResponseEntity<>(adminService.getAllBidder(),HttpStatus.OK); 
}
@PutMapping("/score/{bidderId}")
public ResponseEntity<String> updateScore(@PathVariable  int bidderId ,@RequestBody BidderDto bidderDto) throws BidderNotFoundException
{
	adminService.updateScore(bidderId,bidderDto.getPoints());
	return  new ResponseEntity<>("Points was updated",HttpStatus.OK) ;
}
@PutMapping("/result/{matchId}")
public ResponseEntity<String> declareResult(@PathVariable int matchId ,@RequestBody MatchDto matchDto) throws MatchNotFoundException
{
	adminService.declareResult(matchId, matchDto.getWinner());
	return  new ResponseEntity<>("Result is declared",HttpStatus.OK) ;
}
@DeleteMapping("/team/{teamName}")
public void delelteTeam(@PathVariable  String teamName) throws TeamNotFoundException
{
	adminService.delelteTeam(teamName);
}
}
