package com.example.grpc_server.repositories;

import com.example.grpc_server.models.GuestBook;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(GuestBookMapper.class)
public interface GuestBookDBI {

    void close();

    @SqlUpdate("INSERT INTO guestbook(name, comment) VALUES(:name, :comment)")
    @GetGeneratedKeys
    Integer save(@Bind("name") String name, @Bind("comment") String comment);

    @SqlQuery("SELECT id, name, comment FROM guestbook")
    List<GuestBook> getAll();

}
