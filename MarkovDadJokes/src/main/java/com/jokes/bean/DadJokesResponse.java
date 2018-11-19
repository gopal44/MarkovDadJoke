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
public class DadJokesResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("attachments")
	private List<Attachment> attachments;
	
	@JsonProperty("response_type")
	private String response_type;
	
	@JsonProperty("username")
	private String username;
	
	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public String getResponse_type() {
		return response_type;
	}

	public void setResponse_type(String response_type) {
		this.response_type = response_type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	

}
