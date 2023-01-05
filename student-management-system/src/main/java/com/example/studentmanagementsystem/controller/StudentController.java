package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    private StudentService studentService;//No need to use Autowired as bean has one constructor

    //constructor based dependency Injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/students")
    //Handler methods to handle list students and return mode and view
    public String listStudents(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "students";//returns view
    }

    @GetMapping("students/new")
    public String createStudentForm(Model model){

        //create student object to hold student form data
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }

    //handler method to handle form request(submit)
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){//directly bind form data to object( )
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id ,Model model){//bind id to some java variable
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
  }

  //handler method to handle "edit_students" request
   @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id ,
                                @ModelAttribute("student") Student student,
                                 Model model){
        //get student from database by ID
       Student existingStudent = studentService.getStudentById(id);
       existingStudent.setId(id);
       existingStudent.setFirstName(student.getFirstName());
       existingStudent.setLastName(student.getLastName());
       existingStudent.setEmail(student.getEmail());

       //save updated student object
       studentService.updateStudent(existingStudent);
       return "redirect:/students";
   }

   //handler method to handle delete request
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
