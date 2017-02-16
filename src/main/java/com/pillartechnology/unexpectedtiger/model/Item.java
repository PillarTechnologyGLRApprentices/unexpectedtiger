package com.pillartechnology.unexpectedtiger.model;


public class Item {

    private String content;
    private String fileName;

    public Item() {

    }

    public Item(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return content.equals(item.content);
    }

    @Override
    public int hashCode() {
        if (content == null) { return Integer.MAX_VALUE; }

        return content.hashCode();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
