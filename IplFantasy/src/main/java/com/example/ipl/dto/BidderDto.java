package com.example.ipl.dto;

import com.example.ipl.entities.BiddingDetails;

public class BidderDto {


	private int bidderId;

	private String userName;

	private String password;

	private String name;

	private String email;

	private String phoneNo;

	private int points;

	private BiddingDetails biddingDetails;

	public BiddingDetails getBiddingDetails() {
		return biddingDetails;
	}
	public void setBiddingDetails(BiddingDetails biddingDetails) {
		this.biddingDetails = biddingDetails;
	}
	public BidderDto() {
		super();
		
	}
	public BidderDto(int bidderId, String userName, String password, String name, String email, String phoneNo) {
		super();
		this.bidderId = bidderId;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public int getBidderId() {
		return bidderId;
	}
	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	@Override
	public String toString() {
		return "Bidder [bidderId=" + bidderId + ", userName=" + userName + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", phoneNo=" + phoneNo + ", points=" + points + ", biddingDetails=" + biddingDetails
				+ "]";
	}
}
