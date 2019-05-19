package com.booking.room;

public class GreatView extends Room  implements IRoom{

	public GreatView() {
		super(3, "Great View", 0.0);
	}

	public double getPrice() {
		return this.getBasePrice();
	}

	public String getDescription() {
		return "This is "+this.getRoomType()+" Room";
	}

}
