package com.gmail.creativegeeksuresh.libraryapp.repository;

import com.gmail.creativegeeksuresh.libraryapp.model.BookRequest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRequestRepository extends CrudRepository<BookRequest, Integer> {

    public BookRequest findByBookId(String bookId);
}