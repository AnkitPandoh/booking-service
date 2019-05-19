package com.booking.strategy;

import com.booking.request.BookingRequest;
import com.booking.room.IRoom;

public interface IBooking {
	
	IRoom bookRoom(BookingRequest request);
}
