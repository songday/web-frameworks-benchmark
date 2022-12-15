package com.songday.benchmark.springboot3mvc.dao;

import com.songday.benchmark.springboot3mvc.model.Book;
import org.apache.ibatis.annotations.*;

public interface BookMapper {
    @Insert("INSERT INTO books(id,title,preview,price,created_at)VALUES(#{id},#{title},#{preview},#{price},#{createdAt})")
    void addBook(Book book);

    @Select("SELECT * FROM books ORDER BY id DESC LIMIT 1")
    Book getLatestBook();

    @Update("UPDATE books SET preview=#{preview} WHERE id=#{id}")
    int updatePreview(Book book);

    @Delete("DELETE FROM books WHERE id=#{id}")
    int delete(String id);
}
