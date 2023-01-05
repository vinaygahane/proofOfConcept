package com.example.studentmanagementsystem;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override//method provided by interface which runs when we execute springboot app
	public void run(String... args) throws Exception {

//		Student s1 = new Student("Vinaykumar" , "Gahane" , "vg@gmail.com");
//		studentRepository.save(s1);
//
//		Student s2 = new Student("Sanket" , "Bhandekar" , "sb@gmail.com");
//		studentRepository.save(s2);
//
//		Student s3 = new Student("Mangesh" , "Ladke" , "ml@gmail.com");
//		studentRepository.save(s3);
//
//		Student s4 = new Student("Vishal" , "Khedekar" , "vk@gmail.com");
//		studentRepository.save(s4);

	}
}
