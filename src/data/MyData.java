package data;

import dao.Student;
import db.SqlConnection;
import java.sql.*;
import java.util.Scanner;

public class MyData {

    public void showStudents() {
        Connection con;
        PreparedStatement p;
        ResultSet rs;

        String sql = "select * from student";
        con = SqlConnection.openConnection();
        try {
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            System.out.println("-------------------------------------------------------------------------");
            System.out.printf("ID\tFIRST_NAME\tLAST_NAME\tDATE_OF_BIRTH\tREGISTER_DATE\tGENDER\tGRADE%n");
            System.out.println("-------------------------------------------------------------------------");


            while (rs.next()) {

                int id = rs.getInt("ID");
                String firName = rs.getString("FIRST_NAME");
                String lasName = rs.getString("LAST_NAME");
                String dob = rs.getString("DATE_OF_BIRTH");
                Date regiDate = rs.getDate("REGISTER_DATE");
                String gender = rs.getString("GENDER");
                int grade =rs.getInt("GRADE");
                System.out.println(id + "\t" + firName +"\t"+ lasName+"\t"+dob+"\t"+regiDate+"\t"+gender+"\t"+grade);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addStudent(Student student){
        Connection con;
        con = SqlConnection.openConnection();
        try {

            Statement stmt = con.createStatement();

            String query = """
                        insert into student\s
                        (FIRST_NAME,LAST_NAME,DATE_OF_BIRTH,GENDER,GRADE)
                        values('%s','%s','%s','%s','%d')
                        """.formatted(student.getFirstName(),
                    student.getLastName(),
                    student.getDateOfBirth(),
                    student.getGender(),
                    student.getGrade());

                int result = stmt.executeUpdate(query);
            if (result > 0)
                System.out.println("successfully inserted");
            else
                System.out.println("unsuccessful insertion ");
            con.close();
        }
        catch (SQLException e) {
            System.out.println();
        }
    }
    public void showStudentBasedOnId() {
        Connection con;
        PreparedStatement p;
        ResultSet rs;

        System.out.println("Enter id:");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();

        String sql = "select * from student where ID ="+id;
        con = SqlConnection.openConnection();
        try {
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            System.out.println("""
            ------------------------------------------------------------------------------------
            |ID\t| FIRST_NAME\t| LAST_NAME\t| DATE_OF_BIRTH\t| REGISTER_DATE\t| GENDER\t| GRADE|
            ------------------------------------------------------------------------------------
            """
            );

            while (rs.next()) {

                id = rs.getInt("ID");
                String firName = rs.getString("FIRST_NAME");
                String lasName = rs.getString("LAST_NAME");
                String dob = rs.getString("DATE_OF_BIRTH");
                Date regiDate = rs.getDate("REGISTER_DATE");
                String gender = rs.getString("GENDER");
                int grade =rs.getInt("GRADE");
                System.out.println(id + "\t" + firName +"\t"+ lasName+"\t"+dob+"\t"+regiDate+"\t"+gender+"\t"+grade);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public  void updateStudent() throws SQLException {

        Connection con;
        con = SqlConnection.openConnection();
        Statement stmt = con.createStatement();
        String query;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id:");
        int id  = sc.nextInt();
        boolean run = true;

       do{ System.out.println("""
                1.First Name
                2.Last Name
                3.Date Of Birth
                4.Gender
                5.Grade
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
                    stmt.executeUpdate(query);
                   break;
               case 2:
                   System.out.println("Enter New Last Name:");
                   String newLasName = sc.next();
                    query = "UPDATE student set LAST_NAME =  \"%s\" where ID=%d".formatted(newLasName, id);
                    stmt.executeUpdate(query);
                   break;
               case 3:
                   System.out.println("Enter New Date Of Birth:");
                   String newDOB = sc.next();
                   query = "UPDATE student set DATE_OF_BIRTH =  \"%s\" where ID=%d".formatted(newDOB, id);
                   stmt.executeUpdate(query);
                   break;
               case 4:
                   System.out.println("Enter New Gender:");
                   String newGender = sc.next();
                   query = "UPDATE student set GENDER =  \"%s\" where ID=%d".formatted(newGender, id);
                   stmt.executeUpdate(query);
                   break;
               case 5:
                   System.out.println("Enter New Grade:");
                   String newGrade = sc.next();
                   query = "UPDATE student set GRADE =  \"%s\" where ID=%d".formatted(newGrade, id);
                   stmt.executeUpdate(query);
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
        Connection con;
        con = SqlConnection.openConnection();
        Statement stmt = con.createStatement();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id:");
        int id = sc.nextInt();
        String query = "DELETE FROM student WHERE ID = %d ".formatted(id);
        stmt.executeUpdate(query);
    }
}

