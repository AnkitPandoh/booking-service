package com.booking.room;

public class GreatViewRoom extends Room  implements IRoom{

	public GreatViewRoom() {
		super(3, "Great View", 0.0);
	}

	public double getPrice() {
		return this.getBasePrice();
	}

	public String getDescription() {
		return "This is "+this.getRoomType()+" Room";
	}

}
