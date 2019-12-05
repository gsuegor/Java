package by.gsu.pms.task11.controller;

import by.gsu.pms.task11.repo.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResolverController {
    @Autowired
    private ScheduleRepo scheduleRepo;

    @GetMapping("/resolve/teacherByDayAndLocation")
    public String resolverByDayAndLocation(@RequestParam(name = "day") String day,
                           @RequestParam(name = "location") String location,
                           Model model
    ){
        model.addAttribute("teachers", scheduleRepo.findAllTeachersByLectureInDayAndLocation(day, location));
        return "teachers";
    }

    @GetMapping("/resolve/teacherByNotDay")
    public String resolverByDay(@RequestParam(name = "day") String day, Model model
    ){
        model.addAttribute("teachers", scheduleRepo.findAllTeachersByLectureNotInDay(day));
        return "teachers";
    }

    @GetMapping("/resolve/daysByNumberOfLectures")
    public String resolverByLectures(@RequestParam(name = "number") String number, Model model
    ){
        model.addAttribute("days", scheduleRepo.findAllDaysWithSelectedNumberOfLectures(Integer.parseInt(number)));
        return "days";
    }

    @GetMapping("/resolve/daysByNumberOfLocationsReserved")
    public String resolverByLocations(@RequestParam(name = "number") String number, Model model
    ){
        model.addAttribute("days", scheduleRepo.findAllDaysWithSelectedNumberOfLectures(Integer.parseInt(number)));
        return "days";
    }

    @GetMapping("/resolve/transferLectures")
    public String resolverForTransfer(@RequestParam(name = "day") String day, Model model
    ){
        scheduleRepo.transferLecturesToDay(day);
        return "main";
    }
}
