package com.example.linkedin.Services;

import com.example.linkedin.entity.Profile;
import com.example.linkedin.entity.UserAccount;
import com.example.linkedin.models.ErrorResponse;
import com.example.linkedin.models.Login;
import com.example.linkedin.models.Response;
import com.example.linkedin.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("UserAccountService")
public class UserAccountService {


    @Autowired
    UserAccountRepository userAccountRepository;
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    EducationRepository educationRepository;
    @Autowired
    ExperienceRepository experienceRepository;
    @Autowired
    SkillsRepository skillsRepository;

    public ResponseEntity<Object> login(Login login) {
        UserAccount userAccount = userAccountRepository.findByEmail(login.getEmail());
        if (userAccount != null) {
            if (userAccount.getPassword().equals(login.getPassword())) {
                String name = userAccount.getFirstName() + " " + userAccount.getLastName();
                return new ResponseEntity<>(new Response(userAccount.getId(), "200", name), HttpStatus.OK);
            } else {

                return new ResponseEntity<Object>(new ErrorResponse("100"), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<Object>(new ErrorResponse("100"), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> register(UserAccount userAccount) {
        UserAccount userAccount1 = userAccountRepository.findByEmail(userAccount.getEmail());
        if (userAccount1 != null) {
            return new ResponseEntity<Object>(new Response("Email is Already Registered"), HttpStatus.BAD_REQUEST);
        }
        userAccountRepository.save(userAccount);
        Profile profile = new Profile(userAccount.getId());
        profileRepository.save(profile);
        return new ResponseEntity<Object>(new Response("Registration Successful"), HttpStatus.OK);

    }


}
