package com.hrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrm.model.House;
import com.hrm.service.HouseService;


@RestController
@RequestMapping("/api/house")
@CrossOrigin("*")
public class HouseController {

	@Autowired
	HouseService service;
	
	

	@PostMapping
	public ResponseEntity<String> addHouse(@RequestBody House house) {

		try {
		if(house!=null && house.getOwner()!=null) {
			System.out.println(house);
			service.addHouseService(house);
			return new ResponseEntity<>("House value inserted successfully", HttpStatus.OK);
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("House value inserted faild", HttpStatus.BAD_REQUEST);
	}

	@GetMapping
	public ResponseEntity<List<House>> getAllHouse() {
		List<House> houses = service.getAllHouseService();
		return new ResponseEntity<>(houses, HttpStatus.OK);
	}
	
	@GetMapping("/findById")
	public ResponseEntity<House> getAllHouseById(@RequestParam Integer id) {
	     House houses = service.getByHouseIdService(id);
		return new ResponseEntity<>(houses, HttpStatus.OK);
	}
	
	
	@GetMapping("/locationList")
	public ResponseEntity<List<String>> getLocationList(){
		List<String> houses = service.getAllLocationService();
		return new ResponseEntity<>(houses, HttpStatus.OK);
	}
	
	@GetMapping("/rentList")
	public ResponseEntity<List<Double>> getRentList(){
		List<Double> houses = service.getAllRentService();
		return new ResponseEntity<>(houses, HttpStatus.OK);
	}
	
	@GetMapping("/bedRoomList")
	public ResponseEntity<List<String>> getRoomList(){
		List<String> houses = service.getAllBedRoomService();
		return new ResponseEntity<>(houses, HttpStatus.OK);
	}
	
	@GetMapping("/filterHouse")
	public ResponseEntity<List<House>>filterHouse(@RequestParam String location,@RequestParam double rent,@RequestParam String bedroom){
		 List<House> houses= service.filteredHouseDetailsService(location, rent, bedroom);
		 return new ResponseEntity<>(houses, HttpStatus.OK);
	}
	
	

	@DeleteMapping
	public ResponseEntity<String> deleteHouse(@RequestParam Integer houseId) {
		try {
        if(houseId>0) {
			service.deleteHouseDetailsService(houseId);

			return new ResponseEntity<>("House value deleted successfully", HttpStatus.OK);
        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("House value deleted faild", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping
	public ResponseEntity<String>updateHouse(@RequestBody House house){
		
		try {
			if(house!=null && house.getOwner()!=null) {
			service.updateHouseDetailsService(house);

			return new ResponseEntity<>("House value updated successfully", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("House value updation faild", HttpStatus.BAD_REQUEST);
		
	}
}
