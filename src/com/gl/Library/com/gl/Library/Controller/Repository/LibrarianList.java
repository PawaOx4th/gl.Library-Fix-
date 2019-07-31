package com.gl.Library.com.gl.Library.Controller.Repository;

import com.gl.Library.com.gl.Library.Class.Object.Librarian;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LibrarianList {
    // Create variable
    private List<Librarian> librarians = new ArrayList<>();

    // Getter & Setter
    public List<Librarian> getLibrarians() {

        return librarians;
    }

    public void setLibrarians(List<Librarian> librarians) {

        this.librarians = librarians;
    }

    // Example librarian data
    public void DataLibrarianList(LibrarianList librarians) {
        librarians.getLibrarians().add(new Librarian(UUID.randomUUID(), "Ichika", "Nakano", "1", "1"));
        librarians.getLibrarians().add(new Librarian(UUID.randomUUID(), "Nino", "Nakano", "2222", "2222"));
        librarians.getLibrarians().add(new Librarian(UUID.randomUUID(), "Miku", "Nakano", "3333", "3333"));
        librarians.getLibrarians().add(new Librarian(UUID.randomUUID(), "Yotsuba", "Nakano", "4444", "4444"));
        librarians.getLibrarians().add(new Librarian(UUID.randomUUID(), "Itsuki", "Nakano", "5555", "5555"));


    }

}
