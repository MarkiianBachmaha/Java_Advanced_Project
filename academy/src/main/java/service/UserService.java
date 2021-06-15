package service;

import domain.User;

public interface UserService {

	public void save(User user);

	public User findByEmail(String email);
}