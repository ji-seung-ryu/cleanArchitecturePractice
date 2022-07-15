package com.clean.example.core.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OmokRoom {

	private String roomId;
	private List <String> memberList = new ArrayList<String>();
	private final int BOARD_SIZE = 20; 	
	private final int STONE_BLACK = 1; 
	private final int STONE_WHITE = 2;
	
	private int [][] board = new int[BOARD_SIZE][BOARD_SIZE];
	
	private String whoBlack;

	/*
	public static OmokRoom create(String name) {
		OmokRoom room = new OmokRoom();
		room.roomId = UUID.randomUUID().toString();
		return room;
	}
	
	public void enter(String username){		
		if (!memberList.contains(username)) memberList.add(username);		
	}
	
	public void putStone (int y, int x, String who) {
		if (who == whoBlack) board[y][x] = STONE_BLACK;
		else board[y][x] = STONE_WHITE; 
	}
	
	public void gameStart (String whoFirst) {
		whoBlack = whoFirst;  
		
	}
	*/
}