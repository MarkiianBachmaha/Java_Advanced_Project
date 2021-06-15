package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RegistrationFormRepository;
import domain.RegistrationFormFaculty;
import service.RegistrationAtFacultyService;

@Service
public class RegistrationAtFacultyServiceImpl implements RegistrationAtFacultyService {

	@Autowired
	private RegistrationFormRepository registrationFormRepository;

	public void save(RegistrationFormFaculty facultyRegistration) {
		registrationFormRepository.save(facultyRegistration);
	}

	public List<RegistrationFormFaculty> showAllEntrants() {
		return registrationFormRepository.findAll();
	}
}