package data;

import dao.Student;
import db.SqlConnection;

import java.sql.*;
import java.util.Scanner;

public class MyData {

    public void showStudents() {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;

        String sql = "select * from student";
        con = SqlConnection.openConnection();
        try {
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("ID");
                String name = rs.getString("FIRST_NAME");
                int grade =rs.getInt("GRADE");
                System.out.println(id + "\t" + name +"\t"+ grade);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //SqlConnection.closeConnection();
        }
    }
    public void addStudent(Student student){
        Connection con = null;
        con = SqlConnection.openConnection();
        try {

            Statement stmt = con.createStatement();

            String query = "insert into student (ID,FIRST_NAME,LAST_NAME,DATE_OF_BIRTH,GENDER,GRADE) values('"+student.getId()+"','"+student.getFirstName()+"','"+student.getLastName()+"','"+student.getDateOfBirth()+"','"+student.getGender()+"','"+student.getGrade()+"')";

                int result = stmt.executeUpdate(query);
            if (result > 0) {
                System.out.println("successfully inserted");
            }
            else
                System.out.println(
                        "unsucessful insertion ");

            con.close();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void showStudentBasedOnId() {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;

        System.out.println("Enter id:");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();

        String sql = "select * from student where ID ="+id;
        con = SqlConnection.openConnection();
        try {
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {

                String name = rs.getString("FIRST_NAME");
                int grade =rs.getInt("GRADE");
                System.out.println(id + "\t" + name +"\t"+ grade);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //SqlConnection.closeConnection();
        }
    }
    public  void updateStudent() {

    }
    public  void deleteStudent() {

    }
}

