package com.booking.strategy;

import java.util.Properties;

import com.booking.constant.BookingConstant;
import com.booking.decorator.EnsuiteBathroomDecorator;
import com.booking.decorator.InternetDecorator;
import com.booking.decorator.LateCheckoutDecorator;
import com.booking.decorator.RoomBreakfastDecorator;
import com.booking.decorator.SwimmingPoolDecorator;
import com.booking.request.BookingRequest;
import com.booking.room.IRoom;
import com.booking.room.StandardRoom;

public class StandardBooking implements IBooking {

	private Properties props;
	private static final double DEFAULT_PRICE = 6.0;

	public StandardBooking(Properties props) {
		this.props = props;
	}

	@Override
	public IRoom bookRoom(BookingRequest request) {
		IRoom room = new StandardRoom();
		int count = 0;
		if (request.getFacilities() != null) {
			for (String facility : request.getFacilities()) {
				if ("swimming".equals(facility)) {
					if (count < 3) {
						room = new SwimmingPoolDecorator(room, Integer.parseInt(
								(String) props.get(BookingConstant.PREFIX + BookingConstant.STANDARD_SWIMMING_PRICE)));
					} else {
						room = new SwimmingPoolDecorator(room, DEFAULT_PRICE);
					}
				} else if ("bathroom".equals(facility)) {
					if (count < 3) {
						room = new EnsuiteBathroomDecorator(room, Integer.parseInt(
								(String) props.get(BookingConstant.PREFIX + BookingConstant.STANDARD_BATHROOM_PRICE)));
					} else {
						room = new EnsuiteBathroomDecorator(room, DEFAULT_PRICE);
					}
				} else if ("breakfast".equals(facility)) {
					if (count < 3) {
						room = new RoomBreakfastDecorator(room, Integer.parseInt(
								(String) props.get(BookingConstant.PREFIX + BookingConstant.STANDARD_BREAKFAST_PRICE)));
					} else {
						room = new RoomBreakfastDecorator(room, DEFAULT_PRICE);
					}
				} else if ("internet".equals(facility)) {
					if (count < 3) {
						room = new InternetDecorator(room, Integer.parseInt(
								(String) props.get(BookingConstant.PREFIX + BookingConstant.STANDARD_INTERNET_PRICE)));
					} else {
						room = new InternetDecorator(room, DEFAULT_PRICE);
					}

				} else {
					if (count < 3) {
						room = new LateCheckoutDecorator(room, Integer.parseInt((String) props
								.get(BookingConstant.PREFIX + BookingConstant.STANDARD_LATE_CHECKOUT_PRICE)));
					} else {
						room = new LateCheckoutDecorator(room, DEFAULT_PRICE);
					}
				}
				count++;
			}
		}
		return room;
	}

}
