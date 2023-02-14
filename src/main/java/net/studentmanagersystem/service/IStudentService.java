package net.studentmanagersystem.service;

import net.studentmanagersystem.model.Student;

import java.util.List;

public interface IStudentService {
     List<Student> getAllStudents();
     Student saveStudent(Student student);
     Student updateStudent(Student student);
     Student getStudentById(Integer id);
     void deleteStudent(Student student);
}
