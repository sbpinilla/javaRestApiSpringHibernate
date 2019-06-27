package com.sergio.sf.apiRest.Service;

import java.util.List;

import com.sergio.sf.apiRest.Model.Book;

public interface BookService {

	// guardar
	long save(Book book);

	// obtener un libro
	Book get(long id);

	// obtener todos los libros
	List<Book> list();

	// actualizar libro
	void update(long id, Book book);

	// eliminar libro
	void delete(long id);

}
