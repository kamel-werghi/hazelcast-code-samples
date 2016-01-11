package com.hazelcast.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CreateDB {
    public static void main(String[] args) {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby:hibernateDB;create=true", new Properties());
            Statement st = conn.createStatement();
            st.executeUpdate("create table EMPLOYEE( id         INT         PRIMARY KEY NOT NULL, "
                    + "first_name VARCHAR(20) default NULL,"
                    + "last_name  VARCHAR(20) default NULL,"
                    + "salary     INT         default NULL)");
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }
}
