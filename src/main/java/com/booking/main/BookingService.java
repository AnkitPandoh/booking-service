package com.booking.main;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.booking.request.BookingRequest;
import com.booking.room.IRoom;
import com.booking.strategy.BookingManager;
import com.booking.strategy.GreatViewBooking;
import com.booking.strategy.StandardBooking;
import com.booking.strategy.SuiteBooking;

public class BookingService {

	private static final String PROPERTIES_FILE = "application.properties";

	public static void main(String[] args) throws Exception {

		Properties properties = new Properties();
		properties.load(BookingService.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));

		String roomType = "suite";
		List<String> facilities = Arrays.asList("bathroom", "breakfast");

		BookingRequest request = new BookingRequest();
		request.setRoomType(roomType);
		request.setFacilities(facilities);

		IRoom room = null;
		switch (request.getRoomType()) {
		case "standard":
			room = new BookingManager(new StandardBooking(properties)).bookRoom(request);
			break;
		case "suite":
			room = new BookingManager(new SuiteBooking(properties)).bookRoom(request);
			break;
		case "greatview":
			room = new BookingManager(new GreatViewBooking(properties)).bookRoom(request);
			break;
		default:
			throw new Exception("Wrong room type");
		}

		System.out.println("Room Desription  :" + room.getDescription());

		if ("suite".equals(roomType)) {
			System.out.println(room.getPrice());
		} else {
			System.out.println(2 * room.getPrice());
		}

	}
}
