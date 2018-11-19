package com.jokes.bean;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({
	"attachments",
	"response_type",
	"username"
})
//@NoArgsConstructor
//@AllArgsConstructor
@Data
public class JokeResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("inputJoke")
	private String inputJoke;
	
	@JsonProperty("markovChainOutputJoke")
	private String markovChainOutputJoke;
	
	public String getInputJoke() {
		return inputJoke;
	}

	public void setInputJoke(String inputJoke) {
		this.inputJoke = inputJoke;
	}

	public String getMarkovChainOutputJoke() {
		return markovChainOutputJoke;
	}

	public void setMarkovChainOutputJoke(String markovChainOutputJoke) {
		this.markovChainOutputJoke = markovChainOutputJoke;
	}



}
