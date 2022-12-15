package net.studentmanagersystem.services;

import net.studentmanagersystem.entities.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudents();
}
