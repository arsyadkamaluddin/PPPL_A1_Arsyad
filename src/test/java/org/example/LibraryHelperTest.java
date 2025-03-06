package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

class LibraryHelperTest {
    @Test
    void  testCountBooks(){
        LibraryService service = Mockito.mock(LibraryService.class);
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"Buku Biologi","Guru Biologi"));
        books.add(new Book(2,"Buku Agama","Guru Agama"));
        LibraryHelper helper = new LibraryHelper(service);
        Mockito.when(service.getAllBooks()).thenReturn(books);
        Assertions.assertEquals(2,helper.countBooks());
    }

    @Test
    void  testStoreBooksEmpty(){
        LibraryService service = Mockito.mock(LibraryService.class);
        List<Book> books = new ArrayList<>();
        LibraryHelper helper = new LibraryHelper(service);
        helper.saveBooks(books);
        Mockito.verify(service, Mockito.never()).storeBooks(books);
    }

    @Test
    void  testStoreBooksFilled(){
        LibraryService service = Mockito.mock(LibraryService.class);
        List<Book> books = new ArrayList<>();
        LibraryHelper helper = new LibraryHelper(service);
        books.add(new Book(1,"Buku Biologi","Guru Biologi"));
        books.add(new Book(2,"Buku Agama","Guru Agama"));
        helper.saveBooks(books);
        Mockito.verify(service, Mockito.atMostOnce()).storeBooks(books);
    }
}