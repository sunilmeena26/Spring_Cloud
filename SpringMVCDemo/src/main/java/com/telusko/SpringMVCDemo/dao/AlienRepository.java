package com.telusko.SpringMVCDemo.dao;

import java.util.List;
import java.util.ListResourceBundle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telusko.SpringMVCDemo.model.Alien;

@Repository
public interface AlienRepository extends JpaRepository<Alien, Integer> {
 //List<Alien> findByAname(String aname); //Query DSL
 //List<Alien> findByAnameOrderByAid(String aname); 
//List<Alien> findByAnameOrderByAidDesc(String aname); 
	
	//Access data by name in database using query annotation this is other way
//	@Query("from alien where aname= :name")
//	List<Alien> find(@Param("name") String aname);
}
