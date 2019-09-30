package com.om.hotel.service;

import java.util.List;

import com.om.hotel.model.Hotel;

public interface HotelService {
public void addDish(Hotel hotel);
	
	public Hotel getDish(int id);
	
	public List<Hotel> getAllDish();
	
	public Hotel updateDish(Integer id ,Hotel hotel);
	
	public void deleteDish(int id);
	
}
