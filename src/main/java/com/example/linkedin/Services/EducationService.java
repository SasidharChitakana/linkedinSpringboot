package com.example.linkedin.Services;

import com.example.linkedin.entity.Education;
import com.example.linkedin.models.ErrorResponse;
import com.example.linkedin.models.Response;
import com.example.linkedin.models.WebEducation;
import com.example.linkedin.repository.EducationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("EducationService")
public class EducationService {
    @Autowired
    EducationRepository educationRepository;


    public List<WebEducation> getList(List<Education> education) {
        ArrayList<WebEducation> educationList = new ArrayList<WebEducation>();
        for (Education firstEducation : education) {
            WebEducation webEducation = new WebEducation();
            BeanUtils.copyProperties(firstEducation, webEducation);
            educationList.add(webEducation);
        }
        return educationList;
    }

    public List<WebEducation> get(Long id) {
        List<Education> education = educationRepository.findByUserIdOrderByStartDate(id);
        return getList(education);
    }

    public List<WebEducation> entityToModel(Education educationEntity) {
        List<Education> education = educationRepository.findByUserIdOrderByStartDate(educationEntity.getUserId());
        return getList(education);
    }

    public Education setUp(Education newEducation, WebEducation webEducation) {
        newEducation.setOrganisation(webEducation.getOrganisation());
        newEducation.setStartDate(webEducation.getStartDate());
        newEducation.setEndDate(webEducation.getEndDate());
        newEducation.setDegree(webEducation.getDegree());
        newEducation.setFieldOfStudy(webEducation.getFieldOfStudy());
        newEducation.setUserId(webEducation.getUserId());
        educationRepository.save(newEducation);
        return newEducation;
    }

    public List<WebEducation> modelToEntity(WebEducation webEducation) {
        if (webEducation.getId() != null) {
            Optional<Education> education = educationRepository.findById(webEducation.getId());
            Education newEducation = education.orElse(null);
            if (newEducation != null) {
                if (newEducation.getUserId() == webEducation.getUserId()) {

                    return entityToModel(setUp(newEducation, webEducation));
                }
                return entityToModel(newEducation);
            }
            return get(webEducation.getUserId());
        }
        Education firstEducation = new Education();
        return entityToModel(setUp(firstEducation, webEducation));
    }

    public ResponseEntity<Object> delete(Long id) {
        Optional<Education> education = educationRepository.findById(id);
        Education newEducation = education.orElse(null);
        if (newEducation != null) {
            educationRepository.delete(newEducation);
            return new ResponseEntity<Object>(new Response("Education Deleted Successfully"), HttpStatus.OK);
        }
        return new ResponseEntity<Object>(new ErrorResponse("Education is not exist"), HttpStatus.BAD_REQUEST);
    }
}
