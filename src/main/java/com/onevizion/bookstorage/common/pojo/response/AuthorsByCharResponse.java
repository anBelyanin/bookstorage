package com.onevizion.bookstorage.common.pojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.onevizion.bookstorage.common.pojo.CharInTitleCounter;

import java.util.List;

@JsonPropertyOrder({
        "charInTitleCounters"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorsByCharResponse {

    @JsonProperty(value = "charInTitleCounters", required = true)
    private List<CharInTitleCounter> charInTitleCounters;

    public List<CharInTitleCounter> getCharInTitleCounters() {
        return charInTitleCounters;
    }

    public void setCharInTitleCounters(List<CharInTitleCounter> charInTitleCounters) {
        this.charInTitleCounters = charInTitleCounters;
    }
}
