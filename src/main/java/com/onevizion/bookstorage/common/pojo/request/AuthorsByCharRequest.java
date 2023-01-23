package com.onevizion.bookstorage.common.pojo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "charForCounting"
})
public class AuthorsByCharRequest {

    @JsonProperty("charForCounting")
    private String charForCounting;

    public String getCharForCounting() {
        return charForCounting;
    }

    public void setCharForCounting(String charForCounting) {
        this.charForCounting = charForCounting;
    }
}
