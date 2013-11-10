/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wad.booklibrary.service;

import java.io.IOException;
import java.util.List;
import wad.booklibrary.Book;
import wad.booklibrary.RestBook;


/**
 *
 * @author Teemu
 */
public interface BookService {
    List<Book> findByPartOfName(String name);
    List<Book> findByPartOfAuthor(String author);
    List<Book> list();
    Book read(Long bookID);
    void create(Book book);
    RestBook findBookByIsbn(String isbn) throws IOException;
    RestBook findBookByName(String name) throws IOException;
    void delete(Long bookID);
    void update(Long bookID, String authors, String name, String publishers, String isbn, Integer year);
}
