/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wad.booklibrary.service;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.booklibrary.Book;
import wad.booklibrary.RestBook;
import wad.booklibrary.repository.BookRepository;

/**
 *
 * @author Teemu
 */
@Service
public class JpaBookService implements BookService{

    @Autowired
    private BookRepository bookRepo;

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    @Transactional(readOnly = true)
    public List<Book> list() {
        return bookRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Book read(Long bookID) {
        return bookRepo.findOne(bookID);
    }

    @Override
    @Transactional(readOnly = false)
    public void create(Book book) {
        bookRepo.save(book);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long bookID) {
        bookRepo.delete(bookID);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> findByPartOfName(String name) {
        return bookRepo.findByPartOfName("%"+name+"%");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> findByPartOfAuthor(String author) {
       return bookRepo.findByPartOfAuthor("%"+author+"%");
    }


    @Override
    public RestBook findBookByIsbn(String isbn) throws IOException {
        String osoite = "https://openlibrary.org/api/books?bibkeys=ISBN:"+isbn+"&jscmd=data&format=json";
        ObjectMapper mapper = new ObjectMapper();
        RestBook restBook = mapper.readValue(osoite,RestBook.class);
        return restBook;
        
    }

    @Override
    public RestBook findBookByName(String name) throws IOException {
        String osoite = "https://openlibrary.org/api/books?bibkeys=ISBN:"+name+"&jscmd=data&format=json";
        ObjectMapper mapper = new ObjectMapper();
        RestBook restBook = mapper.readValue(osoite,RestBook.class);
        return restBook;
    }


    @Override
    public void update(Long bookID, String authors, String name, String publishers, String isbn, Integer year) {
        Book book = bookRepo.findOne(bookID);
        book.setAuthors(authors);
        book.setIsbn(isbn);
        book.setName(name);
        book.getPublishers();
        book.setPublishingYear(year);
        bookRepo.save(book);
    }

   


    
}
