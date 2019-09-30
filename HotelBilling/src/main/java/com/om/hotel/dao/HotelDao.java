package com.om.hotel.dao;

import java.util.List;

import com.om.hotel.model.Hotel;

public interface HotelDao {
	public void addDish(Hotel hotel);
	
	public Hotel getDish(int id);
	
	public List<Hotel> getAllDish();
	
	public Hotel updateDish(Integer id ,Hotel hotel);
	
	public void deleteDish(int id);
	
}
