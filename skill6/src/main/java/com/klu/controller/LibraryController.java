package com.klu.controller;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Book;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {

    // In-memory book list
    private List<Book> bookList = new ArrayList<>();

    // 1. /welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Online Library System!";
    }

    // 2. /count
    @GetMapping("/count")
    public int getCount() {
        return 100;
    }

    // 3. /price
    @GetMapping("/price")
    public double getPrice() {
        return 499.99;
    }

    // 4. /books
    @GetMapping("/books")
    public List<String> getBooks() {
        List<String> titles = new ArrayList<>();
        titles.add("Spring Boot Basics");
        titles.add("Java Programming");
        titles.add("Full Stack Development");
        return titles;
    }

    // 5. /books/{id}
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Details of Book with ID: " + id;
    }

    // 6. /search?title=Java
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "You searched for book: " + title;
    }

    // 7. /author/{name}
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by: " + name;
    }

    // 8. /addbook (POST)
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully!";
    }

    // 9. /viewbooks
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}
