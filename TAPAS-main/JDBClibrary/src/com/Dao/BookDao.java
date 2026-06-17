package com.Dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Dao.DATABASE.DBconnection;

public class BookDao {
    public void addBook(Book book) {
        DBconnection dbConnection = new DBconnection();
        java.sql.Connection connection = dbConnection.getConnection();

        String sql = "INSERT INTO book (`ID`, `SL.NO`, `AUTHER`, `PRICE`) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, book.getId());
            statement.setString(2, book.getSLNO());
            statement.setString(3, book.getAuthor());
            statement.setDouble(4, book.getPrice());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteBook(int id) {
        DBconnection dbConnection = new DBconnection();
        java.sql.Connection connection = dbConnection.getConnection();
        String sql = "DELETE FROM book WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateBook(Book book) {
        DBconnection dbConnection = new DBconnection();
        java.sql.Connection connection = dbConnection.getConnection();
        String sql = "UPDATE book SET `SL.NO` = ?, `AUTHER` = ?, `PRICE` = ? WHERE `ID` = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, book.getSLNO());
            statement.setString(2, book.getAuthor());
            statement.setDouble(3, book.getPrice());
            statement.setInt(4, book.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Book getBookById(int id) {
        DBconnection dbConnection = new DBconnection();
        java.sql.Connection connection = dbConnection.getConnection();
        String sql = "SELECT * FROM book WHERE `ID` = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            java.sql.ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Book(
                        resultSet.getInt("ID"),
                        resultSet.getString("SL.NO"),
                        resultSet.getString("AUTHER"),
                        resultSet.getDouble("PRICE")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
