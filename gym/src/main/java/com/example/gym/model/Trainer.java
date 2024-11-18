package com.example.gym.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity

public class Trainer {

    @Id
    int trainerId;

    @ManyToMany(mappedBy = "trainers")
    List<Member> members;

    @ManyToMany(mappedBy = "trainers")
    List<Gym> gyms;

}
