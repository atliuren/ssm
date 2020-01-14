package com.liuren.service;

import com.liuren.mapper.BookMapper;
import com.liuren.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public int deleteBook(int id) {
        return bookMapper.deleteBook(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryBookByLike(String name) {
        return bookMapper.queryBookByLike(name);
    }
}
