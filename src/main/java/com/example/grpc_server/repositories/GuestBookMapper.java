package com.example.grpc_server.repositories;

import com.example.grpc_server.models.GuestBook;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestBookMapper implements ResultSetMapper<GuestBook> {

    @Override
    public GuestBook map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new GuestBook(r.getInt("id"), r.getString("name"), r.getString("comment"));
    }
}
