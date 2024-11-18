package com.example.gym.service;

import com.example.gym.model.Gym;
import com.example.gym.model.Trainer;
import com.example.gym.repository.GymRepository;
import com.example.gym.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {
    @Autowired
    TrainerRepository trainerRepository;



    public String addTrainer(Trainer trainer) {
        Trainer saveTrainer = trainerRepository.save(trainer);
        return "Trainer Saved Successfully";
    }

    public long countTrainersWithMoreThanFiveGyms() {
        List<Trainer> trainers = trainerRepository.findAll();
        int count = 0;

        for (Trainer trainer : trainers) {
            if (trainer.getGyms().size() > 5) {
                count++;
            }
        }

        return count;
    }
}
