package com.Rest.API.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT)
public class BookNotFoundException extends RuntimeException{
private long book_id;
public BookNotFoundException(long book_id) {
        super(String.format("Book is not found with id : '%s'", book_id));
        
        }
}