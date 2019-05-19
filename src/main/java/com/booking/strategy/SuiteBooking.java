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
import com.booking.room.SuiteRoom;

public class SuiteBooking implements IBooking {

	private Properties props;

	public SuiteBooking(Properties props) {
		this.props = props;
	}

	@Override
	public IRoom bookRoom(BookingRequest request) {

		IRoom room = new SuiteRoom();
		if (request.getFacilities() != null) {
			for (String facility : request.getFacilities()) {
				if ("swimming".equals(facility)) {
					room = new SwimmingPoolDecorator(room, Integer.parseInt(
							(String) props.get(BookingConstant.PREFIX + BookingConstant.SUITE_SWIMMING_PRICE)));
				} else if ("bathroom".equals(facility)) {
					room = new EnsuiteBathroomDecorator(room, Integer.parseInt(
							(String) props.get(BookingConstant.PREFIX + BookingConstant.SUITE_BATHROOM_PRICE)));
				} else if ("breakfast".equals(facility)) {
					room = new RoomBreakfastDecorator(room, Integer.parseInt(
							(String) props.get(BookingConstant.PREFIX + BookingConstant.SUITE_BREAKFAST_PRICE)));
				} else if ("internet".equals(facility)) {
					room = new InternetDecorator(room, Integer.parseInt(
							(String) props.get(BookingConstant.PREFIX + BookingConstant.SUITE_INTERNET_PRICE)));

				} else {
					room = new LateCheckoutDecorator(room, Integer.parseInt(
							(String) props.get(BookingConstant.PREFIX + BookingConstant.SUITE_LATE_CHECKOUT_PRICE)));
				}
			}
		}
		return room;

	}

}
