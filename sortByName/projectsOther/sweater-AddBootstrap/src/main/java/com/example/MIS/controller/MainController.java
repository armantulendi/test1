package com.example.MIS.controller;


import com.example.MIS.domain.Registration;
import com.example.MIS.domain.User;
import com.example.MIS.repos.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {
    @Autowired
    private RegistrationRepo registrationRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Registration> registrations = registrationRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            registrations = registrationRepo.findByIin(filter);
        } else {
            registrations = registrationRepo.findAll();
        }

        model.addAttribute("registrations", registrations);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String patientName,
            @RequestParam String mestoPrik,
            @RequestParam String iin,
            @RequestParam String address,
            Map<String, Object> model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Registration registration = new Registration(patientName, mestoPrik,iin,address, user);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            registration.setFilename(resultFilename);
        }

        registrationRepo.save(registration);

        Iterable<Registration> registrations = registrationRepo.findAll();

        model.put("registrations", registrations);

        return "main";
    }
}
