package by.gsu.pms.task11.model;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
public class Teacher {
    private int id;
    private String fullName;
    private int lecturesPerWeek;
    private int studentsOnLectures;

}
