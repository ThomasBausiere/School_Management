package org.example.classroom.service;

import lombok.RequiredArgsConstructor;
import org.example.classroom.dto.classroomDTO.ClassroomResponseDTO;
import org.example.classroom.dto.;
import org.example.classroom.entity.Classroom;
import org.example.classroom.entity.Student;
import org.example.classroom.entity.Teacher;
import org.example.classroom.repository.ClassroomRepository;
import org.example.classroom.util.RestClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassroomService {

    private final ClassroomRepository classroomRepository;
    private final RestTemplate restTemplate;

    private final String teacherServiceUrl = "http://localhost:8081/teachers";
    private final String studentServiceUrl = "http://localhost:8082/students";

    public ClassroomResponseDTO getClassroomById(int id) {
        Classroom classroom = classroomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Classroom not found"));

        Teacher teacher = new RestClient<>(
                teacherServiceUrl + "/" + classroom.getTeacherId(),
                restTemplate
        ).get(Teacher.class);

        List<Student> students = classroom.getStudentIds().stream()
                .map(studentId -> new RestClient<>(
                        studentServiceUrl + "/" + studentId,
                        restTemplate
                ).get(Student.class))
                .collect(Collectors.toList());

        return ClassroomResponseDTO.builder()
                .id(classroom.getId())
                .teacher(teacher)
                .students(students)
                .build();
    }

    public List<ClassroomResponseDTO> getAllClassrooms() {
        List<Classroom> classrooms = classroomRepository.findAll();

        return classrooms.stream()
                .map(classroom -> {
                    Teacher teacher = new RestClient<>(
                            teacherServiceUrl + "/" + classroom.getTeacherId(),
                            restTemplate
                    ).get(Teacher.class);

                    List<Student> students = classroom.getStudentIds().stream()
                            .map(studentId -> new RestClient<>(
                                    studentServiceUrl + "/" + studentId,
                                    restTemplate
                            ).get(Student.class))
                            .collect(Collectors.toList());

                    return ClassroomResponseDTO.builder()
                            .id(classroom.getId())
                            .teacher(teacher)
                            .students(students)
                            .build();
                })
                .collect(Collectors.toList());
    }

    public Classroom createClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public Classroom updateClassroom(int id, Classroom classroomDetails) {
        Classroom classroom = classroomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Classroom not found"));

        classroom.setTeacherId(classroomDetails.getTeacherId());
        classroom.setStudentIds(classroomDetails.getStudentIds());

        return classroomRepository.save(classroom);
    }

    public void deleteClassroom(int id) {
        Classroom classroom = classroomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Classroom not found"));
        classroomRepository.delete(classroom);
    }
}
