package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.utils.CommonConst;

@RestController()
@RequestMapping("/book")
public class BookRestController {
	@GetMapping()
	public List<Book> getAll() {
		return BookService.getAll();
	}

	@GetMapping("/get")
	public Book getById2(@RequestParam Integer id) {
		return BookService.getById(id);
	}
	@GetMapping("/{id}")
	public Book getById(@PathVariable Integer id) {
		return BookService.getById(id);
	}

	@PostMapping
	public int add( @RequestBody Book book) {
		return BookService.add(book);
	}

	@PutMapping
	public int update(Book book) {
		return BookService.updateById(book);
	}

	@DeleteMapping("/{id}")
	public int delete(@PathVariable Integer id) {
		return BookService.deleteById(id);
	}
}
