package com.janaszek.web;

import com.janaszek.persistence.grammar.model.GrammarEntry;
import com.janaszek.persistence.grammar.repo.GrammarEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/grammar")
public class GrammarController {

    @Autowired
    private GrammarEntryRepository grammarEntryRepository;

    @GetMapping(produces = "application/json;charset=UTF-8")
    public Iterable<GrammarEntry> findAll() {
        return grammarEntryRepository.findAll();
    }

    @GetMapping(params = "category", produces = "application/json;charset=UTF-8")
    public List<GrammarEntry> findByCategory(@RequestParam("category") String category) {
        return grammarEntryRepository.findByGrammarCategoryCategory(category);
    }

    @GetMapping(params = "search", produces = "application/json;charset=UTF-8")
    public List<GrammarEntry> searchByTitleOrBody(@RequestParam("search") String search) {
        return grammarEntryRepository.searchByTitleOrBody(search);
    }

    @GetMapping(params = "id", produces = "application/json;charset=UTF-8")
    public GrammarEntry findById(@RequestParam("id") long id) {
        return grammarEntryRepository.findById(id);
    }
}
