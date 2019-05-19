package com.booking.decorator;

import com.booking.room.IRoom;

public class EnsuiteBathroomDecorator implements IRoomDecorator{
	
	private IRoom room;
	private double charges;
	
	public EnsuiteBathroomDecorator(IRoom room, double charges){
		this.room = room;
		this.charges = charges;
	}

	public double getPrice() {
		return this.room.getPrice()+charges;
	}

	public String getDescription() {
		return this.room.getDescription()+" with Ensuite Bathroom";
	}
	
}
