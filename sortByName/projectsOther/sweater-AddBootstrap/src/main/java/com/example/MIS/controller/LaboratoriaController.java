package com.example.MIS.controller;


import com.example.MIS.domain.Doctor;
import com.example.MIS.domain.Laboratoria;
import com.example.MIS.domain.User;
import com.example.MIS.repos.DoctorRepo;
import com.example.MIS.repos.LabRepo;
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
public class LaboratoriaController {
    @Autowired
    private RegistrationRepo registrationRepo;
    @Autowired
    private DoctorRepo doctorRepo;
    @Autowired
    private LabRepo labRepo;
    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/lab")
    public String main(@RequestParam(required = false, defaultValue = "") String filterLab, Model model) {

        //  if (filterDoc != null && !filterDoc.isEmpty()) {
        Iterable<Doctor> doctors1 = doctorRepo.findByIin(filterLab);
        model.addAttribute("doctors1", doctors1);
        //  } else {
        Iterable<Laboratoria> laboratorias = labRepo.findAll();
        model.addAttribute("laboratorias", laboratorias);
        //  }


        return "lab";
    }

    @PostMapping("/lab")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String nomer,
            @RequestParam String result,
            @RequestParam String iin,
            @RequestParam String kod,
            Map<String, Object> model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Laboratoria laboratoria = new Laboratoria(nomer, result,iin,kod, user);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            laboratoria.setFilename(resultFilename);
        }

        labRepo.save(laboratoria);

        Iterable<Laboratoria> laboratorias = labRepo.findAll();

        model.put("laboratorias", laboratorias);

        return "lab";
    }
}
