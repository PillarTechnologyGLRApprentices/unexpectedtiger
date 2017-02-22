package com.pillartechnology.unexpectedtiger.entity;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity {

    private Integer id;
    private String categoryName;

    public CategoryEntity() {
    }

    public CategoryEntity(String categoryName) {
        this.categoryName = categoryName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name = "NAME", nullable = false)
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
