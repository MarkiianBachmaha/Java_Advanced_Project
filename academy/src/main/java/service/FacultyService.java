package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.FacultyRepository;
import domain.Faculty;

@Service
public class FacultyService {

	@Autowired
	private FacultyRepository facultyRepository;

	public void save(Faculty faculty) {
		facultyRepository.save(faculty);
	}

	public List<Faculty> getAllFaculties() {
		return facultyRepository.findAll();
	}

	public Faculty findById(Integer id) {
		return facultyRepository.findById(id).get();
	}
}