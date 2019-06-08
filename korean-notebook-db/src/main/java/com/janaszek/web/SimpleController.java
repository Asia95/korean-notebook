package com.janaszek.web;

import com.janaszek.persistence.model.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SimpleController {

    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public Book homePage2() {
        return new Book("test", "test2");
    }

    @GetMapping("/home")
    public Book homePage() {
        return new Book("test", "test2");
    }
}
