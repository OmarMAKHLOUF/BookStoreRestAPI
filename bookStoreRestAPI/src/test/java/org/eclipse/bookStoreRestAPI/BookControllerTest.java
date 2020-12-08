package org.eclipse.bookStoreRestAPI;

import static org.hamcrest.Matchers.*;
 import static org.mockito.ArgumentMatchers.any; 
 import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.polytec.vermeg.controller.BookController;
import org.polytec.vermeg.model.Book;
import org.polytec.vermeg.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

 
public class BookControllerTest {
	private Mapper mapper =new Mapper();
	@Autowired
	private MockMvc mockMVC;
	
	@Mock
	private BookService bookService;
	
	@InjectMocks
	private BookController bookController;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMVC = MockMvcBuilders.standaloneSetup(this.bookController).build();
	}


	@Test
	public void testSayHello() throws Exception {
		this.mockMVC.perform(get("/api/Book/all")).andDo(print());
	}
	
	@Test
	public void AddBook() throws Exception {
		Book book = new Book(1,"testing","test",10,null);
		doNothing().when(this.bookService).addBook((any(Book.class)));
		this.mockMVC.perform(post("/api/Book/addBook")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.asJsonString(book))
				).andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void BookAll() throws Exception {
		ArrayList<Book> productList = new ArrayList<Book>();
		productList.add(new Book(1,"testing","test",10,null));
		productList.add(new Book(1,"testing","test",10,null));
		when(bookService.getAllBooks()).thenReturn(productList);
		this.mockMVC.perform(get("/api/Book/getAll")).andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(2))).andDo(print());
	}
	
	@Test
	public void UpdateBook() throws Exception {
		Book book = new Book(1,"testing","test",10,null);
		doNothing().when(this.bookService).updateBook(any(Book.class));
		this.mockMVC.perform(put("/api/Book/updateBook")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Mapper.asJsonString(book))
				).andExpect(status().isOk())
				.andDo(print());
	}
	
	  
	@Test
	public void  DeleteBook() throws Exception {
		Book book = new Book(1,"testing","test",10,null);
		doNothing().when(this.bookService).delete (any(Book.class));
		this.mockMVC.perform(delete("/api/Book/delete")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Mapper.asJsonString(book))
				).andExpect(status().isOk())
				.andDo(print());
	}
	 

}
