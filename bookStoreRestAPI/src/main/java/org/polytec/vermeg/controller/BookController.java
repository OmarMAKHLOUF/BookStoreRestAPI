package org.polytec.vermeg.controller;

import java.util.List;

import org.polytec.vermeg.model.Book;
import org.polytec.vermeg.model.Order;
import org.polytec.vermeg.service.BookService;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Book")
public class BookController {

	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public String sayHello(){
        return "lll ";
    }
	
	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<Book> getBooks() {
		
		List<Book> listOfBooks = bookService.getAllBooks();
		
		return listOfBooks;
	}

	@RequestMapping(value = "/getBook/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Book getBookById(@PathVariable int id) {
		return bookService.getBook(id);
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addBook(@ModelAttribute("book") Book book) {	
		if(book.getId_book()==0)
		{
			bookService.addBook(book);
		}
		else
		{	
			bookService.updateBook(book);
		}
		
		return "redirect:/getAllBooks";
	}

	
	

	
	
	@RequestMapping(value = "/updateBook", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updateBook(@RequestBody Book book) {
			this.bookService.updateBook(book);
	        return "bookDetails";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = " /delete")
	public void delete(@RequestBody Book book) {
		this.bookService.delete (book);
	}
	
	 
	@RequestMapping(value = "/calculerPrice/{id}/{quantity}", method = RequestMethod.GET, headers = "Accept=application/json")
    public double calculerPrice(@PathVariable int id, @PathVariable int quantity) {	
	double priceUnit = bookService.getBook(id).getPrice();
    double montant= priceUnit*quantity;
    return montant;
    }
	
// Calcule somme prix unitaire des livres choisi :
@RequestMapping(value = "/SommeTotalPrice", method = RequestMethod.POST, headers = "Accept=application/json")
public double SommeTotalPrice (@RequestBody List<Integer> listBooks) {	
	double montant=0;

	for (int i=0;i<listBooks.size();i++) {
	int id = listBooks.get(i);
		
		montant= montant+bookService.getBook(id).getPrice();		
	}		
	return montant;
}
}
