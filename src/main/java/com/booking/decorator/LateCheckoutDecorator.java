package com.booking.decorator;

import com.booking.room.IRoom;

public class LateCheckoutDecorator implements IRoomDecorator{
	
	private IRoom room;
	private double charges;
	
	public LateCheckoutDecorator(IRoom room, double charges){
		this.room = room;
		this.charges = charges;
	}

	public double getPrice() {
		return this.room.getPrice()+charges;
	}

	public String getDescription() {
		return this.room.getDescription()+" with Late Checkout";
	}
}
