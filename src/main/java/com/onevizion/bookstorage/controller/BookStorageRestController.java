package com.onevizion.bookstorage.controller;

import com.onevizion.bookstorage.common.Constants;
import com.onevizion.bookstorage.common.pojo.request.AdditionBookRequest;
import com.onevizion.bookstorage.common.pojo.request.AuthorsByCharRequest;
import com.onevizion.bookstorage.common.pojo.response.AdditionBookResponse;
import com.onevizion.bookstorage.common.pojo.response.AuthorsByCharResponse;
import com.onevizion.bookstorage.common.pojo.response.BooksGroupedByAuthorResponse;
import com.onevizion.bookstorage.common.pojo.response.SortedBooksResponse;
import com.onevizion.bookstorage.service.BookStorageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class BookStorageRestController {

    private final BookStorageService bookStorageService;

    public BookStorageRestController(BookStorageService bookStorageService) {
        this.bookStorageService = bookStorageService;
    }

    @GetMapping("sorted-books")
    public SortedBooksResponse getDescendentSortedBooks() {
        SortedBooksResponse response = new SortedBooksResponse();
        response.setSortedBooksList(bookStorageService.getSortedDescendentBooks());
        return response;
    }

    @GetMapping("grouped-books")
    public BooksGroupedByAuthorResponse getBooksGroupedByAuthor() {
        BooksGroupedByAuthorResponse response = new BooksGroupedByAuthorResponse();
        response.setAuthors(bookStorageService.getAuthors());
        return response;
    }

    @PostMapping("add-book")
    public AdditionBookResponse addBook(@RequestBody AdditionBookRequest request) {
        AdditionBookResponse response = new AdditionBookResponse();
        try {
            bookStorageService.addBookByRequest(request);
            response.setStatus(Constants.Utils.SUCCESS_STATUS);
        } catch (Exception e) {
            response.setStatus(Constants.Utils.UNSUCCESSFUL_STATUS);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @GetMapping("/authors-by-char")
    public AuthorsByCharResponse getAuthorsByCharInTitle(@RequestBody AuthorsByCharRequest request) {
        return bookStorageService.getAuthorsWithCharInTitleUsingByRequest(request);
    }

}
