package org.example.teacher.service;

import org.example.teacher.exception.NotFoundException;
import org.example.teacher.entity.Teacher;
import org.example.teacher.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher findById(int id) {
        return teacherRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher update(int id, Teacher teacher) {
        if (!teacherRepository.existsById(id)) {
            throw new NotFoundException();
        }
        teacher.setId(id);
        return teacherRepository.save(teacher);
    }

    public void deleteById(int id) {
        if (!teacherRepository.existsById(id)) {
            throw new NotFoundException();
        }
        teacherRepository.deleteById(id);
    }

}
