package com.hrm.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hrm.model.House;
import com.hrm.model.Owner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HouseDAO {

	@Autowired
	private EntityManager entityManager;
	
	public void addHouseDetails(House house) {
			if(house!=null && house.getOwner()!=null) {
				entityManager.persist(house);
			}
		}
	@SuppressWarnings("unchecked")
	public List<House> getAllHouseDetails(){
		return entityManager.createQuery("from House").getResultList();
	}
		
    public House getByHouseId(Integer id){
    	     House house=entityManager.find(House.class, id);
    	     if(house !=null) {
    	    	 return house;
    	     }
    	     return null;
    }
    
    @SuppressWarnings("unchecked")
	public List<String> getAllLocation(){
       return entityManager.createQuery("select DISTINCT location from House order by location").getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<String>getAllBedRoom(){
    	return entityManager.createQuery("select DISTINCT bedroom from House order by bedroom").getResultList();
    }
    
    
    @SuppressWarnings("unchecked")
	public List<Double>getAllRent(){
    	return entityManager.createQuery("select DISTINCT rent from House order by rent").getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<House>filteredHouseDetails(String location,double rent,String bedroom){
       Query query= entityManager.createQuery("SELECT h FROM House h WHERE (h.location IS NULL OR h.location = :location) OR (h.rent < 1 OR h.rent = :rent) OR (h.bedroom IS NULL OR h.bedroom = :bedroom)");
       query.setParameter("location", location);
       query.setParameter("rent", rent);
       query.setParameter("bedroom", bedroom);
       return query.getResultList();
    }
    
    public void deleteHouseDetails(Integer id) {
    	  House house=entityManager.find(House.class, id);
    	  if(house!=null) {
    		  entityManager.remove(house);
    	  }
    }
    
    public void updateHouseDetails(House house) {
    	if(house!=null && house.getOwner()!=null) {
			entityManager.merge(house);
		}
    }
    
    
    public void addHouseOwnerDetails(Owner owner) {
    	if(owner!=null ) {
			entityManager.persist(owner);
		}
    }
    
    @SuppressWarnings("unchecked")
	public List<Integer> getOwnerIdList(){
       return entityManager.createQuery("select ownerId from Owner order by ownerId").getResultList();
    }
   
	
}
