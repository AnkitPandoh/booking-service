package com.booking.main;

import com.booking.decorator.EnsuiteBathroomDecorator;
import com.booking.decorator.RoomBreakfastDecorator;
import com.booking.room.IRoom;
import com.booking.room.SuiteRoom;

public class BookingService {
	public static void main(String[] args) {
		IRoom roomBreakfastDecorator = new RoomBreakfastDecorator(new SuiteRoom(), 5.0);
		IRoom room = new EnsuiteBathroomDecorator(roomBreakfastDecorator, 4.0);
		
		System.out.println(room.getDescription());
		System.out.println(room.getPrice());
		
	}
}
