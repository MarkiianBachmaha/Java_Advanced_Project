package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.RegistrationFormFaculty;

public interface RegistrationFormRepository extends JpaRepository<RegistrationFormFaculty, Integer> {

}