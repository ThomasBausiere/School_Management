package org.example.classroom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.classroom.dto.classroomDTO.ClassroomResponseDTO;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @OneToMany(mappedBy = "classroomId")
    private List<Student> students;

    public ClassroomResponseDTO entityToDTO(){
        return ClassroomResponseDTO.builder()
                .teacher(getTeacher())
                .students(getStudents())
                .build();
    }
}
