package com.janaszek.persistence.vocabulary.model;

import com.janaszek.persistence.category.model.Category;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="vocabulary", schema="korean_notebook_db")
public class Vocabulary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idvocabulary;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "category_idcategory"))
    private Category category;

    public long getIdvocabulary() {
        return idvocabulary;
    }

    public void setIdvocabulary(long idvocabulary) {
        this.idvocabulary = idvocabulary;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vocabulary vocabulary = (Vocabulary) o;
        return idvocabulary == vocabulary.idvocabulary &&
                Objects.equals(category, vocabulary.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idvocabulary, category);
    }

    @Override
    public String toString() {
        return "Vocabulary [id=" + idvocabulary + ", category=" + category.getCategory() + "]";
    }

}