package com.lbg.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.project.domain.Message;
import com.lbg.project.repo.MessageRepo;

@Service
public class MessageService {

	public MessageRepo repo;

	public MessageService(MessageRepo repo) {
		super();
		this.repo = repo;
	}

	// Create a Message
	public ResponseEntity<Message> createMessage(Message newMessage) {
		Message created = this.repo.save(newMessage);
		return new ResponseEntity<Message>(created, HttpStatus.CREATED);
	}

	// Find all Messages
	public List<Message> getMessages() {
		return this.repo.findAll();
	}

	// Find message by ID
	public ResponseEntity<Message> getMessage(int id) {
		Optional<Message> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Message>(HttpStatus.NOT_FOUND);
		}

		Message body = found.get();
		return ResponseEntity.ok(body);

	}

	// Update message by ID
	public ResponseEntity<Message> updateMessage(int id, Message messageDetails) {
		Optional<Message> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Message>(HttpStatus.NOT_FOUND);
		}

		Message exists = found.get();

		if (messageDetails.getUsername() != null) {
			exists.setUsername(messageDetails.getUsername());
		}

		if (messageDetails.getMessage() != null) {
			exists.setMessage(messageDetails.getMessage());
		}
		if (messageDetails.getImageUrl() != null) {
			exists.setImageUrl(messageDetails.getImageUrl());
		}

		Message updated = this.repo.save(exists);

		return ResponseEntity.ok(updated);
	}

	// Delete message by ID

	public boolean deleteMessage(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
