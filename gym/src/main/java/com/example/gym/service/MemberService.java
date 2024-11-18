package com.example.gym.service;

import com.example.gym.model.Gym;
import com.example.gym.model.Member;
import com.example.gym.model.Trainer;
import com.example.gym.repository.GymRepository;
import com.example.gym.repository.MemberRepository;
import com.example.gym.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    private TrainerRepository trainerRepository;

    public String addMember(Member member) {
        Member saveMember = memberRepository.save(member);
        return "Member added Successfully";
    }

    public Member findMemberWithMostTrainers() {
        List<Member> members = memberRepository.findAll();
        Member memberWithMostTrainers = null;
        int maxTrainerCount = 0;

        for (Member member : members) {
            int trainerCount = member.getTrainers().size();
            if (trainerCount > maxTrainerCount) {
                maxTrainerCount = trainerCount;
                memberWithMostTrainers = member;
            }
        }

        return memberWithMostTrainers;
    }

    public long countMembersWithTrainersInMultipleGyms() {
        List<Trainer> trainers = trainerRepository.findAll();
        Set<Member> membersTrainedByMultipleGyms = new HashSet<>();

        for(Trainer trainer : trainers){
            if(trainer.getGyms().size() > 1){
                membersTrainedByMultipleGyms.addAll(trainer.getMembers());
            }
        }

        return membersTrainedByMultipleGyms.size();
    }
}
