package com.example.ipl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value= UserAlreadyExistException.class)
	public ResponseEntity<String> userAlreadyExist(UserAlreadyExistException e)
	{
		return new ResponseEntity<>("User Already Exist",HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value= UserNotExistException.class)
	public ResponseEntity<String> userNotFound(UserNotExistException e)
	{
		return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= InvalidAdminException.class)
	public ResponseEntity<String>  adminNotFound(InvalidAdminException e)
	{
		return new ResponseEntity<>("Admin not found",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= TeamAlreadyExistException.class)
	public ResponseEntity<String> teamAlreadyExist(TeamAlreadyExistException e)
	{
		return new ResponseEntity<>("Team Already Present",HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value= MatchNotFoundException.class)
	public ResponseEntity<String> matchNotFound(MatchNotFoundException e)
	{
		return new ResponseEntity<>("Match Not Found",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= MatchAlreadyInProgressException.class)
	public ResponseEntity<String> teamAlreadyExist(MatchAlreadyInProgressException e)
	{
		return new ResponseEntity<>("Match Already In Progress",HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value= BidderNotFoundException.class)
	public ResponseEntity<String> bidderNotFound(BidderNotFoundException e)
	{
		return new ResponseEntity<>("Bidder Not Found",HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value= BidAlreadyExistForBidderException.class)
	public ResponseEntity<String> bidAlreadyExist(BidAlreadyExistForBidderException e)
	{
		return new ResponseEntity<>("BidAlreadyExistForBidder",HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value= BidNotFoundException.class)
	public ResponseEntity<String> bidNotFound(BidNotFoundException e)
	{
		return new ResponseEntity<>("Bid Not found",HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value= TeamNotFoundException.class)
	public ResponseEntity<String> teamNotFound(TeamNotFoundException e)
	{
		return new ResponseEntity<>("Team not found",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= TeamMemberException.class)
	public ResponseEntity<String> teamMember(TeamMemberException e)
	{
		return new ResponseEntity<>("Give correct number of players",HttpStatus.FORBIDDEN);
	}
}
