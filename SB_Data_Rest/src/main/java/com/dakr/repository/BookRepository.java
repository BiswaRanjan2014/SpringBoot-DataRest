package com.dakr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dakr.entity.Book;
import java.util.List;

@RepositoryRestResource(path = "books")
public interface BookRepository extends JpaRepository<Book, Integer> {

	//we fetch data frm DB to search by findByName and 
	//Also we can search by keyword frm the name
	public List<Book> findByNameContaining(@Param("name") String name);
	
}
