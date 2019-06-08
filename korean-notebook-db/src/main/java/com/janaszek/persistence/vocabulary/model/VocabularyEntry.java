package com.janaszek.persistence.vocabulary.model;

import javax.persistence.*;

@Entity
@Table(name="vocabulary_entry", schema="korean_notebook_db")
public class VocabularyEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idvocabulary_entry;

    @Column
    private String description;

    @Column
    private String title;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "vocabulary_idvocabulary"))
    private Vocabulary vocabulary;

    public VocabularyEntry() {
        super();
    }

    public VocabularyEntry(String title, String description, Vocabulary vocabulary) {
        super();
        this.title = title;
        this.description = description;
        this.vocabulary = vocabulary;
    }

    public long getIdvocabulary_entry() {
        return idvocabulary_entry;
    }

    public void setIdvocabulary_entry(long idvocabulary_entry) {
        this.idvocabulary_entry = idvocabulary_entry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Vocabulary getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(Vocabulary vocabulary) {
        this.vocabulary = vocabulary;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + (int) (idvocabulary_entry ^ (idvocabulary_entry >>> 32));
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VocabularyEntry other = (VocabularyEntry) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (idvocabulary_entry != other.idvocabulary_entry)
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Vocabulary Entry [id=" + idvocabulary_entry + ", title=" + title + ", description=" + description + "]";
    }

}