package com.Rest.API.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Rest.API.model.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
