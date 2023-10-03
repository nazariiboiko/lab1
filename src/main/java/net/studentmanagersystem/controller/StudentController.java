package net.studentmanagersystem.controller;

import lombok.RequiredArgsConstructor;
import net.studentmanagersystem.dto.StudentDto;
import net.studentmanagersystem.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<Page<StudentDto>> getStudents(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "20") int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        Page<StudentDto> res = studentService.getAllStudents(pageable);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
