package com.janaszek.persistence.model;

import javax.persistence.*;

@Entity
@Table(name="grammar_entry", schema="korean_notebook_db")
public class GrammarEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idgrammar_entry;

    @Column
    private String body;

    @Column
    private String title;

    @Column(nullable = false)
    private long grammar_idgrammar;

    public GrammarEntry() {
        super();
    }

    public GrammarEntry(String title, String body, long grammar_idgrammar) {
        super();
        this.title = title;
        this.body = body;
        this.grammar_idgrammar = grammar_idgrammar;
    }

    public long getIdgrammar_entry() {
        return idgrammar_entry;
    }

    public void setIdgrammar_entry(long idgrammar_entry) {
        this.idgrammar_entry = idgrammar_entry;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getGrammar_idgrammar() {
        return grammar_idgrammar;
    }

    public void setGrammar_idgrammar(long grammar_idgrammar) {
        this.grammar_idgrammar = grammar_idgrammar;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((body == null) ? 0 : body.hashCode());
        result = prime * result + (int) (idgrammar_entry ^ (idgrammar_entry >>> 32));
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
        GrammarEntry other = (GrammarEntry) obj;
        if (body == null) {
            if (other.body != null)
                return false;
        } else if (!body.equals(other.body))
            return false;
        if (idgrammar_entry != other.idgrammar_entry)
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
        return "Grammar Entry [id=" + idgrammar_entry + ", title=" + title + ", body=" + body + "]";
    }

}