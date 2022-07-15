package com.clean.example.core.usecase.OmokRoom;

import com.clean.example.core.entity.OmokRoom;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class GetOmokRoomDetailsUseCaseTest {

	GetOmokRoomDetails getOmokRoomDetails = mock(GetOmokRoomDetails.class);
	
	GetOmokRoomDetailsUseCase getOmokRoomDetailsUseCase = new GetOmokRoomDetailsUseCase (getOmokRoomDetails);
	
	@Test
	public void returnsOmokRoomDetails() throws Exception{
		OmokRoom expectedRoom = givenARoomIsFound();
		OmokRoom actualRoom = getOmokRoomDetailsUseCase.getOmokRoomDetails("1009");
		assertThat(actualRoom).isEqualTo(expectedRoom);
	}
	
	@Test 
	public void errorWhenRoomIsNotFound() throws Exception{
		givenADeviceIsNotFound();
		assertThatExceptionOfType(OmokRoomNotFoundException.class).isThrownBy(() -> getOmokRoomDetailsUseCase.getOmokRoomDetails("1009"));
	}
	private OmokRoom givenARoomIsFound() {
		OmokRoom expectedRoom = new OmokRoom("1009");
		
		when(getOmokRoomDetails.getDetails("1009")).thenReturn(expectedRoom);
		return expectedRoom; 
	}
	
	private void givenADeviceIsNotFound() {
		when(getOmokRoomDetails.getDetails(anyString())).thenReturn(null);
		
	}
}
