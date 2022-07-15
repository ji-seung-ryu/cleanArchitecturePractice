package com.clean.example.core.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class OmokInfo {
	private String content;
	private String sender;
	private String receiver;
	private String roomId; 
	private OmokInfoType type;

	private enum OmokInfoType {
		PUT, JOIN, LEAVE;
	}

}
