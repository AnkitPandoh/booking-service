package com.booking.strategy;

import com.booking.request.BookingRequest;
import com.booking.room.IRoom;

public class BookingManager {
	
	private IBooking booking;
	
	public BookingManager(IBooking booking){
		this.booking = booking;
	}
	
	public IRoom bookRoom(BookingRequest request){
		return booking.bookRoom(request);
	}
}
