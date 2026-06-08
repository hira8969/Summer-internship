package org.example.dao;

import org.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addStudent(int id,
                           String name,
                           String course) {

        String sql =
                "insert into student values(?,?,?)";

        int result =
                jdbcTemplate.update(
                        sql,
                        id,
                        name,
                        course);

        if(result > 0)
            System.out.println(" Student Added Successfully");
    }

    public void viewStudents() {

        String sql =
                "select * from student";

        List<Map<String,Object>> students =
                jdbcTemplate.queryForList(sql);

        if(students.isEmpty()) {
            System.out.println("No Student Found");
            return;
        }

        System.out.println("\n------------------------------------------------");
        System.out.printf("%-10s %-20s %-20s%n",
                "ID","NAME","COURSE");
        System.out.println("------------------------------------------------");

        for(Map<String,Object> row : students) {

            System.out.printf("%-10s %-20s %-20s%n",
                    row.get("id"),
                    row.get("name"),
                    row.get("course"));
        }

        System.out.println("------------------------------------------------");
    }

    public void deleteStudent(int id) {

        String sql =
                "delete from student where id=?";

        int result =
                jdbcTemplate.update(sql,id);

        if(result > 0)
            System.out.println("🗑 Student Deleted Successfully");
        else
            System.out.println(" Student Not Found");
    }

    public void searchStudent(int id) {

        String sql =
                "select * from student where id=?";

        List<Map<String,Object>> students =
                jdbcTemplate.queryForList(sql,id);

        if(students.isEmpty()) {
            System.out.println(" Student Not Found");
            return;
        }

        Map<String,Object> row =
                students.get(0);

        System.out.println("\nStudent Details");
        System.out.println("------------------------");
        System.out.println("ID     : "+row.get("id"));
        System.out.println("NAME   : "+row.get("name"));
        System.out.println("COURSE : "+row.get("course"));
    }

    public void updateStudent(int id,
                              String name,
                              String course) {

        String sql =
                "update student set name=?,course=? where id=?";

        int result =
                jdbcTemplate.update(
                        sql,
                        name,
                        course,
                        id);

        if(result > 0)
            System.out.println(" Student Updated Successfully");
        else
            System.out.println(" Student Not Found");
    }
}