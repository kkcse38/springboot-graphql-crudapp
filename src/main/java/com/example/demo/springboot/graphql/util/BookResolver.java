package com.example.demo.springboot.graphql.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.springboot.graphql.entity.Author;
import com.example.demo.springboot.graphql.entity.Book;
import com.example.demo.springboot.graphql.repo.AuthorRepository;

@Component
public class BookResolver implements GraphQLResolver<Book>{
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public Author getAuthor(Book book) {
		Optional<Author> autorOption =  authorRepository.findById(book.getAuthor().getId());
		if(autorOption.isPresent())
			return autorOption.get();
		return null;
	}
}
