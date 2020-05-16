package com.cognixia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cognixia.model.Todo;

@RepositoryRestResource
public interface TodoRepository extends JpaRepository<Todo, Integer>{

	List<Todo> findByUser(String user);
	List<Todo> findByDoneTrue();
	
	@Query("select t from Todo t where t.user=?1 and t.des=?2") 
	Todo findByUserAndDescription(String user, String description);

	Todo findByUserAndDes(String user, String des);
}

