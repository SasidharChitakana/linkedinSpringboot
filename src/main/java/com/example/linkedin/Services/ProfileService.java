package com.example.linkedin.Services;

import com.example.linkedin.entity.Profile;
import com.example.linkedin.models.WebProfile;
import com.example.linkedin.repository.ProfileRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("ProfileService")
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public WebProfile get(Long id) {
        Optional<Profile> profile = profileRepository.findByUserId(id);
        Profile newProfile = profile.orElse(null);
        if (newProfile != null) {
            WebProfile webProfile = new WebProfile();
            BeanUtils.copyProperties(newProfile, webProfile);
            return webProfile;
        }
        return new WebProfile();
    }

    public WebProfile entityToModel(Profile profileEntity) {
        Optional<Profile> profile = profileRepository.findByUserId(profileEntity.getUserId());
        Profile newProfile = profile.orElse(null);
        WebProfile webProfile = new WebProfile();
        webProfile.setAbout(newProfile.getAbout());
        webProfile.setDesignation(newProfile.getDesignation());
        webProfile.setAddress(newProfile.getAddress());
        webProfile.setUserId((newProfile.getUserId()));
        return webProfile;

    }

    public WebProfile modelToEntity(WebProfile webprofile) {
        Optional<Profile> profile = profileRepository.findByUserId(webprofile.getUserId());
        Profile newProfile = profile.orElse(null);
        newProfile.setAbout(webprofile.getAbout());
        newProfile.setDesignation(webprofile.getDesignation());
        newProfile.setAddress(webprofile.getAddress());
        profileRepository.save(newProfile);
        return entityToModel(newProfile);

    }

    public void delete(Long id) {
        Optional<Profile> profile = profileRepository.findByUserId(id);
        Profile newProfile = profile.orElse(null);
        profileRepository.delete(newProfile);
    }
}
