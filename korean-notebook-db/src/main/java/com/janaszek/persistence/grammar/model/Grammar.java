package com.janaszek.persistence.grammar.model;

import com.janaszek.persistence.model.Category;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="grammar", schema="korean_notebook_db")
public class Grammar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idgrammar;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "category_idcategory"))
    private Category category;

    public long getIdgrammar() {
        return idgrammar;
    }

    public void setIdgrammar(long idgrammar) {
        this.idgrammar = idgrammar;
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
        Grammar grammar = (Grammar) o;
        return idgrammar == grammar.idgrammar &&
                Objects.equals(category, grammar.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idgrammar, category);
    }

    @Override
    public String toString() {
        return "Grammar [id=" + idgrammar + ", category=" + category.getCategory() + "]";
    }

}