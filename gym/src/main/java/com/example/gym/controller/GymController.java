package com.example.gym.controller;


import com.example.gym.model.Gym;
import com.example.gym.service.GymService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@RestController
@RequestMapping("/api/v1/gym")
public class GymController {

    @Autowired
    GymService gymService;

    @PostMapping
    public ResponseEntity<String> addGym(@RequestBody Gym gym){
        String response = gymService.addGym(gym);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/gymWithMostMembers")
    public Gym getGymWithMostMembers() {
        return gymService.findGymWithMostMembers();
    }

}
