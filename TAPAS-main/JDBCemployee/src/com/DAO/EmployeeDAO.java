package src.com.DAO;

import src.com.DATABASE.DBconnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {
    public void addEmployee(Employee employee) {
        DBconnection dbConnection = new DBconnection();
        java.sql.Connection connection = dbConnection.getConnection();

        String sql = "INSERT INTO employee (id, name, email, department) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getEmail());
            statement.setString(4, employee.getDepartment());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }}

    public void DeleteEmployee(int id){
        DBconnection dbConnection = new DBconnection();
        java.sql.Connection connection = dbConnection.getConnection();
        String sql = "DELETE FROM employee WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void UpdateEmployee(Employee employee){
        DBconnection dbConnection = new DBconnection();
        java.sql.Connection connection = dbConnection.getConnection();
        String sql = "UPDATE employee SET name = ?, email = ?, department = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getDepartment());
            statement.setInt(4, employee.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Employee getEmployeeById(int id){
        DBconnection dbConnection = new DBconnection();
        java.sql.Connection connection = dbConnection.getConnection();
        String sql = "SELECT * FROM employee WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            java.sql.ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("department")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}