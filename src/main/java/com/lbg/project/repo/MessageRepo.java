package com.lbg.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.project.domain.Message;

public interface MessageRepo extends JpaRepository<Message, Integer> {

}
