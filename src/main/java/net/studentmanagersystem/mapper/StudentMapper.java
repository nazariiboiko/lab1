package net.studentmanagersystem.mapper;

import net.studentmanagersystem.dto.StudentDto;
import net.studentmanagersystem.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student mapDtoToEntity(StudentDto dto);

    StudentDto mapEntityToDto(Student entity);
}
