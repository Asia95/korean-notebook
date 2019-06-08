package com.janaszek.web;

import com.janaszek.persistence.model.Book;
import com.janaszek.persistence.model.Category;
import com.janaszek.persistence.model.GrammarEntry;
import com.janaszek.persistence.repo.CategoryRepository;
import com.janaszek.persistence.repo.GrammarEntryRepository;
import com.janaszek.web.exception.BookIdMismatchException;
import com.janaszek.web.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
//                .orElseThrow(BookNotFoundException::new);
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
//                .orElseThrow(BookNotFoundException::new);
//        bookRepository.deleteById(id);
//    }
//
//    @PutMapping("/{id}")
//    public Book updateBook(@RequestBody Book book, @PathVariable long id) {
//        if (book.getId() != id) {
//            throw new BookIdMismatchException();
//        }
//        bookRepository.findById(id)
//                .orElseThrow(BookNotFoundException::new);
//        return bookRepository.save(book);
//    }
}
