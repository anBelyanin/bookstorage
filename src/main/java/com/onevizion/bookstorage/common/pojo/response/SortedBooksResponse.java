package com.onevizion.bookstorage.common.pojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.onevizion.bookstorage.common.pojo.Book;

import java.util.List;

@JsonPropertyOrder({
        "sortedBooksList"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class SortedBooksResponse {

    @JsonProperty(value = "sortedBooksList", required = true)
    private List<Book> sortedBooksList;

    public List<Book> getSortedBooksList() {
        return sortedBooksList;
    }

    public void setSortedBooksList(List<Book> sortedBooksList) {
        this.sortedBooksList = sortedBooksList;
    }
}
