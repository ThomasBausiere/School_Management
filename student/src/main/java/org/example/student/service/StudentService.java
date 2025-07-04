package org.example.student.service;

import org.example.student.entity.Student;
import org.example.student.exception.NotFoundException;
import org.example.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //CREATE
    public Student create (Student student){
        return studentRepository.save(student);
    }

    //READ1
    public Student getStudentById(Integer id){
        return studentRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    //READ-ALL

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    //UPDATE
    public Student update(int id, Student student) {
        if (!studentRepository.existsById(id)) {
            throw new NotFoundException();
        }
        student.setId(id);
        return studentRepository.save(student);
    }

    //DELETE
    public void deleteStudent(Integer id){
        studentRepository.deleteById(id);
    }
}
