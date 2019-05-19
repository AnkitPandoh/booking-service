package com.booking.strategy;

import java.util.Properties;

import com.booking.constant.BookingConstant;
import com.booking.decorator.EnsuiteBathroomDecorator;
import com.booking.decorator.InternetDecorator;
import com.booking.decorator.LateCheckoutDecorator;
import com.booking.decorator.RoomBreakfastDecorator;
import com.booking.decorator.SwimmingPoolDecorator;
import com.booking.request.BookingRequest;
import com.booking.room.GreatViewRoom;
import com.booking.room.IRoom;

public class GreatViewBooking implements IBooking{
	
	private Properties props;
	
	public GreatViewBooking(Properties props) {
		this.props = props;
	}

	@Override
	public IRoom bookRoom(BookingRequest request) {

		IRoom room = new GreatViewRoom();
		if (request.getFacilities() != null) {
			for (String facility : request.getFacilities()) {
				if ("swimming".equals(facility)) {
					room = new SwimmingPoolDecorator(room, Integer.parseInt(
							(String) props.get(BookingConstant.PREFIX + BookingConstant.GREAT_VIEW_SWIMMING_PRICE)));
				} else if ("bathroom".equals(facility)) {
					room = new EnsuiteBathroomDecorator(room, Integer.parseInt(
							(String) props.get(BookingConstant.PREFIX + BookingConstant.GREAT_VIEW_BATHROOM_PRICE)));
				} else if ("breakfast".equals(facility)) {
					room = new RoomBreakfastDecorator(room, Integer.parseInt(
							(String) props.get(BookingConstant.PREFIX + BookingConstant.GREAT_VIEW_BREAKFAST_PRICE)));
				} else if ("internet".equals(facility)) {
					room = new InternetDecorator(room, Integer.parseInt(
							(String) props.get(BookingConstant.PREFIX + BookingConstant.GREAT_VIEW_INTERNET_PRICE)));

				} else {
					room = new LateCheckoutDecorator(room, Integer.parseInt(
							(String) props.get(BookingConstant.PREFIX + BookingConstant.GREAT_VIEW_LATE_CHECKOUT_PRICE)));
				}
			}
		}
		return room;

	
	}

}
