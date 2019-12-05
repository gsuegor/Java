package by.gsu.pms.lr12.controller;

import by.gsu.pms.lr12.repo.CertificateRepo;
import by.gsu.pms.lr12.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CertificateRepo certificateRepo;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("users", userRepo.findAll());
        return "main";
    }

    @GetMapping("/profile")
    public String profile(Model model, @RequestParam(name = "userId") String userId){
        model.addAttribute("user", userRepo.findByUserId(Long.parseLong(userId)));
        model.addAttribute("certificates", certificateRepo.findAllByUserId(Long.parseLong(userId)));
        return "profile";
    }

}
