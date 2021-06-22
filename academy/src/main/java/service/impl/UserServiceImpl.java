package service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dao.UserRepository;
import domain.User;
import domain.UserRole;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	public User save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setPassword(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
		user.setRole(UserRole.USER);
		logger.info("Save new user: " + user);
		return userRepository.save(user);
	}

	public Optional<User> findByEmail(String email) {
		logger.info("Find user{} by email (" + email + ")");
		return userRepository.findByEmail(email);
	}

	@Override
	public Optional<User> findById(Integer id) {
		logger.info("Find user by id (" + id + ")");
		return userRepository.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}
}