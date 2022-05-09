package com.api.book.services;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;





 //   private static List<Book> list = new ArrayList<>();

//    static {
//        list.add(new Book(13,"Python 2nd edition","Ahmad"));
//        list.add(new Book(14,"JavaScript 1st edition","Mohsin"));
//        list.add(new Book(15,"Ruby AND Rales 2nd edition","Ali"));
//    }

    //get all books
    public List<Book> getAllBooks(){
        List<Book> list=(List<Book>) this.bookRepository.findAll();
        return list;
    }

    public Book getBookById(int id)
    {
        Book book = null;
        try {
            book = this.bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;

        // book = list.stream().filter(e->e.getId()==id).findFirst().get();
//        return book;
    }
    //adding the book
    public Book addBook(Book b)
    {
        Book result = bookRepository.save(b);
        return result;
    }

    //delete the book
    public void deleteBook(int bid) {
//        list =list.stream().filter(book-> book.getId()!=bid).collect(Collectors.toList());
    bookRepository.deleteById(bid);
    }

    //update the book
    public void updateBook(Book book, int bookId){
//        list=list.stream().map(b->{
//            if(b.getId()==bookId){
//                b.setTitle(book.getTitle());
//                b.setAuthor(book.getAuthor());
//            }
//            return b;
//        }).collect(Collectors.toList());
        book.setId(bookId);
        bookRepository.save(book);
    }
}
