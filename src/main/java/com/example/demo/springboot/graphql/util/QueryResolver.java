package com.example.demo.springboot.graphql.util;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.springboot.graphql.entity.Author;
import com.example.demo.springboot.graphql.entity.Book;
import com.example.demo.springboot.graphql.repo.AuthorRepository;
import com.example.demo.springboot.graphql.repo.BookRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class QueryResolver implements GraphQLQueryResolver{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public Book getBook(int id) {
		Optional<Book> bookOption =  bookRepository.findById(id);
		if(bookOption.isPresent())
			return bookOption.get();
		return null;
	}
	
	public List<Book> getBookList(){
		return bookRepository.findAll();
	}
	
	public Author getAuthor(int id) {
		Optional<Author> author = authorRepository.findById(id);
		if(author.isPresent())
			return author.get();
		return null;
	}
	
	public List<Author> getAuthorList(){
		return authorRepository.findAll();
	}
 }

