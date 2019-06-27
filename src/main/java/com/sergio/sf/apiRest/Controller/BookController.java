package com.sergio.sf.apiRest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sergio.sf.apiRest.Model.Book;
import com.sergio.sf.apiRest.Service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	// obtener todos los libros
	@GetMapping("/api/book")
	public ResponseEntity<List<Book>> list() {

		List<Book> list = bookService.list();
		return ResponseEntity.ok().body(list);

	}

	// guardar libros
	@PostMapping("/api/book")
	public ResponseEntity<Book> save(@RequestBody Book book) {

		long id = bookService.save(book);
		book.setId(id);

		return ResponseEntity.ok().body(book);

	}

	// obtener libro por su id
	@GetMapping("/api/book/{id}")
	public ResponseEntity<Book> get(@PathVariable("id") long id) {
		Book book = bookService.get(id);
		return ResponseEntity.ok().body(book);
	}
	
	// actualizar libros 
	@PutMapping("/api/book/{id}")
	public ResponseEntity<Book> update(@PathVariable("id") long id,@RequestBody Book book){
		
		bookService.update(id, book);
		return ResponseEntity.ok().body(book);
	}
	
	// Eliminar libro

	@DeleteMapping("/api/book/{id}")
	public ResponseEntity<?> delete (@PathVariable("id") long id){
		
		bookService.delete(id);
		
		return ResponseEntity.ok().body("Libro eliminado");
		
	}

}
