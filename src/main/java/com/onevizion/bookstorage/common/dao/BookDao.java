package com.onevizion.bookstorage.common.dao;

import com.onevizion.bookstorage.common.Constants;
import com.onevizion.bookstorage.common.pojo.Book;
import com.onevizion.bookstorage.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("bookDao")
public class BookDao {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Book> rowMapper;

    @Autowired
    public BookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = new BookMapper();
    }

    public List<Book> getBooksSortedByTitleDesc() {
        List<Book> result = jdbcTemplate.query(Constants.Queries.SELECT_ALL_BOOKS_SORTED_BY_TITLE_DESC_QUERY, rowMapper);
        return result;
    }

    public List<String> getAuthorsNames() {
        List<String> authorsNames = jdbcTemplate.queryForList(Constants.Queries.SELECT_ALL_AUTHORS_NAMES_QUERY, String.class);
        return authorsNames;
    }

    public List<Book> getBooksByAuthorName(String authorName) {
        List<Book> booksByAuthor =
                jdbcTemplate.query(Constants.Queries.SELECT_BOOKS_BY_AUTHOR_QUERY, rowMapper, authorName);
        return booksByAuthor;
    }

    public Long getMaxId() {
        Long result = jdbcTemplate.queryForObject(Constants.Queries.SELECT_MAX_ID_QUERY, Long.class);
        return result;
    }

    public boolean createBook(Book book) {
        // generating new id should be resolved by sequence, but for this example it's enough
        Long currentMaxId = this.getMaxId();
        int resultOfInsertion = jdbcTemplate.update(Constants.Queries.INSERT_BOOK_QUERY,
                (currentMaxId + 1L), book.getTitle(), book.getAuthor(), book.getDescription());
        return resultOfInsertion > 0;
    }

    public List<String> getAuthorsNamesWithCharInTitle(char charToFind) {
        return jdbcTemplate.queryForList(Constants.Queries.SELECT_AUTHORS_BY_CHAR_IN_TITLE_QUERY,
                String.class, ("%" + charToFind + "%"));
    }

    public List<String> getTitlesByAuthorAndChar(String author, char charToFind) {
        return jdbcTemplate.queryForList(Constants.Queries.SELECT_TITLES_BY_AUTHOR_AND_CHAR,
                String.class, author, ("%" + charToFind + "%"));
    }
}
