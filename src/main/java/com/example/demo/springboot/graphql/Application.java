package com.example.demo.springboot.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.springboot.graphql.entity.Author;
import com.example.demo.springboot.graphql.entity.Book;
import com.example.demo.springboot.graphql.repo.AuthorRepository;
import com.example.demo.springboot.graphql.repo.BookRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Don't waste time on sit work
		Author a1 = new Author("F1", "L1");
		Author a2 = new Author("F2", "L2");
		Author a3 = new Author("F3", "L3");
		
		authorRepository.save(a1);
		authorRepository.save(a2);
		authorRepository.save(a3);
		
		Book b1 = new Book("Pearson",120,a1);
		Book b2 = new Book("Maths",129, a2);
		Book b3 = new Book("Phy",123, a3);
		
		bookRepository.save(b1);
		bookRepository.save(b2);
		bookRepository.save(b3);
		
		System.out.println("Command Line runner");
	}

}
