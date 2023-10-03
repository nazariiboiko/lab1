package net.studentmanagersystem.service;

import net.studentmanagersystem.dto.StudentDto;
import net.studentmanagersystem.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    Page<StudentDto> getAllStudents(Pageable pageable);

    void add(StudentDto studentDto);
}
