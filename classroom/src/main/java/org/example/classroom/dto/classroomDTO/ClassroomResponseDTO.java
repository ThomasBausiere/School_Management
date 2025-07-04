package org.example.classroom.dto.classroomDTO;

import lombok.Builder;
import lombok.Data;
import org.example.classroom.entity.Student;
import org.example.classroom.entity.Teacher;

import java.util.List;

@Data
@Builder
public class ClassroomResponseDTO {
    private Integer id;
    private Teacher teacher;
    private List<Student> students;
}

