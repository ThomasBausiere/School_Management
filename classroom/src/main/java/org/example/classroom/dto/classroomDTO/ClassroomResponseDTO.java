package org.example.classroom.dto.classroomDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.classroom.entity.Student;
import org.example.classroom.entity.Teacher;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassroomResponseDTO {
    private Teacher teacher;
    private List<Student> students;
}
