package com.vn.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<News> newsList;

    public Category() {
    }

    public Category(Integer idCategory, String name) {
        this.idCategory = idCategory;
        this.name = name;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
