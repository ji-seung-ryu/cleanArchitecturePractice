package com.clean.example.core.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Message {
	private String content;
	private String sender;
	private String receiver; 
	private MessageType type;

	public enum MessageType {
		JOIN, LEAVE, PLAY
	}	
}
