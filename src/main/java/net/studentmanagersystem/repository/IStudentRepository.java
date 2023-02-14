package net.studentmanagersystem.repository;

import net.studentmanagersystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
