/**
 * 
 */
/**
 * @author Gopalakrishnan
 *
 */
package com.jokes.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jokes.bean.DadJokesResponse;

@Service
public class DadJokeInteractionService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	public String getDataJokes() {
		
		String url = "https://icanhazdadjoke.com/slack";
		DadJokesResponse dadJokesResponse = null;
		final ParameterizedTypeReference<DadJokesResponse> responseType = new ParameterizedTypeReference<DadJokesResponse>() {
			
		};

		String req = "";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> request = new HttpEntity<>(req, headers);
		String jokeResponse  = restTemplate.exchange(url, HttpMethod.GET, request, String.class).getBody();
		
		
		System.out.println("Response  :: "+ jokeResponse);
		
		return jokeResponse;
		
	}
	
}

