package com.example.grpc_server.repositories;

import com.example.grpc_server.models.GuestBook;

import java.util.List;

public class GuestBookRepository extends BaseRepository<GuestBookDBI> {

    public void save(GuestBook guestBook) {
        GuestBookDBI dbi = getDBInterface(GuestBookDBI.class);
        dbi.save(guestBook);
        dbi.close();
    }

    public List<GuestBook> getAll() {
        GuestBookDBI dbi = getDBInterface(GuestBookDBI.class);
        try {
            return dbi.getAll();
        } finally {
            dbi.close();
        }
    }
}
