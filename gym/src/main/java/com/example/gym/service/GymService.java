package com.example.gym.service;

import com.example.gym.model.Gym;
import com.example.gym.repository.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService {
    @Autowired
    GymRepository gymRepository;

    public String addGym(Gym gym) {
        Gym saveGym = gymRepository.save(gym);
        return "Gym Saved Successfully";
    }

    public Gym findGymWithMostMembers() {
        List<Gym> gyms = gymRepository.findAll();
        Gym mostMembers = null;
        int ct =0;
        for(Gym gym : gyms){
            int mct = gym.getMembers().size();
            if(mct > ct){
                ct = mct;
                mostMembers = gym;
            }
        }
        return mostMembers;
    }
}
