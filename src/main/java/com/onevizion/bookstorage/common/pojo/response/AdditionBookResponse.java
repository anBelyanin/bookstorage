package com.onevizion.bookstorage.common.pojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "status",
        "bookTitle",
        "message"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionBookResponse {

    @JsonProperty(value = "status", required = true)
    private String status;

    @JsonProperty(value = "bookTitle")
    private String bookTitle;

    @JsonProperty(value = "message")
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
