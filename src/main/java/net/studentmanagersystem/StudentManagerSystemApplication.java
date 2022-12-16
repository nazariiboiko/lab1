package net.studentmanagersystem;

import net.studentmanagersystem.entities.Student;
import net.studentmanagersystem.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class StudentManagerSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagerSystemApplication.class, args);
    }

    @Autowired
    private IStudentRepository studentRepository;


    @Override
    public void run(String... args) throws Exception {

//        Student student = new Student(1, "Nazarii", "Boiko", "nazarii.boiko2@gmail.com");
//        studentRepository.save(student);
//        student = new Student(2, "Bogdan", "Hnatiuk", "bohdan.hnatiuk@gmail.com");
//        studentRepository.save(student);
//        student = new Student(3, "Yura", "Noskovskiy", "yura.noskovskii@gmail.com");
//        studentRepository.save(student);

    }

}
