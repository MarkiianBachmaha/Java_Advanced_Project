package dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public Optional<User> findByEmail(String email);
}