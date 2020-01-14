package com.liuren.controller;

import com.liuren.pojo.Books;
import com.liuren.service.BookService;
import com.liuren.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String listAllBook(Model model){

        List<Books> books = bookService.queryAllBook();
//        for (Books book : books) {
//            System.out.println(book.getBookID());
//        }
        model.addAttribute("list",books);

        return "allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddPage(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("book=>"+books);
        bookService.addBook(books);

        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBook/{bookID}")
    public String toUpdatePage(Model model,@PathVariable("bookID") int id){
        Books books = bookService.queryBookById(id);
        model.addAttribute("book",books);

        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        bookService.updateBook(books);

        return "redirect:/book/allBook";
    }



    @RequestMapping("/queryBook")
    public String queryBookByName(Model model,String bookName){
        List<Books> books = bookService.queryBookByLike(bookName);
        model.addAttribute("list",books);

        return "allBook";
    }

    @RequestMapping("/del/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id){
        bookService.deleteBook(id);

        return "redirect:/book/allBook";
    }

}
