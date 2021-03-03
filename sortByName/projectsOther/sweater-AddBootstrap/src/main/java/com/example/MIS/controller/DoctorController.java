package com.example.MIS.controller;


import com.example.MIS.domain.Doctor;
import com.example.MIS.domain.Registration;
import com.example.MIS.domain.User;
import com.example.MIS.repos.DoctorRepo;
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
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class DoctorController {
    @Autowired
    private RegistrationRepo registrationRepo;
@Autowired
private DoctorRepo doctorRepo;
    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/doctor")
    public String main(@RequestParam(required = false, defaultValue = "") String filterDoc, Model model) {

       // if (filterDoc != null && !filterDoc.isEmpty()) {
            List<Registration>  registrations = registrationRepo.findByIin(filterDoc);
            model.addAttribute("registrations", registrations);
      //  } else {
            Iterable<Doctor> doctors = doctorRepo.findAll();
            model.addAttribute("doctors", doctors);
      // }


        return "doctor";
    }

    @PostMapping("/doctor")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String analys,
            @RequestParam String diagnos,
            @RequestParam String iin,
            @RequestParam String kod,
            Map<String, Object> model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Doctor doctor = new Doctor(iin,analys, diagnos,kod, user);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            doctor.setFilename(resultFilename);
        }

        doctorRepo.save(doctor);

        Iterable<Doctor> doctors = doctorRepo.findAll();

        model.put("doctors", doctors);

        return "doctor";
    }
}
