package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class LibraryHelperTest {

    @Mock
    private LibraryService service;

    @InjectMocks
    private LibraryHelper helper;

    @Test
    void testCountBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Intro OOP", "Bevan"));
        books.add(new Book(2, "Pengujian PL itu mudah", "Ernest"));
        Mockito.when(service.getAllBooks()).thenReturn(books);
        Assertions.assertEquals( 2, helper.countBooks());
    }

    @Test
    void testSaveEmptyBooks() {
        List<Book> books = new ArrayList<>();
        helper.saveBooks(books);
        Mockito.verify(service, Mockito.never()).storeBooks(any());
    }

    @Test
    void testNotEmptyBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Intro OOP", "Bevan"));
        books.add(new Book(2, "Pengujian PL itu mudah", "Ernest"));
        helper.saveBooks(books);

        Mockito.verify(service).storeBooks(books);
    }
}