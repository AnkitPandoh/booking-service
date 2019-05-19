package com.booking.room;

public class StandardRoom extends Room implements IRoom {
	
	public StandardRoom() {
		super(1, "Standard", 0.0);
	}

	public double getPrice() {
		return this.getBasePrice();
	}

	public String getDescription() {
		return "This is "+this.getRoomType()+" Room";
	}
}
