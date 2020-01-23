package com.example.linkedin.controllers;

import com.example.linkedin.Services.ExperienceService;
import com.example.linkedin.models.WebExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/experience")
public class ExperienceController {

    @Autowired
    ExperienceService experienceService;

    @GetMapping("/get/{id}")
    @ResponseBody
    public List<WebExperience> getExperience(@PathVariable(value = "id") Long id) {
        return experienceService.get(id);
    }

    @CrossOrigin(origins = "http://192.168.0.129:4200/")
    @PutMapping("/update")
    @ResponseBody
    public List<WebExperience> updateExperience(@RequestBody WebExperience webExperience) {
        return experienceService.modelToEntity(webExperience);

    }

    @CrossOrigin(origins = "http://192.168.0.129:4200/")
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteExperience(@PathVariable(value = "id") Long id) {

        return experienceService.delete(id);
    }
}
