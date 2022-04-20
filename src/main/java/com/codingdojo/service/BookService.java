package com.codingdojo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Book;
import com.codingdojo.repository.BookRepository;

@Service
public class BookService {
private BookRepository bookRepository;

public BookService(BookRepository bookRepository) {
	this.bookRepository=bookRepository;
}

public void Create(Book book) {
		bookRepository.save(book);
}

public ArrayList<Book> FindAll() {
	return (ArrayList< Book>)bookRepository.findAll();
}
public Book FindOne(long id)
{
	Optional<Book> book=bookRepository.findById(id);
	return book.isPresent()?book.get():null;
}
public void Update(Book book)
{
	Create(book);
}
public void Delete(Long id)
{
	bookRepository.deleteById(id);
}
}
