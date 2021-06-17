package service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RegistrationFormRepository;
import domain.RegistrationFormFaculty;
import service.RegistrationAtFacultyService;

@Service
public class RegistrationAtFacultyServiceImpl implements RegistrationAtFacultyService {

	private Logger logger = LoggerFactory.getLogger(RegistrationAtFacultyServiceImpl.class);

	@Autowired
	private RegistrationFormRepository registrationFormRepository;

	public void save(RegistrationFormFaculty facultyRegistration) {
		logger.info("Create new registration at faculty: " + facultyRegistration);
		registrationFormRepository.save(facultyRegistration);
	}

	public List<RegistrationFormFaculty> showAllEntrants() {
		logger.info("Get all Entrants");
		return registrationFormRepository.findAll();
	}
}