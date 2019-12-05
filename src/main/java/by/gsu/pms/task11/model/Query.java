package by.gsu.pms.task11.model;

public class Query {
    public static final String FIND_ALL_TEACHERS_WITH_LECTURES_IN_DAY_AND_LOCATION =
            "SELECT *  from teacher INNER JOIN lecture on teacher.id_teacher = lecture.teacher_id WHERE lecture_day = ? AND location = ?;";
    public static final String FIND_ALL_TEACHERS_WITH_LECTURES_IN_NOT_DAY =
            "SELECT *  from teacher INNER JOIN lecture on teacher.id_teacher = lecture.teacher_id WHERE NOT lecture_day = ?;";
    public static final String NUMBER_OF_LECTURES_IN_DAY =
            "SELECT COUNT(lecture_day) FROM lecture WHERE lecture_day = ?;";
    public static final String TRANSFER_LECTURE =
            "UPDATE lecture SET lecture_day = 'Saturday' WHERE lecture_day = ?;";
}
