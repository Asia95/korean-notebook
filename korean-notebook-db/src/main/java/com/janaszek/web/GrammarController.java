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

    @GetMapping
    public Iterable<GrammarEntry> findAll() {
        return grammarEntryRepository.findAll();
    }

    @GetMapping(params = "category")
    public List<GrammarEntry> findByCategory(@RequestParam("category") String category) {
        return grammarEntryRepository.findByGrammarCategoryCategory(category);
    }

    @GetMapping(params = "id")
    public GrammarEntry findById(@RequestParam("id") long id) {
        return grammarEntryRepository.findById(id);
    }
}
