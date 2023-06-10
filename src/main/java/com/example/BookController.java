package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookController {
	@Autowired
	private BookRepository repo;
	@Autowired
	private BookService service;
	
	@GetMapping("/")
	public String home(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "index";
	}
	@PostMapping("/search")
	public String searchBook(Book book, Model model, HttpSession session) {
	    System.out.println("Search book: " + book); // Kiểm tra book có giá trị đúng hay không
	    List<Book> res = repo.findByBookcodeContainingAndTitleContainingAndAuthorContainingAndCategoryContaining(book.getBookcode(), book.getTitle(), book.getAuthor(), book.getCategory());
	    System.out.println("Result: " + res); // Kiểm tra kết quả trả về
	    session.setAttribute("bookcode", book.getBookcode());
	    session.setAttribute("title", book.getTitle());
	    session.setAttribute("author", book.getAuthor());
	    session.setAttribute("category", book.getCategory());
	    model.addAttribute("books", res);
	    return "view_book";
	}



	@PostMapping("/{id}/book")
	public String setbook(@PathVariable String id) {
		Book book = service.get(id);
		if(book!=null) {
			book.setBooked(1);
			repo.save(book);
		}
		return "redirect:/";
	}
}
