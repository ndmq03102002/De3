package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="Books")
@Data
public class Book {
	@Id
	private String bookcode;
	private String title;
	private String author;
	private String category;
	private Integer booked;
	
}
