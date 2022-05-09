package com.api.book.controllers;

import com.api.book.entities.Book;
import com.api.book.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    //get all books handler
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks()
    {
        List<Book> list = bookService.getAllBooks();
        if (list.size() <= 0 ) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    // get single book handler
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id)
    {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    // add new book handle
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        Book b = this.bookService.addBook(book);
        System.out.println(book);
        return b;
    }

    // delete book handler
    @DeleteMapping ("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId){
        this.bookService.deleteBook(bookId);
    }

    //update book handler
    @PutMapping("/books/{bookId}")
    public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId){
        this.bookService.updateBook(book,bookId);
        return book;
    }
}
