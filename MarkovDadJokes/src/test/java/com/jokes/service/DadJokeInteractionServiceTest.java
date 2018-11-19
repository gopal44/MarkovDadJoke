package com.jokes.service;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;


class DadJokeInteractionServiceTest {
	
	@InjectMocks
	DadJokeInteractionService dadJokeInteractionService;
	
	@Mock
	RestTemplate restTemplate;

	@Before
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	private void  testGetDataJokes() {
		//Mockito.when(restTemplate.exchange(requestEntity, responseType))
		String expectedJoke = "I don’t play soccer because I enjoy the sport. I’m just doing it for kicks.";
		String actualJoke  = dadJokeInteractionService.getDataJokes();
		//assertEquals(expectedJoke, actualJoke);
	}

}
