package com.technoelevate.postsharing.service;

import com.technoelevate.postsharing.model.User;
import com.technoelevate.postsharing.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public User getUserByUsername(String username) {
		log.info("logged in username {}", username);
		return userRepository.findUserByUsername(username).orElseThrow(() -> new RuntimeException("user not found!"));
	}

	public User getUserById(String id) {
		return userRepository.findUserById(id).orElseThrow(() -> new RuntimeException("user not found!"));
	}

	protected boolean isUserContains(final List<User> list, final String username) {
		return list.stream().anyMatch(o -> o.getUsername().equals(username));
	}

}
