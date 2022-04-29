package com.api.book.services;

import com.api.book.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {
    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(13,"Python 2nd edition","Ahmad"));
        list.add(new Book(14,"JavaScript 1st edition","Mohsin"));
        list.add(new Book(15,"Ruby AND Rales 2nd edition","Ali"));
    }

    //get all books
    public List<Book> getAllBooks(){
        return list;
    }

    public Book getBookById(int id)
    {
        Book book = null;
        book = list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }
    //adding the book
    public Book addBook(Book b)
    {
        list.add(b);
        return b;
    }

    //delete the book
    public void deleteBook(int bid) {
        list =list.stream().filter(book-> book.getId()!=bid).collect(Collectors.toList());
    }

    //update the book
    public void updateBook(Book book, int bookId){
        list=list.stream().map(b->{
            if(b.getId()==bookId){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
