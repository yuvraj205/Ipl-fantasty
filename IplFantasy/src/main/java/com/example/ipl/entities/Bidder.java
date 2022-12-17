package com.example.ipl.entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bidder")
public class Bidder {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="bidderid")
private int bidderId;
@Column(name="username")
private String userName;
@Column(name="password")
private String password;
@Column(name="name")
private String name;
@Column(name="email")
private String email;
@Column(name="mobile_number")
private String phoneNo;
@Column(name="points")
private int points=0;
@OneToOne(mappedBy = "bidder" ,cascade = CascadeType.ALL)
private BiddingDetails biddingDetails;

public BiddingDetails getBiddingDetails() {
	return biddingDetails;
}
public void setBiddingDetails(BiddingDetails biddingDetails) {
	this.biddingDetails = biddingDetails;
}
public Bidder() {
	super();
	
}
public Bidder(int bidderId, String userName, String password, String name, String email, String phoneNo) {
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
@Override
public int hashCode() {
	return Objects.hash(bidderId, biddingDetails, email, name, password, phoneNo, points, userName);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Bidder other = (Bidder) obj;
	return bidderId == other.bidderId && Objects.equals(biddingDetails, other.biddingDetails)
			&& Objects.equals(email, other.email) && Objects.equals(name, other.name)
			&& Objects.equals(password, other.password) && Objects.equals(phoneNo, other.phoneNo)
			&& points == other.points && Objects.equals(userName, other.userName);
}

}
