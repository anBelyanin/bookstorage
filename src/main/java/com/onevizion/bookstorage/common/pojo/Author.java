package com.onevizion.bookstorage.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({
        "name",
        "books"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty(value = "books")
    private List<Book> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
