package com.example.linkedin.controllers;

import com.example.linkedin.Services.EducationService;
import com.example.linkedin.models.WebEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/education")
public class EducationController {
    @Autowired
    EducationService educationService;

    @GetMapping("/get/{id}")
    @ResponseBody
    public List<WebEducation> get(@PathVariable(value = "id") Long id) {
        return educationService.get(id);
    }

    @CrossOrigin(origins = "http://192.168.0.129:4200/")
    @PutMapping("/update")
    @ResponseBody
    public List<WebEducation> updateEducation(@RequestBody WebEducation webEducation) {
        return educationService.modelToEntity(webEducation);
    }

    @CrossOrigin(origins = "http://192.168.0.129:4200/")
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteEducation(@PathVariable(value = "id") Long id) {

        return educationService.delete(id);
    }


}
