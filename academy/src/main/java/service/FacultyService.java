package service;

import java.util.List;

import domain.Faculty;

public interface FacultyService {

	public void save(Faculty faculty);

	public List<Faculty> getAllFaculties();

	public Faculty findById(Integer id);
}