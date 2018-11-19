package com.jokes.controller;

import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jokes.bean.JokeResponse;
import com.jokes.service.DadJokeInteractionService;
import com.jokes.service.MarkovChainService;

//@RunWith(SpringJUnit4ClassRunner.class)
public class DadJokeControllerTest {
	
	@InjectMocks
	private DadJokeController dadJokeController;
	
	@Mock
	private DadJokeInteractionService dadJokeInteractionService;
	
	@Mock
	private MarkovChainService markovChainService;
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetDadJokes() throws InterruptedException, IOException {
		String joke = "I don’t play soccer because I enjoy the sport. I’m just doing it for kicks.";
		Mockito.when(dadJokeInteractionService.getDataJokes()).thenReturn(joke);
		Mockito.when(markovChainService.markov(Matchers.anyString(), Matchers.anyInt(),Matchers.anyInt())).thenReturn(joke);
		
		ResponseEntity<JokeResponse> actualJokeResponse = dadJokeController.getDadJokes();
		assertNull(actualJokeResponse);
	}
	
	

}
