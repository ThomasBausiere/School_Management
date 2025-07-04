package org.example.student.controller;

import jakarta.ws.rs.DELETE;
import org.example.student.entity.Student;
import org.example.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //CREATE

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.create(student));
    }


    //READ 1
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.getStudentById(id);
    }
    //READ ALL
    @GetMapping
    public ResponseEntity<List<Student>> getAll(){
        return ResponseEntity.ok(studentService.getAll());
    }
    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable int id, @RequestBody Student student){
        return ResponseEntity.ok(studentService.update(id, student));
    }

    //DELETE

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }
}
