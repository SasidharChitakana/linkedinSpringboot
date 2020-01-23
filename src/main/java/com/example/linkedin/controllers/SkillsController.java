package com.example.linkedin.controllers;

import com.example.linkedin.Services.SkillsService;
import com.example.linkedin.models.WebSkills;
import com.example.linkedin.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/skills")
public class SkillsController {
    @Autowired
    SkillsRepository skillsRepository;
    @Autowired
    SkillsService skillsService;

    @GetMapping("/get/{id}")
    @ResponseBody
    public List<WebSkills> get(@PathVariable(value = "id") Long id) {
        return skillsService.get(id);
    }


    @CrossOrigin(origins = "http://192.168.0.129:4200/")
    @PutMapping("/update")
    @ResponseBody
    public List<WebSkills> updateSkills(@RequestBody WebSkills webSkills) {

        return skillsService.modelToEntity(webSkills);
    }

    @CrossOrigin(origins = "http://192.168.0.129:4200/")
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteSkills(@PathVariable(value = "id") Long id) {

        return skillsService.delete(id);
    }

}

