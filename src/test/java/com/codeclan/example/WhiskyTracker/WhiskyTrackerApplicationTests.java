package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ActiveProfiles("test") //Indicates it's a test profile so will not run DataLoader
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	DistilleryRepository distilleryRepository;

	@Autowired
	WhiskyRepository whiskyRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetAllDistilleries(){
		List<Distillery> foundDistil = distilleryRepository.findAll();
		assertEquals(13, foundDistil.size());
	}

	@Test
	public void canGetAllWhisky(){
		List<Whisky> foundWhiskey = whiskyRepository.findAll();
		assertEquals(22, foundWhiskey.size());
	}

	@Test
	public void canGetWhiskiesByRegion(){
		List<Whisky> foundWhiskey = whiskyRepository.findByDistilleryRegion("Islay");
		assertEquals(2, foundWhiskey.size());
	}

	@Test
	public void canGetWhiskiesByAgeFromSpecificDistillery(){
		Distillery chosenDistil = distilleryRepository.getById(11L);
//		List<Whisky> foundWhiskies = chosenDistil.getWhiskies();
		List<Whisky> certainAgeWhiskies = whiskyRepository.findByWhiskiesAge(chosenDistil, 1);
		assertEquals(2, certainAgeWhiskies.size());


	}


}
