package com.hrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.DAO.HouseDAO;
import com.hrm.model.House;
import com.hrm.model.Owner;


@Service
public class HouseService {
	
	@Autowired
	HouseDAO dao;

	public void addHouseService(House house) {
		   dao.addHouseDetails(house);
	}
	
	public List<House> getAllHouseService(){
		return dao.getAllHouseDetails();
	}
	
	 public House getByHouseIdService(Integer id){
	    
	     return dao.getByHouseId(id);
}
	 public List<String> getAllLocationService(){
	       return dao.getAllLocation();
	    }
	 public List<String>getAllBedRoomService(){
	    	return dao.getAllBedRoom();
	    }
	 public List<Double> getAllRentService(){
	    	return dao.getAllRent();
	 }
	 
	 public List<House>filteredHouseDetailsService(String location,double rent,String bedroom){
	       return dao.filteredHouseDetails(location, rent, bedroom);
	    }
	 
	 public void deleteHouseDetailsService(Integer id) {
   	            dao.deleteHouseDetails(id);
   	  }
     
	 public void updateHouseDetailsService(House house) {
	    	    dao.updateHouseDetails(house);
			}
	 public void addHouseOwnerDetailsService(Owner owner) {
	    	dao.addHouseOwnerDetails(owner);
	    }
	 
	 public List<Integer> getOwnerIdList(){
	       return dao.getOwnerIdList();
	    }
}
