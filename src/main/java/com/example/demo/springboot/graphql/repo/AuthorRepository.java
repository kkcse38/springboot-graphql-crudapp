package com.example.demo.springboot.graphql.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.springboot.graphql.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
}
