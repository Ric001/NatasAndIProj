package com.falcontech.gradeit.DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class MySQLConnector implements ISinggleConnector {
    private static MySQLConnector connector;
    private Connection connection;

    private MySQLConnector() { }

    @Override
    public Connection connect() throws SQLException {
        if (Objects.isNull(connection))
            connection = DriverManager.getConnection("");
        return connection;
    }

    public static ISinggleConnector connector() {
        if (Objects.isNull(connector))
            connector = new MySQLConnector();
        return connector;
    }
}