package com.booking.room;

public abstract class Room {
	
	private int id;
	private String roomType;
	private double basePrice;
	
	
	public Room(int id, String roomType, double basePrice){
		this.id = id;
		this.roomType = roomType;
		this.basePrice = basePrice;
	}
	
	public int getId() {
		return id;
	}

	public String getRoomType() {
		return roomType;
	}

	public double getBasePrice() {
		return basePrice;
	}
}
