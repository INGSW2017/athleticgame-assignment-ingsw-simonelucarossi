package it.unical.test;

import java.time.Instant;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.asde.AthleticGame;

public class AthleticGameWinnersTest {

	private static  String sport;
	private static AthleticGame athletic;
	private static  String name;
	private static  String name2;

	@BeforeClass
	public static void Init(){	
		sport = new String("Calcio");
		athletic = new AthleticGame(sport);
		name = new String("Nicola");
		name2 = new String("Vincenzo");
	}
	
	@Test
	public void winnerWorks1() {
		athletic.reset();
		athletic.start();
		athletic.addArrival("Vincenzo", Instant.now());
		Assert.assertEquals("Vincenzo", athletic.getWinner());
	}
	
	@Test
	public void winnerWorks2() {
		athletic.reset();
		athletic.start();
		athletic.addArrival("Vincenzo", Instant.now());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		athletic.addArrival("Antonio", Instant.now());
		Assert.assertEquals("Vincenzo", athletic.getWinner());
	}

	
	
	@After
	public void resetWorks() {
		athletic.reset();
	}
	
	@Before
	public void startWorks() {
		athletic.start();
	}
}
