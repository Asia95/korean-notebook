package com.janaszek.persistence.vocabulary.repo;

import com.janaszek.persistence.vocabulary.model.VocabularyEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VocabularyEntryRepository extends CrudRepository<VocabularyEntry, Long> {

    List<VocabularyEntry> findByVocabularyCategoryCategory(String category);

    List<VocabularyEntry> findByTitle(String title);

    VocabularyEntry findById(long id);

    @Query("select ve from VocabularyEntry ve where ve.title like %:search% or ve.description like %:search%")
    List<VocabularyEntry> searchByTitleOrDescription(@Param("search") String search);
}
