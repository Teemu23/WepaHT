/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.booklibrary.controller;

import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import wad.booklibrary.Book;
import wad.booklibrary.RestBook;
import wad.booklibrary.User;
import wad.booklibrary.service.BookService;
import wad.booklibrary.service.UserService;

/**
 *
 * @author Teemu
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    
    @PostConstruct
    private void init() {
        
        Book book = new Book();
        Book book2 = new Book();
        User user = new User();
        
        user.setEnabled(1);
        user.setAuthority("user");
        user.setPassword("testi");
        user.setUsername("testi");
        
        userService.create(user);
        
        
        book.setName("Pekka Puupaa");
        book.setIsbn("9780385533225");
        book.setPublishingYear(1989);
        book.setAuthors("Joona Joonanen");
        book.setPublishers("Otava");

        book2.setName("Pekka Puupaa2");
        book2.setIsbn("0385472579");
        book2.setPublishingYear(1990);
        book2.setAuthors("Joona Joonanen");
        book2.setPublishers("Otava");
        
        
        bookService.create(book);
        bookService.create(book2);
    }
    
    @RequestMapping(value = "bookform", method = RequestMethod.GET)
    public String show(@ModelAttribute Book book) {
        return "bookform";
    }
    
    @RequestMapping(value="login", method = RequestMethod.GET)
    public String showLogin(){
        return "login";
    }
    @RequestMapping(value="menu", method = RequestMethod.GET)
    public String showMenu(){
        return "menu";
    }
       
    @RequestMapping(value = "books", method = RequestMethod.GET)
    public String list(@ModelAttribute Book book, @RequestParam(required = false) String search,
                       @RequestParam(required = false) String valinta, Model model) {
        List<Book> books;
        if(search==null || search.isEmpty()){
            books = bookService.list();
            model.addAttribute("title", "List of all books");
        } else {
            if(valinta.equals("name")){
                books = bookService.findByPartOfName(search);
                model.addAttribute("title", "List of books with name "+search);
            } else{
                books = bookService.findByPartOfAuthor(search);
                model.addAttribute("title", "List of books with author "+search);
            } 
        }
        model.addAttribute("books", books);
        
        return "books";
    }

    @RequestMapping(value = "bookform/new", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute(value="book") Book book, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            return "bookform";
        }
        bookService.create(book);
        redirectAttributes.addFlashAttribute("message", "New book created!");
        return "redirect:/app/bookform";
    }
  
    @RequestMapping(value="bookform/newApi", method = RequestMethod.POST)
    public String createApi(@ModelAttribute(value="book") Book book,@RequestParam(required=false) String search,
                            @RequestParam(required = false) String valinta) throws IOException{
        RestBook restBook;
            if(valinta.equals("name")){
                restBook = bookService.findBookByIsbn(search);
                book.setIsbn(search);
            } else{
                restBook = bookService.findBookByName(search);
                book.setIsbn(restBook.getBib_key());
            }   
        String name = restBook.getTitle();
        String year = restBook.getPublish_date();
        Integer pYear = Integer.parseInt(year);
        String authors = restBook.getAuthors().getName();
        String publishers = restBook.getPublishers().getName();
        
        book.setAuthors(authors);
        book.setPublishers(publishers);
        book.setPublishingYear(pYear);
        book.setName(name);
        bookService.create(book);
        return "redirect:/app/bookform";
    }
  
    @RequestMapping(value="books/{bookID}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value="bookID") Long bookID) {
        bookService.delete(bookID);
        return "redirect:/app/books";
    }
    
    @RequestMapping(value="books/{bookID}", method = RequestMethod.GET)
    public String showBook(@PathVariable(value="bookID") Long bookID, Model model){
        model.addAttribute("book", bookService.read(bookID));
        return "book";
    }
    
    @RequestMapping(value="edit/{bookID}", method = RequestMethod.GET)
    public String showEdit(@PathVariable(value="bookID") Long bookID, Model model){
        model.addAttribute("book", bookService.read(bookID));
        return "edit";
    }
    
    @RequestMapping(value="edit/{bookID}", method = RequestMethod.POST)
    public String edit(@ModelAttribute(value="book") Book book, @PathVariable(value="bookID") Long bookID, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()) {
            return "bookform";
        }
        bookService.update(bookID, book.getAuthors(), book.getName(), book.getPublishers(), book.getIsbn(), book.getPublishingYear());
        redirectAttributes.addFlashAttribute("message", "Book updated!");
        return "book";
    }
    
 
}
