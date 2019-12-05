package by.gsu.pms.task11.repo;

import by.gsu.pms.task11.model.Database;
import by.gsu.pms.task11.model.Query;
import by.gsu.pms.task11.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class ScheduleRepo {

    @Autowired
    private Database database;

    public List<Teacher> findAllTeachersByLectureInDayAndLocation(String day, String location) {
        List<Teacher> teachers = new ArrayList<>();
        try {
            PreparedStatement ps = database.getConnection().prepareStatement(Query.FIND_ALL_TEACHERS_WITH_LECTURES_IN_DAY_AND_LOCATION);
            ps.setString(1, day);
            ps.setString(2, location);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Teacher teacher = Teacher.builder()
                        .id(resultSet.getInt(1))
                        .fullName(resultSet.getString(2))
                        .lecturesPerWeek(resultSet.getInt(3))
                        .studentsOnLectures(resultSet.getInt(4))
                        .build();
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    public List<Teacher> findAllTeachersByLectureNotInDay(String day) {
        List<Teacher> teachers = new ArrayList<>();
        try {
            PreparedStatement ps = database.getConnection().prepareStatement(Query.FIND_ALL_TEACHERS_WITH_LECTURES_IN_NOT_DAY);
            ps.setString(1, day);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Teacher teacher = Teacher.builder()
                        .id(resultSet.getInt(1))
                        .fullName(resultSet.getString(2))
                        .lecturesPerWeek(resultSet.getInt(3))
                        .studentsOnLectures(resultSet.getInt(4))
                        .build();
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    public List<String> findAllDaysWithSelectedNumberOfLectures(int number){
        Set<String> days = new HashSet<>(Arrays.asList("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"));
        List<String> result = new ArrayList<>();
        for (String day : days){
            try {
                PreparedStatement ps = database.getConnection().prepareStatement(Query.NUMBER_OF_LECTURES_IN_DAY);
                ps.setString(1, day);
                ResultSet resultSet = ps.executeQuery();
                if (resultSet.next()){
                    if (resultSet.getInt(1) == number) result.add(day);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void transferLecturesToDay(String day){
        try {
            PreparedStatement ps = database.getConnection().prepareStatement(Query.TRANSFER_LECTURE);
            ps.setString(1, day);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
