package service;

import java.util.List;
import java.util.Optional;

import domain.Faculty;

public interface FacultyService {

	public Faculty save(Faculty faculty);

	public List<Faculty> getAllFaculties();

	public Optional<Faculty> findById(Integer id);

	public void deleteById(Integer id);
}