package org.training.studentRegister;

public class Main {
    private static final String fileName = "students.data";

    public static void main(String[] args) {
        StudentRegister studentRegisterSerialized = new StudentRegister();
        studentRegisterSerialized.addStudent(new Student("Andrei", "Ionescu", 9.57));
        studentRegisterSerialized.addStudent(new Student("Stefan", "Popescu", 8.66));
        studentRegisterSerialized.addStudent(new Student("John", "Doe", 7.80));
        studentRegisterSerialized.serializeToFile(fileName);

        StudentRegister studentRegisterDeserialized = new StudentRegister();
        studentRegisterDeserialized.deserializeFromFile(fileName);
        System.out.println(studentRegisterDeserialized);
    }
}