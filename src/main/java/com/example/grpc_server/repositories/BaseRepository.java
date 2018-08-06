package com.example.grpc_server.repositories;

import org.postgresql.ds.PGPoolingDataSource;
import org.skife.jdbi.v2.DBI;

public class BaseRepository<T> {
    private static PGPoolingDataSource source;

    public BaseRepository() {
    }

    protected static DBI getDBI() {
        initializeConnectionPool();
        return new DBI(source);
    }

    protected T getDBInterface(Class<T> dBInterfaceClass) {
        DBI connection = getDBI();
        return connection.open(dBInterfaceClass);
    }

    private static void initializeConnectionPool() {
        if (source == null) {
            source = new PGPoolingDataSource();
            source.setServerName("localhost:5432");
            source.setDatabaseName("guestbook");
            source.setUser("postgres");
            source.setPassword("");
            source.setMaxConnections(25);
        }
    }
}
