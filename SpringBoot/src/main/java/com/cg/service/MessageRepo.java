package com.cg.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.model.Message;
@Repository
public interface MessageRepo extends JpaRepository<Message,Integer> {
	@Query(value="select m from Message m where m.text=:text")
	Message getByText(@Param(value="text")String text);
	
	

}
