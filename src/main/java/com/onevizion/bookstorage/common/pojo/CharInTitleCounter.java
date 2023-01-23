package com.onevizion.bookstorage.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "authorName",
        "charUseCounter"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharInTitleCounter {

    @JsonProperty(value = "authorName", required = true)
    private String authorName;

    @JsonProperty(value = "charUseCounter", required = true)
    private Long charUseCounter;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Long getCharUseCounter() {
        return charUseCounter;
    }

    public void setCharUseCounter(Long charUseCounter) {
        this.charUseCounter = charUseCounter;
    }
}
