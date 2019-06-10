package com.janaszek.persistence.grammar.repo;

import com.janaszek.persistence.grammar.model.GrammarEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GrammarEntryRepository extends CrudRepository<GrammarEntry, Long> {

    List<GrammarEntry> findByGrammarCategoryCategory(String category);

    List<GrammarEntry> findByTitle(String title);

    GrammarEntry findById(long id);

    @Query("select ge from GrammarEntry ge where ge.title like %:search% or ge.body like %:search%")
    List<GrammarEntry> searchByTitleOrBody(@Param("search") String search);
}
