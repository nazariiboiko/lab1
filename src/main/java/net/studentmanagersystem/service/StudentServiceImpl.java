package net.studentmanagersystem.service;

import lombok.RequiredArgsConstructor;
import net.studentmanagersystem.dto.StudentDto;
import net.studentmanagersystem.mapper.StudentMapper;
import net.studentmanagersystem.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import net.studentmanagersystem.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper = StudentMapper.INSTANCE;

    @Override
    public Page<StudentDto> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable)
                .map(studentMapper::mapEntityToDto);
    }
}
