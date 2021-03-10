package com.company;

//import com.company.FSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;

public class Sql implements FSql {


    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/End_oop", "postgres", "post");
            return con;

        } catch (Exception e) {
            System.out.println(e);


            return null;
        }
    }

}