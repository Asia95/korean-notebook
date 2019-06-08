package com.janaszek.persistence.grammar.repo;

import com.janaszek.persistence.grammar.model.GrammarEntry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GrammarEntryRepository extends CrudRepository<GrammarEntry, Long> {
    List<GrammarEntry> findByTitle(String title);
}
