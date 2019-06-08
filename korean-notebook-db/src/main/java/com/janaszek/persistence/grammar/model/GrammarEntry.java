package com.janaszek.persistence.grammar.model;

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

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "grammar_idgrammar"))
    @Column(nullable = false)
    private Grammar grammar;

    public GrammarEntry() {
        super();
    }

    public GrammarEntry(String title, String body, Grammar grammar) {
        super();
        this.title = title;
        this.body = body;
        this.grammar = grammar;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Grammar getGrammar() {
        return grammar;
    }

    public void setGrammar(Grammar grammar) {
        this.grammar = grammar;
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