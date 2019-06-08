package com.janaszek.persistence.model;

import javax.persistence.*;

@Entity
@Table(name="category", schema="korean_notebook_db")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idcategory;

    @Column(nullable = false)
    private String category;

    @Override
    public String toString() {
        return "Category [id=" + idcategory + ", title=" + category + "]";
    }

}