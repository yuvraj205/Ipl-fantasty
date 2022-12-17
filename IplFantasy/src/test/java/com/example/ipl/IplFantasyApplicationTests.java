package com.example.ipl;

import static org.junit.jupiter.api.Assertions.assertNotNull;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ipl.entities.Bidder;

import com.example.ipl.entities.TeamDetails;

import com.example.ipl.repositry.AdminMatchDao;
import com.example.ipl.repositry.AdminTeamDao;
import com.example.ipl.repositry.BidderDao;

@SpringBootTest
class IplFantasyApplicationTests {

@Autowired
 BidderDao bidderdao;
@Autowired
 AdminMatchDao adminOperationsDao;
@Autowired
AdminTeamDao adminTeamDao;
	@Test
	 void addBidder()
	{
		Bidder bidder=new Bidder(3, "Ys26601", "Yuvi@123","Yuvraj", "ys26601@gmail.com","7037730532");
		bidderdao.save(bidder);
		assertNotNull(bidderdao.findById(1).get());
		
	}
	@Test
	 void addTeam()
	{
		TeamDetails team=new TeamDetails(5,"Banglore",12);
		adminTeamDao.save(team);
		assertNotNull(adminTeamDao.findById(1).get());
	}
	
	

}
