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

            String query = """
                        insert into student 
                        (ID,FIRST_NAME,LAST_NAME,DATE_OF_BIRTH,GENDER,GRADE)
                        values('%d','%s','%s','%s','%s','%d')
                        """.formatted(student.getId(),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getDateOfBirth(),
                    student.getGender(),
                    student.getGrade());

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
    public  void updateStudent() throws SQLException {

        Connection con = null;
        con = SqlConnection.openConnection();
        Statement stmt = con.createStatement();
        String query = new String();
        int result;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id:");
        int id  = sc.nextInt();
        boolean run = true;

       do{ System.out.println("""
                1.First Name
                2.Last Name
                3.Date Of Birth
                4.Gender
                5.
                6.Quit
                ----------------
                ENTER A FIELD TO CHANGE.
                """);

           int option = sc.nextInt();
           switch (option){
               case 1:
                   System.out.println("Enter New First Name:");
                   String newFirName = sc.next();
                    query = "UPDATE student set FIRST_NAME =  \"%s\" where ID=%d".formatted(newFirName, id);
                    result = stmt.executeUpdate(query);
                   break;
               case 2:
                   System.out.println("Enter New Last Name:");
                   String newLasName = sc.next();
                    query = "UPDATE student set LAST_NAME =  \"%s\" where ID=%d".formatted(newLasName, id);
                    result = stmt.executeUpdate(query);
                   break;
               case 3:
                   System.out.println("Enter New Date Of Birth:");
                   String newDOB = sc.next();
                   query = "UPDATE student set DATE_OF_BIRTH =  \"%s\" where ID=%d".formatted(newDOB, id);
                   result = stmt.executeUpdate(query);
                   break;
               case 4:
                   System.out.println("Enter New Gender:");
                   String newGender = sc.next();
                   query = "UPDATE student set GENDER =  \"%s\" where ID=%d".formatted(newGender, id);
                   result = stmt.executeUpdate(query);
                   break;
               case 5:
                   System.out.println("Enter New Grade:");
                   String newGrade = sc.next();
                   query = "UPDATE student set GRADE =  \"%s\" where ID=%d".formatted(newGrade, id);
                   result = stmt.executeUpdate(query);
                   break;
               case 6:
                   run = false;
                   break;
               default:
                   System.out.println("Enter valid field...");
           }

        }while (run);
    }
    public  void deleteStudent() throws SQLException {
        Connection con = null;
        con = SqlConnection.openConnection();
        Statement stmt = con.createStatement();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id:");
        int id  = sc.nextInt();

        String query = "DELETE FROM student WHERE ID = %d ".formatted( id);
        int result = stmt.executeUpdate(query);



    }
}

