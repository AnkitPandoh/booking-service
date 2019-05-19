package com.booking.request;

import java.util.List;

public class BookingRequest {

	private String roomType;
	
	private List<String> facilities;

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public List<String> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<String> facilities) {
		this.facilities = facilities;
	}

}
