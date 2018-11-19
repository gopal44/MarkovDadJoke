package com.jokes.bean;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"fallback",
	"footer",
	"text"
})
public class Attachment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("fallback")
	private String fallback;
	
	@JsonProperty("footer")
	private String footer;
	
	@JsonProperty("text")
	private String text;
	
	public String getFallback() {
		return fallback;
	}

	public void setFallback(String fallback) {
		this.fallback = fallback;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
