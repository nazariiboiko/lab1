package net.studentmanagersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String sex;
    private int course;
    private String nameGroup;
    private String numberGroup;
}
