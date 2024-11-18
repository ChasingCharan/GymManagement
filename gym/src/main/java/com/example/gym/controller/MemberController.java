package com.example.gym.controller;


import com.example.gym.model.Gym;
import com.example.gym.model.Member;
import com.example.gym.service.GymService;
import com.example.gym.service.MemberService;
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
@RequestMapping("/api/v1/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping
    public ResponseEntity<String> addMember(@RequestBody Member member){
        String response = memberService.addMember(member);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/memberWithMostTrainers")
    public Member getMemberWithMostTrainers() {
        return memberService.findMemberWithMostTrainers();
    }

    @GetMapping("/membersWithTrainersInMultipleGyms")
    public long getMembersWithTrainersInMultipleGyms() {
        return memberService.countMembersWithTrainersInMultipleGyms();
    }

}
