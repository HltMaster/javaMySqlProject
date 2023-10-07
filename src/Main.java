//TODO:
//how to save the date
// organization of code

import dao.Student;
import data.MyData;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
    public static Student newStudent(){
        Student student = new Student();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter id:");
        int stId = sc.nextInt();
        System.out.println("Enter First Name:");
        String firstName = sc.next();
        System.out.println("Enter Last Name:");
        String lastName = sc.next();
        System.out.println("Enter Date Of Birth:");
        String dateOfBirth = sc.next();
        System.out.println("Enter Gender:");
        String gender = sc.next();
        System.out.println("Enter Grade:");
        int grade = sc.nextInt();
        student.setId(stId);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setDateOfBirth(dateOfBirth);
        student.setGender(gender);
        student.setGrade(grade);

        return student;
    }
}




