package com.booking.room;

public class SuiteRoom extends Room implements IRoom{

	public SuiteRoom() {
		super(2, "Suite", 0.0);
	}

	public double getPrice() {
		return this.getBasePrice();
	}

	public String getDescription() {
		return "This is "+this.getRoomType()+" Room";
	}

}
