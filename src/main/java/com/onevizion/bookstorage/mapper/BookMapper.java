package com.onevizion.bookstorage.mapper;

import com.onevizion.bookstorage.common.pojo.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setAuthor(rs.getString("author"));
        book.setTitle(rs.getString("title"));
        book.setDescription(rs.getString("description"));
        return book;
    }
}
