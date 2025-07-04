package org.example.classroom.controller;

import lombok.RequiredArgsConstructor;
import org.example.classroom.dto.classroomDTO.ClassroomResponseDTO;
import org.example.classroom.entity.Classroom;
import org.example.classroom.service.ClassroomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classroom")
@RequiredArgsConstructor
public class ClassroomController {

    private final ClassroomService classroomService;

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomResponseDTO> getClassroom(@PathVariable int id) {
        ClassroomResponseDTO classroomResponse = classroomService.getClassroomById(id);
        return ResponseEntity.ok(classroomResponse);
    }

    @GetMapping
    public ResponseEntity<List<ClassroomResponseDTO>> getAllClassrooms() {
        List<ClassroomResponseDTO> classrooms = classroomService.getAllClassrooms();
        return ResponseEntity.ok(classrooms);
    }

    @PostMapping
    public ResponseEntity<Classroom> createClassroom(@RequestBody Classroom classroom) {
        Classroom created = classroomService.createClassroom(classroom);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classroom> updateClassroom(@PathVariable int id, @RequestBody Classroom classroom) {
        Classroom updated = classroomService.updateClassroom(id, classroom);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassroom(@PathVariable int id) {
        classroomService.deleteClassroom(id);
        return ResponseEntity.noContent().build();
    }
}
