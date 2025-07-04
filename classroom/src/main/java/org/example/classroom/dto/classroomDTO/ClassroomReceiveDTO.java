package org.example.classroom.dto.classroomDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.classroom.entity.Classroom;
import org.example.classroom.entity.Student;
import org.example.classroom.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomReceiveDTO {
    private int teacherId;
    private List<Integer> studentsIds;

    public Classroom dtoToEntity(){
        Teacher teacher = Teacher.builder().id(teacherId).build();
        List<Student> students = new ArrayList<>();
        for (Integer id : studentsIds) {
            students.add(Student.builder().id(id).build());
        }

        return Classroom.builder()
                .teacher(teacher)
                .students(students)
                .build();
    }
}
