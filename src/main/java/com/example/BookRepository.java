package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByBookcodeContainingAndTitleContainingAndAuthorContainingAndCategoryContaining(String bookcode, String title, String author, String category);
}
