package com.janaszek.web;

import com.janaszek.persistence.vocabulary.model.VocabularyEntry;
import com.janaszek.persistence.vocabulary.repo.VocabularyEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/vocabulary")
public class VocabularyController {

    @Autowired
    private VocabularyEntryRepository vocabularyEntryRepository;

    @GetMapping(produces = "application/json;charset=UTF-8")
    public Iterable<VocabularyEntry> findAll() {
        return vocabularyEntryRepository.findAll();
    }

    @GetMapping(params = "category", produces = "application/json;charset=UTF-8")
    public List<VocabularyEntry> findByCategory(@RequestParam("category") String category) {
        return vocabularyEntryRepository.findByVocabularyCategoryCategory(category);
    }

    @GetMapping(params = "id", produces = "application/json;charset=UTF-8")
    public VocabularyEntry findById(@RequestParam("id") long id) {
        return vocabularyEntryRepository.findById(id);
    }

    @GetMapping(params = "search", produces = "application/json;charset=UTF-8")
    public List<VocabularyEntry> searchByTitleOrDescription(@RequestParam("search") String search) {
        return vocabularyEntryRepository.searchByTitleOrDescription(search);
    }

//
//    @GetMapping("/{id}")
//    public Book findOne(@PathVariable long id) {
//        return bookRepository.findById(id)
//                .orElseThrow(NotFoundException::new);
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Book create(@RequestBody Book book) {
//        Book book1 = bookRepository.save(book);
//        return book1;
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable long id) {
//        bookRepository.findById(id)
//                .orElseThrow(NotFoundException::new);
//        bookRepository.deleteById(id);
//    }
//
//    @PutMapping("/{id}")
//    public Book updateBook(@RequestBody Book book, @PathVariable long id) {
//        if (book.getId() != id) {
//            throw new BookIdMismatchException();
//        }
//        bookRepository.findById(id)
//                .orElseThrow(NotFoundException::new);
//        return bookRepository.save(book);
//    }
}
