package com.hrm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hrm.controller.HouseController;
import com.hrm.model.House;
import com.hrm.model.Owner;

@SpringBootTest
class SpringJPAHouseRentMgtUnitTests {

	@Autowired
	HouseController controller;
	
	static String result;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	@Order(1)
	@DisplayName("Add the House details with Insert success testcase")
	void test_AddHouseDetails() {
		Owner owner = new Owner();
		owner.setOwnerId(1);
		
		House house = new House();
		house.setLocation("Thiruvarur");
		house.setBedroom("2 BHK");
		house.setParking("Available");
		house.setRent(35000.0);
		house.setOwner(owner);
		assertEquals(new ResponseEntity<>("House value inserted successfully", HttpStatus.OK), controller.addHouse(house));
		
	}

	@Test
	@Order(2)
	@DisplayName("Add the House details with Insert Failure testcase")
	void test_AddHouseDetails2() {
		House house = new House();
	    assertEquals(new ResponseEntity<>("House value inserted faild", HttpStatus.BAD_REQUEST), controller.addHouse(house));
		
	}



	@Test
	@Order(7)
	@DisplayName("Get the All House List is contain the value or Not")
	void test_GetHouseDetails() {
		assertNotNull(controller.getAllHouse());
	}
	
	@Test
	@Order(8)
	@DisplayName("Get the All House List By id is contain the value or Not")
	void test_GetHouseDetailsById() {
		assertNotNull(controller.getAllHouseById(59));
	}
	
	@Test
	@Order(9)
	@DisplayName("Get the All Location List is contain the value or Not")
	void test_GetLocationList() {
		assertNotNull(controller.getLocationList());
	}
	
	@Test
	@Order(10)
	@DisplayName("Get the All Rent List is contain the value or Not")
	void test_GetRentList() {
		assertNotNull(controller.getRentList());
	}
	
	@Test
	@Order(11)
	@DisplayName("Get the All Bedroom List is contain the value or Not")
	void test_GetBedRoomList() {
		assertNotNull(controller.getRoomList());
	}
	
	@Test
	@Order(12)
	@DisplayName("Get the filtered house details is contain the value or Not")
	void test_GetFilterdHouseList() {
		assertNotNull(controller.filterHouse("chennai", 22000, "3 BHK"));
	}

}
