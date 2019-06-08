package com.janaszek.persistence.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="category", schema="korean_notebook_db")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idcategory;

    @Column(nullable = false)
    private String category;

    public long getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(long idcategory) {
        this.idcategory = idcategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category1 = (Category) o;
        return idcategory == category1.idcategory &&
                Objects.equals(category, category1.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcategory, category);
    }

    @Override
    public String toString() {
        return "Category [id=" + idcategory + ", title=" + category + "]";
    }

}