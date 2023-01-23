package com.onevizion.bookstorage.common.pojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.onevizion.bookstorage.common.pojo.Author;

import java.util.List;

@JsonPropertyOrder({
        "authors"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class BooksGroupedByAuthorResponse {

    @JsonProperty(value = "authors", required = true)
    private List<Author> authors;

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
