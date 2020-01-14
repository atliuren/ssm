package com.liuren.mapper;

import com.liuren.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    //添加一本书籍
    int addBook(Books books);

    //修改一本书籍
    int updateBook(Books books);

    //删除一本书
    int deleteBook(@Param("bookID") int id);

    //查询所有书籍
    List<Books> queryAllBook();

    //根据id查询书籍
    Books queryBookById(@Param("bookID") int id);

    //书籍模糊查询
    List<Books> queryBookByLike(@Param("bookName") String name);
}
