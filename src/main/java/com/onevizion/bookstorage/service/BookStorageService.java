package com.onevizion.bookstorage.service;

import com.onevizion.bookstorage.common.dao.BookDao;
import com.onevizion.bookstorage.common.pojo.Author;
import com.onevizion.bookstorage.common.pojo.Book;
import com.onevizion.bookstorage.common.pojo.CharInTitleCounter;
import com.onevizion.bookstorage.common.pojo.request.AdditionBookRequest;
import com.onevizion.bookstorage.common.pojo.request.AuthorsByCharRequest;
import com.onevizion.bookstorage.common.pojo.response.AuthorsByCharResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service("bookStorageService")
public class BookStorageService {

    private final BookDao bookDao;

    @Autowired
    public BookStorageService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<Book> getSortedDescendentBooks() {
        return bookDao.getBooksSortedByTitleDesc();
    }

    public boolean addBookByRequest(AdditionBookRequest request) {
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setDescription(request.getDescription());
        book.setAuthor(request.getAuthor());
        return bookDao.createBook(book);
    }

    public List<Author> getAuthors() {
        List<Author> authors = bookDao.getAuthorsNames().stream()
                .map(an -> {
                    Author author = new Author();
                    author.setBooks(bookDao.getBooksByAuthorName(an));
                    author.setName(an);
                    return author;
                }).collect(Collectors.toList());
        return authors;
    }

    public AuthorsByCharResponse getAuthorsWithCharInTitleUsingByRequest(AuthorsByCharRequest request) {
        AuthorsByCharResponse result = new AuthorsByCharResponse();
        char charToFind = request.getCharForCounting().toCharArray()[0];
        List<CharInTitleCounter> counters = this.countingCharUsing(charToFind);
        Collections.sort(counters, (o1, o2) -> {
            if (o1.getCharUseCounter() < o2.getCharUseCounter()) {
                return 1;
            } else if (o1.getCharUseCounter() > o2.getCharUseCounter()) {
                return -1;
            }
            return 0;
        });
        result.setCharInTitleCounters(counters);
        return result;
    }

    // return list of first 10 authors with using argument char in their books titles,
    // descend sorted by char using counter
    private List<CharInTitleCounter> countingCharUsing(char charToCounting) {
        final char lowerCharToCounting = Character.toLowerCase(charToCounting);
        List<String> authorsWithCharInTitle = bookDao.getAuthorsNamesWithCharInTitle(lowerCharToCounting);
        List<CharInTitleCounter> result = authorsWithCharInTitle.stream()
                .map(a -> {
                    CharInTitleCounter counter = new CharInTitleCounter();
                    counter.setAuthorName(a);
                    List<String> titles = bookDao.getTitlesByAuthorAndChar(a, lowerCharToCounting);
                    counter.setCharUseCounter(getCountOfCharUsingInTitlesList(titles, lowerCharToCounting));
                    return counter;
                })
                .limit(10)
                .collect(Collectors.toList());
        return result;
    }

    private long getCountOfCharUsingInTitlesList(List<String> titlesList, char charToCount) {
        long result = 0L;
        for(String title : titlesList) {
            result += this.getCountOfCharUsingInLowerTitle(title, charToCount);
        }
        return result;
    }

    private int getCountOfCharUsingInLowerTitle(String title, char charToCount) {
        title = title.toLowerCase();
        return StringUtils.countMatches(title, charToCount);
    }
}
