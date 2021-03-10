package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;

public interface FSql {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}