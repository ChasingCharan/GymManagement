package com.example.gym.repository;

import com.example.gym.model.Gym;
import com.example.gym.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Integer> {
}
