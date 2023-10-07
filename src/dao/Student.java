package dao;

import java.util.Scanner;

public class Student {
    int id;
    String firstName;
    String lastName;
    String dateOfBirth;
    String registerDate;
    String gender;
    int grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
