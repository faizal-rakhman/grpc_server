package com.example.grpc_server.repositories;

import com.example.grpc_server.models.GuestBook;

import java.util.List;

public class GuestBookRepository extends BaseRepository<GuestBookDBI> {

    public Integer save(String name, String comment) {
        GuestBookDBI dbi = getDBInterface(GuestBookDBI.class);
        try {
            return dbi.save(name, comment);
        } finally {
            dbi.close();
        }
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
