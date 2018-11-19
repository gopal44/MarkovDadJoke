/**
 * 
 */
/**
 * @author Gopalakrishnan
 *
 */
package com.jokes.controller;

import java.io.IOException;

//import org.apache.commons.httpclient.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jokes.bean.Attachments;
import com.jokes.bean.JokeResponse;
import com.jokes.service.DadJokeInteractionService;
import com.jokes.service.MarkovChainService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DadJokeController{
	
	
	@Autowired
	private DadJokeInteractionService dadJokeInteractionService;
	
	@Autowired
	private MarkovChainService markovChainService;
	
	@SuppressWarnings("static-access")
	@GetMapping(path = "/dadjokes", produces="application/json" ,headers= "accept=application/json")
	@ApiOperation(value="Generate Jokes",nickname = "getDadJokes", notes="Genearate Jokes", httpMethod = "GET")
	@Cacheable(value = "dadjokes")
	public ResponseEntity<JokeResponse> getDadJokes() throws InterruptedException{
		
		
		HttpStatus httpStatus = HttpStatus.OK;
		String jokesResponse =  dadJokeInteractionService.getDataJokes();
		Attachments attachments = null;
		String joke = null;
		String markovChainGeneratedJoke  =  null;
		JokeResponse jokeResponse =  new JokeResponse();
		try {
			ObjectMapper objectMapper = new  ObjectMapper();
			objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			attachments = objectMapper.readValue(jokesResponse, Attachments.class);
			joke = attachments.getAttachments().get(0).getText().toString();
		
			System.out.println("The input joke is :: " + joke);
			jokeResponse.setInputJoke(joke);
			markovChainGeneratedJoke = markovChainService.markov(joke, 1, 5);
			System.out.println("The Markov Chain Generated joke is :: " + markovChainGeneratedJoke );
			jokeResponse.setMarkovChainOutputJoke(markovChainGeneratedJoke);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<JokeResponse>(jokeResponse, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "cleardadjokescache")
	@ApiOperation(value="Clear Dad Jokes Cache",nickname = "clearDadJokesCache", notes="Clear Dad Jokes Cache", httpMethod = "GET")
	@CacheEvict(value = "dadjokes")
	public ResponseEntity<String> clearDadJokesCache() {
		String message = "Dad Jokes Cache is cleared successsfully";
		return new ResponseEntity<String>(message, HttpStatus.OK);
		
	}
	
}

