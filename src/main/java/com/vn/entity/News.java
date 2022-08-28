package com.vn.entity;

import javax.persistence.*;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String content;
    private int view;
    private String image;
    private String tag;
    private String author;
    private int status;

    @ManyToOne
    @JoinColumn(name = "idCategory", referencedColumnName = "idCategory")
    private Category category;

    public News() {
    }

    public News(String title, String description, String content, String image, String author, Category category) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.image = image;
        this.author = author;
        this.category = category;
    }

    public News(Integer id, String title, String description, String content, int view, String image, String tag, String author, int status, Category category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.view = view;
        this.image = image;
        this.tag = tag;
        this.author = author;
        this.status = status;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
