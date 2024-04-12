package com.lbg.project.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.project.domain.Message;
import com.lbg.project.service.MessageService;

@RestController
@CrossOrigin
@RequestMapping("/message")
public class MessageController {

	public MessageService service;

	public MessageController(MessageService service) {
		super();
		this.service = service;
	}

	// Create message

	@PostMapping("/create")
	public ResponseEntity<Message> createMessage(@RequestBody Message newMessage) {
		return this.service.createMessage(newMessage);
	}

	// Get all messages
	@GetMapping("/get")
	public List<Message> getMessages() {
		return this.service.getMessages();
	}

	// Get message by ID
	@GetMapping("/get/{id}")
	public ResponseEntity<Message> getMessage(@PathVariable int id) {
		return this.service.getMessage(id);
	}

	// Update message by ID
	@PutMapping("/update/{id}")
	public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message messageDetails) {
		return this.service.updateMessage(id, messageDetails);
	}

	// Delete message by ID
	@DeleteMapping("/remove/{id}")
	public boolean deleteMessage(@PathVariable int id) {
		return this.service.deleteMessage(id);
	}

}
