package dao;

import java.util.Scanner;
//import java.time.*;

public class Student {
    String firstName;
    String lastName;
    String dateOfBirth;
    String gender;
    int grade;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        boolean run = true;
        do {
            if (gender.equals("male")|| gender.equals("female")){
                this.gender = gender;
                run = false;
            }
            else{
                System.out.println("You can only use 'male' or 'female' \n.TRY AGAIN!!");
            Scanner sc = new Scanner(System.in);
            gender = sc.next();
            }
        }while (run);

    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    public static Student newStudent(){
        Student student = new Student();
        Scanner sc = new Scanner(System.in);

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
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setDateOfBirth(dateOfBirth);
        student.setGender(gender);
        student.setGrade(grade);

        return student;
    }
}
