package service;

import java.util.List;
import java.util.Optional;

import domain.User;

public interface UserService {

	public User save(User user);

	public Optional<User> findByEmail(String email);

	public Optional<User> findById(Integer id);

	public List<User> findAll();

	public void deleteById(Integer id);
}