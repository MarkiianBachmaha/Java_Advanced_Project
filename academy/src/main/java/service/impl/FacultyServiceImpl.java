package service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.FacultyRepository;
import domain.Faculty;
import service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {

	private Logger logger = LoggerFactory.getLogger(FacultyServiceImpl.class);

	@Autowired
	private FacultyRepository facultyRepository;

	public void save(Faculty faculty) {
		logger.info("Save faculty: " + faculty);
		facultyRepository.save(faculty);
	}

	public List<Faculty> getAllFaculties() {
		logger.info("Get all faculties");
		return facultyRepository.findAll();
	}

	public Faculty findById(Integer id) {
		logger.info("Find faculty by id: " + id);
		return facultyRepository.findById(id).get();
	}
}