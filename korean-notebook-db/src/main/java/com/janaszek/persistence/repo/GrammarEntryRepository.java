package com.janaszek.persistence.repo;

import com.janaszek.persistence.model.GrammarEntry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GrammarEntryRepository extends CrudRepository<GrammarEntry, Long> {
    List<GrammarEntry> findByTitle(String title);
}
