package com.example.gym.controller;


import com.example.gym.model.Trainer;
import com.example.gym.service.TrainerService;
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
@RequestMapping("/api/v1/trainer")
public class TrainerController {

    @Autowired
    TrainerService trainerService;

    @PostMapping
    public ResponseEntity<String> addTrainer(@RequestBody Trainer trainer){
        String response = trainerService.addTrainer(trainer);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/trainersWithMoreThanFiveGyms")
    public long getTrainersWithMoreThanFiveGyms() {
        return trainerService.countTrainersWithMoreThanFiveGyms();
    }

}
