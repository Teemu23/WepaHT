/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wad.booklibrary;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.matchers.JUnitMatchers;

/**
 *
 * @author Teemu
 */
public class BookTest {

    Book kirja;

    @Before
    public void setUp() {
        kirja = new Book();
    }

    @Test
    public void voiTallentaaName() {
        kirja.setName("Testi Kirja");
        assertEquals("Testi Kirja", kirja.getName());
    }


    @Test
    public void voiTallentaaAuthors() {
        kirja.setAuthors("mommo mies");
        assertEquals("mommo mies", kirja.getAuthors());
    }

    @Test
    public void voiTallentaaIsbn() {
        kirja.setIsbn("123");
        assertEquals("123", kirja.getIsbn());
    }

    @Test
    public void voiTallettaaPublishers() {
        kirja.setPublishers("Pekka ja patka");
        assertEquals("Pekka ja patka", kirja.getPublishers());
    }
    @Test
    public void voiTallettaaPublishingYear() {
        kirja.setPublishingYear(1999);
        Integer vuosi = 1999;
        assertEquals(vuosi, kirja.getPublishingYear());
    }
   
}
