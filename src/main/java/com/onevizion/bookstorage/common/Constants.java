package com.onevizion.bookstorage.common;

public final class Constants {

    public static final class Queries {

        public static final String SELECT_ALL_BOOKS_SORTED_BY_TITLE_DESC_QUERY = "select * from book order by lower(book.title) desc";
        public static final String SELECT_BOOKS_BY_AUTHOR_QUERY = "select * from book where author = ?";
        public static final String SELECT_ALL_AUTHORS_NAMES_QUERY = "select distinct book.author from book";
        public static final String SELECT_AUTHORS_BY_CHAR_IN_TITLE_QUERY = "select distinct book.author from book where lower(title) like ?";
        public static final String SELECT_TITLES_BY_AUTHOR_AND_CHAR = "select book.title from book where author = ? and lower(title) like ?";
        public static final String SELECT_MAX_ID_QUERY = "select max(book.id) from book";

        public static final String INSERT_BOOK_QUERY = "insert into book (id, title, author, description) values (?, ?, ?, ?)";

    }

    public static final class Utils {

        public static final String SUCCESS_STATUS = "SUCCESS";
        public static final String UNSUCCESSFUL_STATUS = "UNSUCCESSFUL";
    }
}
