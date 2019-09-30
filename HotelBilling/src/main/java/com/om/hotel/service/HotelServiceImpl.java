package com.om.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.om.hotel.dao.HotelDao;
import com.om.hotel.dao.HotelDaoRepo;
import com.om.hotel.model.Hotel;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	HotelDao hotelDao;
	
	@Autowired
	HotelDaoRepo hotelDaoRepo;
	
	@Override
	public void addDish(Hotel hotel) {
		
		hotel.setTotal(hotel.getPrice()*hotel.getQuantity());
     hotelDao.addDish(hotel);
		
	}

	@Override
	public Hotel getDish(int id) {
		
		return hotelDao.getDish(id);
	}

	@Override
	public List<Hotel> getAllDish() {
	
		return hotelDao.getAllDish();
	}

	@Override
	public Hotel updateDish(Integer id, Hotel hotel) {
		// TODO Auto-generated method stub
		hotel.setTotal(hotel.getPrice()*hotel.getQuantity());

		return hotelDao.updateDish(id, hotel);
	}

	@Override
	public void deleteDish(int id) {
		// TODO Auto-generated method stub
		hotelDao.deleteDish(id);
	}

	
}
