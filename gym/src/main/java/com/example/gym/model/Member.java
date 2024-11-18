package com.example.gym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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

public class Member {

    @Id
    int memberId;

    @ManyToMany
    List<Trainer> trainers;

    @ManyToOne
    Gym gym;

}
