package com.pillartechnology.unexpectedtiger.entities;

import javax.persistence.*;

@Entity(name = "Item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column
    private String content;

    public ItemEntity() {

    }

    public ItemEntity(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id.intValue();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
