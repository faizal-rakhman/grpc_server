package com.example.grpc_server.repositories;

import com.example.grpc_server.models.GuestBook;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(GuestBookMapper.class)
public interface GuestBookDBI {

    void close();

    @SqlUpdate("INSERT INTO guestbook(name, comment) VALUES(:name, :comment)")
    void save(@BindBean GuestBook guestBook);

    @SqlQuery("SELECT id, name, comment FROM guestbook")
    List<GuestBook> getAll();

}
