package com.example.demo.springboot.graphql.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.springboot.graphql.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	
}
