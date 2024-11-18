package com.example.gym.repository;

import com.example.gym.model.Gym;
import com.example.gym.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {
}
