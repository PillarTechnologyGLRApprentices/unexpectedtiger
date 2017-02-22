package com.pillartechnology.unexpectedtiger.entity;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String content;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CategoryEntity categoryEntity;

    public ItemEntity() {

    }

    public ItemEntity(String content) {
        this.content = content;
    }

    public ItemEntity(Integer id, String content, CategoryEntity categoryEntity) {
        this.id = id;
        this.content = content;
        this.categoryEntity = categoryEntity;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }
    @Column(name = "CATEGORY", unique = false, nullable = false)
    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }
}
