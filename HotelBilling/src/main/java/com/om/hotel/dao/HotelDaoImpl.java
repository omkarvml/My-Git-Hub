package com.om.hotel.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.om.hotel.model.Hotel;
@Repository
public class HotelDaoImpl implements  HotelDao{
 
	@Autowired
	HotelDaoRepo hotelDaoRepo;
	
	@Override
	public void addDish(Hotel hotel) {
		// TODO Auto-generated method stub
		hotelDaoRepo.save(hotel);
	}

	@Override
	public Hotel getDish(int id) {
		// TODO Auto-generated method stub
		return hotelDaoRepo.getOne(id);
	}

	@Override
	public List<Hotel> getAllDish() {
		// TODO Auto-generated method stub
		return hotelDaoRepo.findAll();
	}

	@Override
	public Hotel updateDish(Integer id, Hotel hotel) {
		// TODO Auto-generated method stub
		hotel=getDish(id);
		hotel.setName(hotel.getName());
		hotel.setQuantity(hotel.getQuantity());
		hotel.setPrice(hotel.getPrice());
		hotel.setTotal(hotel.getTotal());
	return  hotelDaoRepo.saveAndFlush(hotel);
		
		
	}

	@Override
	public void deleteDish(int id) {
		// TODO Auto-generated method stub
		hotelDaoRepo.deleteById(id);
	}

	
	
}
