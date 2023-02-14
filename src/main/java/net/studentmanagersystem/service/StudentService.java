package net.studentmanagersystem.service;

import net.studentmanagersystem.model.Student;
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

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findById(Math.toIntExact(id)).get();
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }
}
