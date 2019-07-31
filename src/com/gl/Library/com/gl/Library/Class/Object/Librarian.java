package com.gl.Library.com.gl.Library.Class.Object;

import java.util.UUID;

public class Librarian extends Person {
    public Librarian() {
    }

    public Librarian(UUID uuid, String firstname, String lastname, String identity, String password) {
        super(uuid, firstname, lastname, identity, password);
    }
}
