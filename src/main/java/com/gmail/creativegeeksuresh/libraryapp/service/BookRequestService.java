package com.gmail.creativegeeksuresh.libraryapp.service;

import com.gmail.creativegeeksuresh.libraryapp.dto.BookRequestDto;
import com.gmail.creativegeeksuresh.libraryapp.exception.InvalidBookException;
import com.gmail.creativegeeksuresh.libraryapp.model.Book;
import com.gmail.creativegeeksuresh.libraryapp.model.BookRequest;
import com.gmail.creativegeeksuresh.libraryapp.repository.BookRequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookRequestService {

    @Autowired
    private BookRequestRepository bookRequestRepo;

    @Autowired
    private BookService bookService;

    public BookRequest createRequest(BookRequestDto request) throws InvalidBookException, Exception {

        Book book = bookService.findByUid(request.getBookId());
        if (book == null)
            throw new InvalidBookException("Book does not exists");
        else {
            BookRequest newRequest = new BookRequest();
            newRequest.setBookId(request.getBookId());
            newRequest.setTitle(request.getTitle());
            newRequest.setRequestedBy(request.getRequestedBy());
            return bookRequestRepo.save(newRequest);
        }
    }

    public void deleteRequest(String bookId) throws Exception {
        BookRequest request = bookRequestRepo.findByBookId(bookId);
        if (request == null)
            throw new Exception("Requested Book does not exists");
        else {
            bookRequestRepo.delete(request);
        }
    }

    public void updateBookAvailablityAndDeleteRequest(String bookId) throws Exception {
        bookService.updateBookAvailablity(bookId, Boolean.TRUE);
        deleteRequest(bookId);
    }
}
