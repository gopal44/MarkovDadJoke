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
public class Attachments implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("attachments")
	private List<Attachment> attachments;

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

}
