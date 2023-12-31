package net.studentmanagersystem.service;

import lombok.RequiredArgsConstructor;
import net.studentmanagersystem.dto.StudentDto;
import net.studentmanagersystem.mapper.StudentMapper;
import net.studentmanagersystem.model.Student;
import net.studentmanagersystem.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    @Override
    public void add(StudentDto studentDto) {
        Student studentEntity = studentMapper.mapDtoToEntity(studentDto);
        System.out.println(studentEntity);
        studentRepository.save(studentEntity);
    }
}
