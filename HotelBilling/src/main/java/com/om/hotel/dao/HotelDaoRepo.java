package com.om.hotel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.om.hotel.model.Hotel;
@Repository
public interface HotelDaoRepo extends JpaRepository<Hotel,Integer>  {

	
}
