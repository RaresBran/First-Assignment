package org.training.studentRegister;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRegister {
    private List<Student> students;

    public StudentRegister() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return "StudentRegister{" +
                "students=" + students +
                '}';
    }

    public void serializeToFile(String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(this.students);
            System.out.println("Objects serialized to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserializeFromFile(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            students = (List<Student>) inputStream.readObject();
            System.out.println("Objects deserialized from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
