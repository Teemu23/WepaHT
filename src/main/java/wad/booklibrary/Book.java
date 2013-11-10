/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wad.booklibrary;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;



/**
 *
 * @author Teemu
 */
@Entity
@Table(name="Book")
public class Book implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookID;
    @Column(name = "name")
    @Length(min=4, max=30)
    @NotBlank 
    private String name;
    @Column(name = "isbn")
    @NotBlank
    private String isbn;
    @Column(name = "publishingYear")
    @NotNull
    private Integer publishingYear;
    @Column(name = "authors")
    @NotBlank
    private String authors;
    @Column(name = "publishers")
    @NotBlank
    private String publishers;
 
    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(Integer publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }
    
    
    
    @Override
    public String toString(){
        return "Name: " +getName()  +
               " ISBN: "+ getIsbn() +
               " Year: " + getPublishingYear() +
               " Publishers: "+ getPublishers()+
               " Authors: " + getAuthors();
        
    }

    
}
