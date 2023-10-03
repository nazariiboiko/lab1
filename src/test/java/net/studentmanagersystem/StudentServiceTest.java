package net.studentmanagersystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.studentmanagersystem.controller.StudentController;
import net.studentmanagersystem.dto.StudentDto;
import net.studentmanagersystem.mapper.StudentMapper;
import net.studentmanagersystem.model.Student;
import net.studentmanagersystem.repository.StudentRepository;
import net.studentmanagersystem.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(StudentController.class)
public class StudentServiceTest {

    private String STUDENT_URL = "http://localhost:8081/students";

    private StudentMapper studentMapper = StudentMapper.INSTANCE;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testGetAllStudents() throws Exception {
        List<Student> students = new ArrayList<>(){{
            add(new Student(1, "John", "Doe", "john@example.com", "1234567890", "Male", 4, "GroupA", "123"));
            add(new Student(2, "Jane", "Smith", "jane@example.com", "9876543210", "Female", 4, "GroupB", "456"));
        }};

        Pageable pageable = PageRequest.of(0, 2);
        Page<Student> studentPage = new PageImpl<>(students);
        when(studentService.getAllStudents(any())).thenReturn(studentPage.map(studentMapper::mapEntityToDto));

        mockMvc.perform(get(STUDENT_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .param("page", "0")
                    .param("size", "10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content.length()").value(2))
                .andExpect(jsonPath("$.number").value(0))
                .andExpect(jsonPath("$.size").value(2));
    }

    @Test
    public void testAddStudent() throws Exception {
        StudentDto studentDto = new StudentDto();
        studentDto.setName("John");
        studentDto.setSurname("Doe");

        mockMvc.perform(post(STUDENT_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(studentDto)))
                .andExpect(status().isOk());
    }
}
