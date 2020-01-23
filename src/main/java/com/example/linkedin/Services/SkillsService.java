package com.example.linkedin.Services;

import com.example.linkedin.entity.Skills;
import com.example.linkedin.models.Response;
import com.example.linkedin.models.WebSkills;
import com.example.linkedin.repository.SkillsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("SkillsService")
public class SkillsService {
    @Autowired
    SkillsRepository skillsRepository;

    public List<WebSkills> getList(List<Skills> skills) {
        ArrayList<WebSkills> skillList = new ArrayList<WebSkills>();
        for (Skills firstSkills : skills) {
            WebSkills webSkills = new WebSkills();
            BeanUtils.copyProperties(firstSkills, webSkills);
            skillList.add(webSkills);
        }
        return skillList;
    }

    public List<WebSkills> get(Long id) {
        List<Skills> skills = skillsRepository.findByUserId(id);
        return getList(skills);
    }

    public List<WebSkills> entityToModel(Skills skillEntity) {
        List<Skills> skills = skillsRepository.findByUserId(skillEntity.getUserId());
        return getList(skills);
    }

    public Skills setUp(Skills newSkills, WebSkills webSkills) {
        newSkills.setSkillName(webSkills.getSkillName());
        newSkills.setUserId(webSkills.getUserId());
        skillsRepository.save(newSkills);
        return newSkills;
    }

    public List<WebSkills> modelToEntity(WebSkills webSkills) {
        if (webSkills.getId() != null) {
            Optional<Skills> skills = skillsRepository.findById(webSkills.getId());
            Skills newSkill = skills.orElse(null);
            if (newSkill != null) {
                if (newSkill.getUserId() == webSkills.getUserId()) {

                    return entityToModel(setUp(newSkill, webSkills));
                }
                return entityToModel(newSkill);
            }
            return get(webSkills.getUserId());
        }
        Skills firstSkill = new Skills();
        return entityToModel(setUp(firstSkill, webSkills));
    }


    public ResponseEntity<Object> delete(Long id) {
        Optional<Skills> newSkill = skillsRepository.findById(id);
        Skills skills = newSkill.orElse(null);
        if (skills != null) {
            skillsRepository.delete(skills);
            return new ResponseEntity<Object>(new Response(id, "Skills Deleted Successful"), HttpStatus.OK);
        }
        return new ResponseEntity<Object>(new Response("Skills are  not exist  for particular user"), HttpStatus.OK);
    }
}
