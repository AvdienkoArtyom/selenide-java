package com.herokuapp.the_internet.core.model.dynamic_content;

import java.util.Objects;

public class ContentRow {
    private String imageSource;
    private String content;

    public ContentRow(String imageSource, String content) {
        this.imageSource = imageSource;
        this.content = content;
    }

    public String getImageSource() {
        return imageSource;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContentRow that = (ContentRow) o;
        return Objects.equals(imageSource, that.imageSource) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageSource, content);
    }
}
