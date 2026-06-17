package com.Dao.DATABASE;

public class TestDB {
    public static void main(String[] args) {
        DBconnection db = new DBconnection();
    try{
            db.getConnection();
            System.out.println("Connection successful!");
        } catch (Exception e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }
}

