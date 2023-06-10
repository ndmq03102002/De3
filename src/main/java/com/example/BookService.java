package com.example;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	private BookRepository repo;
	public Book get(String id) {
		Optional<Book> book = repo.findById(id);
		if(book.isPresent()) {
			return book.get();
		}
		return null;
	}
}
