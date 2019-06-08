package com.janaszek.web;

import com.janaszek.persistence.model.Category;
import com.janaszek.persistence.grammar.model.GrammarEntry;
import com.janaszek.persistence.repo.CategoryRepository;
import com.janaszek.persistence.grammar.repo.GrammarEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/grammar")
public class GrammarController {

    @Autowired
    private GrammarEntryRepository grammarEntryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public Iterable<GrammarEntry> findAll() {
        return grammarEntryRepository.findAll();
    }

    @GetMapping("/category")
    public Iterable<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

//    @GetMapping("/title/{bookTitle}")
//    public List<Book> findByTitle(@PathVariable String bookTitle) {
//        return bookRepository.findByTitle(bookTitle);
//    }
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
