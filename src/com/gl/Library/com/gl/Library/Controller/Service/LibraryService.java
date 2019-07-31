package com.gl.Library.com.gl.Library.Controller.Service;


import com.gl.Library.com.gl.Library.Class.Object.*;
import com.gl.Library.com.gl.Library.Class.Object.Librarian;
import com.gl.Library.com.gl.Library.Controller.Repository.*;

public class LibraryService {
    // Create variable
    private static LibraryService instance;
    private LibrarianList librariansService;
    private CustomerList customersService;
    private BookList booksService;
    private HistoryList historiesService;
    private Librarian librarianDetail;
    private Customer customerDetail;
    private Book bookDetail;
    private History historyDetail;

    private LibraryService() {

    }

    public static LibraryService getInstance() {
        if (instance == null) {
            instance = new LibraryService();
        }
        return instance;
    }

    // Getter & Setter
    public LibrarianList getLibrariansService() {

        return librariansService;
    }

    public void setLibrariansService(LibrarianList librariansService) {

        this.librariansService = librariansService;
    }

    public CustomerList getCustomersService() {
        return customersService;
    }

    public void setCustomersService(CustomerList customersService) {

        this.customersService = customersService;
    }

    public BookList getBooksService() {

        return booksService;
    }

    public void setBooksService(BookList booksService) {

        this.booksService = booksService;
    }

    public HistoryList getHistoriesService() {

        return historiesService;
    }

    public void setHistoriesService(HistoryList historiesService) {

        this.historiesService = historiesService;
    }

    public Librarian getLibrarianDetail() {

        return librarianDetail;
    }

    public void setLibrarianDetail(Librarian librarianDetail) {

        this.librarianDetail = librarianDetail;
    }

    public Customer getCustomerDetail() {

        return customerDetail;
    }

    public void setCustomerDetail(Customer customerDetail) {

        this.customerDetail = customerDetail;
    }

    public Book getBookDetail() {

        return bookDetail;
    }

    public void setBookDetail(Book bookDetail) {

        this.bookDetail = bookDetail;
    }

    public History getHistoryDetail() {

        return historyDetail;
    }

    public void setHistoryDetail(History historyDetail) {

        this.historyDetail = historyDetail;
    }
}
