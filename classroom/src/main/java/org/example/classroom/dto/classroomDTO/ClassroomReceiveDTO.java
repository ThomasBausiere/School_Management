package org.example.classroom.dto.classroomDTO;

import lombok.Data;
import java.util.List;

@Data
public class ClassroomReceiveDTO {
    private Integer teacherId;
    private List<Integer> studentIds;
}

