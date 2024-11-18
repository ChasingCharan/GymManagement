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

public class Gym {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int gymId;
    String location;

    @OneToMany(mappedBy = "gym", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Member> members;

    @ManyToMany
    @JsonIgnore
    List<Trainer> trainers;

}
