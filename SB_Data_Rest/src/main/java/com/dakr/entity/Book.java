package com.dakr.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Book_Tbl")
public class Book {

	@Id
	private Integer id;
	private String name;
	private Double price;

}
