//TODO:
//how to save the date
// organization of code

import data.MyData;

import java.sql.SQLException;
import java.util.Scanner;

import static dao.Student.newStudent;

public class Main {
    public static void main(String[] args) throws SQLException {
        MyData myData = new MyData();

        System.out.println(
                """
                       ---------------
                       |   WELCOME   |
                       ---------------"""
        );

        Scanner sc = new Scanner(System.in);
        do{
            System.out.println(
                    """
                            1. Add Student
                            2. Show All Student
                            3. Show Student Based On Id
                            4. Update the Student
                            5. Delete the Student
                            6. EXIT"""
            );

            System.out.println("Enter your Option");

            int option = sc.nextInt();
            switch (option){
                case 1:
                    myData.addStudent(newStudent());
                    break;
                case 2:
                    myData.showStudents();
                    break;
                case 3:
                    myData.showStudentBasedOnId();
                    break;
                case 4:
                    myData.updateStudent();
                    break;
                case 5:
                    myData.deleteStudent();
                    break;
                case 6:
                    System.out.println("THANK YOU FOR USING OUR SYSTEM !!!.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter valid Option");
                    break;
            }
        }while (true);
    }
}




