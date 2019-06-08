package com.janaszek.persistence.vocabulary.repo;

import com.janaszek.persistence.vocabulary.model.VocabularyEntry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VocabularyEntryRepository extends CrudRepository<VocabularyEntry, Long> {

    List<VocabularyEntry> findByVocabularyCategoryCategory(String category);

    List<VocabularyEntry> findByTitle(String title);

    VocabularyEntry findById(long id);
}
