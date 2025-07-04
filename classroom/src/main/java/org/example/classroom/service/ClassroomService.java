package org.example.classroom.service;

import org.example.classroom.dto.classroomDTO.ClassroomReceiveDTO;
import org.example.classroom.dto.classroomDTO.ClassroomResponseDTO;
import org.example.classroom.repository.ClassroomRepository;

public class ClassroomService {
    private final ClassroomRepository classroomRepository;

    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public ClassroomResponseDTO saveClassroom(ClassroomReceiveDTO classroomReceiveDTO){

    }
}
