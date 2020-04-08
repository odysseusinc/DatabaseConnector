package org.ohdsi.databaseConnector;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BigQueryStreamLoader {

    private static List<String> BIGQUARY_JDBC_DRIVER_CLASSES = Stream.of(
            "com.simba.googlebigquery.jdbc.jdbc42.S42ConnectionHandle",
            "com.simba.googlebigquery.jdbc.jdbc42.S42Connection",
            "com.simba.googlebigquery.jdbc.jdbc42.S41ConnectionHandle",
            "com.simba.googlebigquery.jdbc.jdbc41.S41Connection")
            .collect(Collectors.toList());

    public static boolean isStreamLoadAvailable(Connection connection) {

        return BIGQUARY_JDBC_DRIVER_CLASSES.contains(connection.getClass().getName());
    }



}