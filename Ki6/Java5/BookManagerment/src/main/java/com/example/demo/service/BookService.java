package com.example.demo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.model.Book;
import com.example.demo.utils.CommonConst;

public class BookService {
	private static final List<Book> _books = new ArrayList<Book>();
	static {
		_books.add(new Book(1, "Book1", 10, new BigDecimal(10000)));
		_books.add(new Book(2, "Book2", 10, new BigDecimal(20000)));
		_books.add(new Book(3, "Book3", 10, new BigDecimal(30000)));
		_books.add(new Book(4, "Book4", 10, new BigDecimal(140000)));
	}
	public static List<Book> getAll() {
		return  _books;
	}

	public static Book getById(Integer id) {
		for (Book book : _books) {
			if(book.getId()==id) {
				return book;
			}
		}
		return null;
	}

	public static int add(Book book) {
		try {
			_books.add(book);
			return CommonConst.SUCCESS;
		} catch (Exception e) {
			return CommonConst.ERROR;
		}
		
	}

	public static int updateById(Book book) {
		try {
			for(int i =0;i<_books.size();i++) {
				 if(book.get(i).getId()== book.getId()) {
					 _books.set(i, book);
				 }
				 return CommonConst.SUCCESS;
			}
			return CommonConst.SUCCESS;
		} catch (Exception e) {
			return CommonConst.ERROR;
		}
	}

	public static int deleteById(Integer deleteId) {
		try {
			for (Book book : _books) {
				if(book.getId()==deleteId) {
					_books.remove(book);
					return CommonConst.SUCCESS;
				}
			}
			return CommonConst.FAIL;
		} catch (Exception e) {
			return CommonConst.ERROR;
		}
		
	}
}
