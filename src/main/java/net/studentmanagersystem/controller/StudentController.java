package net.studentmanagersystem.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.studentmanagersystem.dto.StudentDto;
import net.studentmanagersystem.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<Page<StudentDto>> getStudents(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "20") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<StudentDto> res = studentService.getAllStudents(pageable);
        log.info("IN getStudents - return {} of students", res.getSize());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addStudent(
            @RequestBody StudentDto studentDto
    ) {
        studentService.add(studentDto);
        log.info("IN addStudent - student {} has been added", studentDto.getName());
        return ResponseEntity.ok().build();
    }
}
