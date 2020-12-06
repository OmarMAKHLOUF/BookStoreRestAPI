package org.polytec.vermeg.service;

 import java.util.List;

import org.polytec.vermeg.dao.BookDAO;
import org.polytec.vermeg.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("BookService")

public class BookService {

	@Autowired
	BookDAO BookDao;
	//affiche
	@Transactional
	public List<Book> getAllBooks() {
		return BookDao.getAllBooks();
	}
	//get 
	@Transactional
	public Book getBook(int id) {
		return BookDao.getBook(id);
	}
	//ajout
	@Transactional
	public void addBook(Book book) {
		BookDao.addBook(book);
	}
	//update
	@Transactional
	public void updateBook(Book book) {
		BookDao.updateBook(book);

	}
	//delete
	@Transactional
	public void deleteBook(int id) {
		BookDao.deleteBook(id);
	}
}
