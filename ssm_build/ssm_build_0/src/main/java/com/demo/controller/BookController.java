package com.demo.controller;/*
 * @author noelt
 * @description
 */

import com.demo.pojo.Books;
import com.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBooks")
    public String list(Model model){
        List<Books> books = bookService.queryAllBook();
        model.addAttribute("list", books);
        return "allBooks";
    }

    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books book){
        System.out.println(book.toString());
        bookService.addBook(book);
        return "redirect:/book/allBooks";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id){
        Books book = bookService.queryBookById(id);
        System.out.println(book.toString());
        model.addAttribute("book", book);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book){
        bookService.updateBook(book);
        return "redirect:/book/allBooks";
    }

    @RequestMapping("/del/{bookId}")
    public String delBook(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBooks";
    }
}
