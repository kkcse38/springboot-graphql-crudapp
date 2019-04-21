package com.example.demo.springboot.graphql.util;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.springboot.graphql.entity.Author;
import com.example.demo.springboot.graphql.entity.Book;
import com.example.demo.springboot.graphql.repo.AuthorRepository;
import com.example.demo.springboot.graphql.repo.BookRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MutationResolver implements GraphQLMutationResolver{
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	public Author newAuthor(String firstName, String lastName) {
		return authorRepository.save(new Author(firstName, lastName));
	}
	
//	public Book newBook(String name, int pageCount, Author author) {
//		return bookRepository.save(new Book(name, pageCount, author));
//	}
	
	public Book updateBookPageCount(int pageCount, int id) {
		
		Optional<Book> bookOption = bookRepository.findById(id);
		Book book = null;
		
		if(bookOption.isPresent()) {
			book = bookOption.get();
			book.setPageCount(pageCount);
			bookRepository.save(book);
		}
		
		return book;
	}

}