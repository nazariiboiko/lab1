package net.studentmanagersystem.services;

import net.studentmanagersystem.entities.Student;
import org.springframework.stereotype.Service;
import net.studentmanagersystem.repository.IStudentRepository;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    private IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
