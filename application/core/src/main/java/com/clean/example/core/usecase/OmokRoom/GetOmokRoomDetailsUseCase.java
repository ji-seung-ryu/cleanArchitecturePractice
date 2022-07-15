package com.clean.example.core.usecase.OmokRoom;

import com.clean.example.core.entity.OmokRoom;

public class GetOmokRoomDetailsUseCase {
	private final GetOmokRoomDetails getOmokRoomDetails;
	
	public GetOmokRoomDetailsUseCase (GetOmokRoomDetails getOmokRoomDetails) {
		this.getOmokRoomDetails = getOmokRoomDetails;
	}
	
	public OmokRoom getOmokRoomDetails (String roomId) {
		
		OmokRoom room = getOmokRoomDetails.getDetails(roomId);
		
		if (room == null) throw new OmokRoomNotFoundException();
		
		return room;
	}
}

