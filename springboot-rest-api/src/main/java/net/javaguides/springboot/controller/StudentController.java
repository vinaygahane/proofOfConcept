package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    //Spring boot API that returns java bean as JSON to client
    //http://localhost:8080/student
    @GetMapping("/student")
    public Student getStudent()
    {
        Student student = new Student(1,"Vinaykumar","Gahane");
        return student; //returns JSON <key,value> pair
    }

    //Spring boot API that returns java beans list as JSON to client
    //http://localhost:8080/students
    @GetMapping("/students")
    public List<Student> getStudents()
    {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1,"Vinaykumar","Gahane"));
        students.add(new Student(2,"Vishal","Khedekar"));
        students.add(new Student(3,"Kunal","Dhanushykar"));
        return students; //returns list in JSON format
    }

    //Spring boot Rest API to handle path Variable
    //{id}-URI template variable
    //http://localhost:8080/students/1/Vinaykumar/Gahane
    //@PathVariable ->To bind it to value of a URI  template variable
    @GetMapping("/students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){// pass id as "id" and "studentID" are same//No need to pass if we use id instead of studentID
        return new Student(studentId,firstName,lastName);
    }

    //Spring boot Rest API with Request param//It is used to extract values from URl
    //http://localhost:8080/students/query?id=1&firstName=Vinaykumar&lastName=Gahane //Query paramater

    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(id,firstName,lastName);
    }

    //Spring Boot REST API that handles HTTP POST request
    //@PostMapping->Used for mapping HTTP POST request onto specific handler method
   // @RequestBody->Responsible for retrieving the HTTP request body and automatically converting it to java object from JSON
    @PostMapping("students/create")
    public  Student createStudent(Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
}
