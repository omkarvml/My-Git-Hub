package com.om.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.om.hotel.dao.HotelDaoRepo;
import com.om.hotel.model.Hotel;
import com.om.hotel.service.HotelService;

@RestController
@RequestMapping(name = "/hotel")
public class HotelController {

	@Autowired
	HotelService hotelService;

	@Autowired
	HotelDaoRepo hotelDaoRepo;

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public void addDish(@RequestBody Hotel hotel) {

		hotelService.addDish(hotel);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
	public Hotel getDish(@PathVariable int id) {
		return hotelService.getDish(id);

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST, produces = "application/json")
	public Hotel updateDish(@PathVariable int id,@RequestBody Hotel hotel) {
		return hotelService.updateDish(id, hotel);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = "application/json")
	public void deleteDish(@PathVariable int id) {
		hotelService.deleteDish(id);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<Hotel> getAllDish() {
		return hotelService.getAllDish();

	}

}
